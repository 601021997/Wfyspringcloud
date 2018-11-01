/**
 * 懒汉式2不能保证线程安全
 */
public class Person3 {

    private static Person3 person2 = null;

    /**
     * 对外提供访问方法
     * 增加同步方法  变为线程安全的
     * @return
     */
    public static synchronized Person3 getPerson2(){
        if (person2 ==null ){
            return new Person3();
        }else{
           return  person2;
        }
    }

    /**
     * 私有化构造方法
     */
    private Person3(){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
