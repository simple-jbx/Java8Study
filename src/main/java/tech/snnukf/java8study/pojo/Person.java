package tech.snnukf.java8study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * //TODO... Description
 *
 * @className: Person
 * @author: simple.jbx
 * @date: 2022/10/16
 **/
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Feature{
    private String name;
    private int age;
    public String nickName;

    public void show() {
        System.out.println("my name is " + name);
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
