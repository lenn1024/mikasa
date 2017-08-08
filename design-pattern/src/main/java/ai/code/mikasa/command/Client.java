package ai.code.mikasa.command;

/**
 * Created by lenn on 16/11/27.
 */
public class Client {

    public static void main(String[] args){
        // 实际命令执行者
        Light light = new Light();
        // 命令
        Command slot = new LightCommand(light);
        // 控制器
        RemoteController remoteController = new RemoteController(slot);
        // 通过按键执行命令
        remoteController.buttonWasPressed();
    }
}
