package ai.code.mikasa.state;

/**
 * Created by lenn on 16/12/4.
 */
public class Client {
    public static void main(String[] args){
        GumballMachine gumballMachine = new GumballMachine(2);

        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
