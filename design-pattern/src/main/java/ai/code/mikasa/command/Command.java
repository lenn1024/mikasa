package ai.code.mikasa.command;

/**
 * Created by lenn on 16/11/28.
 */
public interface Command {
    void execute();
    void undo();
}
