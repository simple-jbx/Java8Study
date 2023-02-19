package tech.snnukf.java8study.uml.association;

import java.util.List;

/**
 * 体现的是两个类、或者类与接口之间语义级别的一种强依赖关系
 * 关联 Zoo与Monkey之间是关联关系
 * 这种关系比依赖更强、不存在依赖关系的偶然性、关系也不是临时性的，一般是长期性的，而且双方的关系一般是平等的、关联可以是单向、双向的
 * 在代码层面，为被关联类B以类属性的形式出现在关联类A中，也可能是关联类A引用了一个类型为被关联类B的全局变量；
 *
 * @className: Zoo
 * @author: simple.jbx
 * @date: 2023/2/19
 **/
public class Zoo {
    private List<Monkey> monkeys;
}
