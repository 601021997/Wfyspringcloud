package decoration.decorator;

import decoration.component.Person;

/**
 * @author wufangyu
 *装饰者抽象类  维持一个指向component的引用,并定义一个与Component接口一致的接口
 *
 */
public abstract class Decorator implements Person {

    private Person person;

    @Override
    public void eat(){
        person.eat();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
