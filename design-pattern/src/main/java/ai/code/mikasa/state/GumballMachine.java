package ai.code.mikasa.state;

/**
 * Created by lenn on 16/12/4.
 */
public class GumballMachine {
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State soldOutState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs){
        // 初始化状态对象
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        // 初始化糖果数量
        this.count = numberGumballs;
        if(this.count > 0){
            state = noQuarterState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    void setState(State state){
        this.state = state;
    }

    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if(this.count != 0){
            this.count = this.count - 1;
        }
    }
}
