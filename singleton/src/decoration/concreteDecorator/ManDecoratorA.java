package decoration.concreteDecorator;

import decoration.decorator.Decorator;

public class ManDecoratorA extends Decorator {

    @Override
    public void eat() {
        super.eat();
        System.out.println("再来一碗");
    }
}
