package tech.snnukf.java8study.uml.dependency;

/**
 * 一个类A使用到了另一个类B，而这种使用关系是具有偶然性的、、临时性的、非常弱的，但是B类的变化会影响到A
 * 表现在代码层面，为类B作为参数被类A在某个method方法中使用；
 *
 * @className: Human
 * @author: simple.jbx
 * @date: 2023/2/19
 **/
public class Human {
    public void eat(Food food) {
    }
}
