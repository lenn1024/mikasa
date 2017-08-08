package ai.code.mikasa.advanced.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by Lenn on 2017/5/31.
 */
public class ChannelTransfer {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("data/from.txt", "rw");
        FileChannel fromFileChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("data/to.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        int position = 0;
        long count = (int) fromFileChannel.size();

        toChannel.transferFrom(fromFileChannel, position, count);
    }
}
