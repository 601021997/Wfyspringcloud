package singleton;

/**
 * 懒汉式2不能保证线程安全
 */
public class Person2 {

    private static  Person2 person2 = null;

    /**
     * 对外提供访问方法
     * @return
     */
    public static  Person2 getPerson2(){
        if (person2 ==null ){
            return new Person2();
        }else{
           return  person2;
        }
    }

    /**
     * 私有化构造方法
     */
    private Person2(){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
