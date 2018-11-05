package reflect;

import model.Person;

/**
 * @author admin
 */
public class MainClass {

    public static void main(String[] args) {
        Person person = new Person();
        //获取clss对象
        Class aClass = person.getClass();
        Class personClass = Person.class;
        try {
            Class s  = Class.forName("Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
