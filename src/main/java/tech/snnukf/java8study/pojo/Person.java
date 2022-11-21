package tech.snnukf.java8study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tech.snnukf.java8study.inte.Action;

import javax.annotation.Resource;
import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.Serializable;

/**
 * Person类需要
 * 1.实现Serializable/Externalizable接口
 * 2.提供一个全局常量
 * 3.除了当前类需要实现Serializable接口外，
 * 还必须保证其内部所有属性也实现了序列化接口
 * 才能被序列化
 *
 * @className: Person
 * @author: simple.jbx
 * @date: 2022/10/16
 **/
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Resource
public class Person implements Serializable {

    public static final long serialVersionUID = 123456L;

    private int id;

    private String name;

    private int age;

    public String nickName;

    public static void showPreMess() {
        System.out.println("I'm not a robot");
    }

    public void show() {
        System.out.println("my name is " + name);
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void showNation(String nation) {
        System.out.println("my nation is " + nation);
    }

    public void showAge() throws NullPointerException {
        System.out.println(this.age);
    }
}
