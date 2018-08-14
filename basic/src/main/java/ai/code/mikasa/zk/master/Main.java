package ai.code.mikasa.zk.master;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args){
        String connStr = "127.0.0.1:2181";
        for(int i = 0; i < 5; i++){
            long serverId = 10000L + i;
            String serverName = "server" + serverId;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    try {
                        ZooKeeper zkClient = new ZooKeeper(connStr, 5000, event -> {
                            if(event.getState() == Watcher.Event.KeeperState.SyncConnected){
                                countDownLatch.countDown();
                            }
                        });
                        countDownLatch.await();
                        ServerNode serverNode = new ServerNode(serverId, serverName, zkClient);
                        serverNode.vote();
                        System.out.println(Thread.currentThread().getName() + ": is Master:" + serverNode.isZkMaster());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
