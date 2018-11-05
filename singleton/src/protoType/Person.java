package protoType;

/**
 * 克隆模式
 * 深度克隆
 * 浅度克隆
 *
 * @author Wfy
 */
public class Person implements Cloneable {

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person clonePerson() {
        try {
            Person person = (Person) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }


}
