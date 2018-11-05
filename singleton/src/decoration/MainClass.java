package decoration;

import decoration.concreteComponent.Man;
import decoration.concreteDecorator.ManDecoratorA;

/**
 * @author wufangyu
 * 装饰模式指的是在不必改变原类文件和使用继承的情况下,动态的扩展一个对象的功能.它是通过创建一个包装对象,也就是装饰来包裹真实的对象
 * 在不影其他对象的情况下,以动态,透明的方式给单个对象添加职责   处理那些可以撤销的职责
 * 当不能采用生成子类的方法进行扩充时。
 * 一种情况是，可能有大量独立的扩展，为支持每一种组合将产生大量的 子类，使得子类数目呈爆炸性增长。另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。
 * 5、涉及角色
 * （1）抽象组件:定义一个抽象接口，来规范准备附加功能的类
 * （2）具体组件：将要被附加功能的类，实现抽象构件角色接口
 * （3）抽象装饰者：持有对具体构件角色的引用并定义与抽象构件角色一致的接口
 * （4）具体装饰：实现抽象装饰者角色，负责对具体构件添加额外功能。
 */
public class MainClass {

    public static void main(String[] args) {

        Man man = new Man();

        ManDecoratorA manDecoratorA = new ManDecoratorA();
        manDecoratorA.setPerson(man);
        manDecoratorA.eat();

    }

}
