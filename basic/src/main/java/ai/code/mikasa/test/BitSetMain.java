package ai.code.mikasa.test;

import java.util.BitSet;
import java.util.Random;

/**
 * 使用bitset构造位图，判断一个数集是否包含对应数字
 */
public class BitSetMain {

    public static void main(String[] args){
        BitSetMain bitSetMain = new BitSetMain(10000);
        bitSetMain.init();

        if(bitSetMain.contain(1)){
            System.out.println("包含目标数字");
        }else {
            System.out.println("不包含目标数字");
        }
    }

    public BitSetMain(int maxNum) {
        this.maxNum = maxNum;
        this.bitSet = new BitSet(maxNum + 1);
    }

    private BitSet bitSet;
    private int maxNum;

    /**
     * 使用随机数初始化
     */
    public void init(){
        Random random = new Random();
        for(int i = 0; i < maxNum; i++){
            int index = random.nextInt(maxNum);
            bitSet.set(index);
        }
    }

    /**
     * 判断目标数字是否存在
     * @param target
     * @return
     */
    public boolean contain(int target){
        return bitSet.get(target);
    }
}
