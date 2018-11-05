package singleton;

/**
 * @author
 * 饿汉式  单例模式
 */
public class Person {

    private static final Person PERSON = new Person();

    /**
     * 私有化构造法法
     */
    private Person(){

    }

    public static Person getPerson(){
        return PERSON;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



}
