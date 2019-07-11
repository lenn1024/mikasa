package ai.code.mikasa.id;

public class SnowFlakeIdGenerator {

    /**
     * 开始时间：2015-1-1
     * 微秒
     */
    private final long twepoch = 1420041600000L;

    /**
     * 机器id所占的位数
     */
    private final long workerIdBits = 5L;

    /**
     * 数据中心id所占的位数
     */
    private final long datacenterIdBits = 5L;

    /**
     * 支持的最大的机器id，此处为31
     */
    private final long maxWorkerId = -1L ^ (-1 << workerIdBits);

    /**
     * 支持的最大的数据中心的id，此处为31
     */
    private final long maxDatacenterId = -1 ^ (-1 << datacenterIdBits);

    /**
     * 序列id所占的位数
     */
    private final long sequenceBits = 12L;

    /**
     * 机器id需左移的偏移量(12)
     */
    private final long wokerIdShift = sequenceBits;

    /**
     * 数据中心id需左移的偏移量(5 + 12)
     */
    private final long datacenterIdShift = workerIdBits + sequenceBits;

    /**
     * 时间戳需左移的偏移量(5 + 5 + 12)
     */
    private final long timestampLeftShift = datacenterIdShift + workerIdBits + sequenceBits;

    /**
     * 生成序列id的掩码，这里为4095
     */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 工作机器id(0 ~ 31)
     */
    private long workerId;

    /**
     * 数据中心id(0 ~ 31)
     */
    private long datacenterId;

    /**
     * 毫秒内序列(0 ~ 4095)
     */
    private long sequence = 0L;

    /**
     * 上次生成ID的时间戳
     */
    private long lastTimestamp = -1L;

    public SnowFlakeIdGenerator(long workerId, long datacenterId) {
        if(workerId > maxWorkerId || workerId < 0){
            throw new IllegalArgumentException(String.format("workerId can't be greater than %s and less than 0.", workerId));
        }

        if(datacenterId > maxDatacenterId || datacenterId < 0){
            throw new IllegalArgumentException(String.format("datacenterId can't be greater than %s and less than 0.", datacenterId));
        }

        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }


    public synchronized long nextId(){
        long timestamp = timeGen();

        if(timestamp < lastTimestamp){
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds.", lastTimestamp - timestamp));
        }

        if(timestamp == lastTimestamp){
            sequence = (sequence + 1) & sequenceMask;
            //
            if(sequence == 0){
                timestamp = tilNextMillis(lastTimestamp);
            }
        }else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return (timestamp - twepoch) << timestampLeftShift
                | (datacenterId << datacenterIdShift)
                | (workerId << wokerIdShift)
                | sequence;
    }

    /**
     * 轮询到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp
     * @return
     */
    protected long tilNextMillis(long lastTimestamp){
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp){
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回当前的时间
     * @return
     */
    protected long timeGen(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args){
        SnowFlakeIdGenerator instance = new SnowFlakeIdGenerator(1, 5);

        for(int i = 0; i < 1000; i++){
            System.out.println(instance.nextId());
        }
    }
}
