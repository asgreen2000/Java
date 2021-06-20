class  QuackBehavior
{
    void quack() {}
}

class FlyBehavior
{
    void fly() {}
}

abstract class Duck {

QuackBehavior quackBehavior;
FlyBehavior flyBehavior;

public void performQuack() {
    quackBehavior.quack();
}

public void performFly() {
    flyBehavior.fly();
}

public void getClassName() {

    System.out.println(this.getClass());
}

}


class BlackDuck extends Duck {

}


public class App {
    public static void main(String[] args) throws Exception {
        
        Duck duck = new BlackDuck();

       duck.getClassName();

    }
}
