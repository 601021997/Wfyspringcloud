package decoration.concreteComponent;

import decoration.component.Person;

/**
 * @author wufangyu
 * concreteConponent  具体被装饰的对象  可以给这些对象增加一些职责
 */
public class Man implements Person {
    @Override
    public void eat() {

        System.out.println("男人再吃");

    }
}
