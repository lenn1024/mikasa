package ai.code.mikasa.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedObject implements Delayed {

    // 名字
    private String data;
    // 延迟的时间（毫秒）
    private long delay;
    // 过期的时间
    private long expire;

    public DelayedObject(int delay, String data) {
        this.delay = delay;
        this.data = data;

        this.expire = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"data\":\"")
                .append(data).append('\"');
        sb.append(",\"delay\":")
                .append(delay);
        sb.append(",\"expire\":")
                .append(expire);

        sb.append('}');
        return sb.toString();
    }
}
