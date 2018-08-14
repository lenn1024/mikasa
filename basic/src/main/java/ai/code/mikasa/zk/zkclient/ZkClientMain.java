package ai.code.mikasa.zk.zkclient;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class ZkClientMain {
    public static void main(String[] args){
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 5000);
        List<String> childrenNodes = zkClient.getChildren("/");
        childrenNodes.stream()
                .forEach(node -> System.out.println(node));

        zkClient.close();
    }
}
