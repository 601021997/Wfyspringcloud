package decoration.concreteDecorator;

import decoration.decorator.Decorator;

public class ManDecoratorB extends Decorator {

    @Override
    public void eat() {
        super.eat();
        System.out.println("ManB");
    }
}
