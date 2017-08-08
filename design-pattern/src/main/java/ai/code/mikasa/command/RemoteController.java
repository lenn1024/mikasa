package ai.code.mikasa.command;

/**
 * Created by lenn on 16/11/28.
 */
public class RemoteController {
    private Command slot;

    public RemoteController(Command slot) {
        this.slot = slot;
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed(){
        slot.execute();
    }

    public void undo(){
        slot.undo();
    }
}
