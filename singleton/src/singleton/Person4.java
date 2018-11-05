package singleton;

/**
 * 懒汉式2不能保证线程安全
 */
public class Person4 {

    private static Person4 person2 = null;

    /**
     * 对外提供访问方法
     * 增加同步方法  变为线程安全的
     * 提供双重检查
     * @return
     */
    public static  Person4 getPerson2(){
       if (person2 == null){
           //只允许一个实例进行实例化对象
            synchronized (Person4.class){
                if (person2 == null){
                    person2 =  new Person4();
                }
            }
       }
     return person2;
    }

    /**
     * 私有化构造方法
     */
    private Person4(){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
