package tech.snnukf.java8study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description:
 *
 * @className: Feature
 * @author: simple.jbx
 * @date: 2022/10/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feature<T> implements Serializable {
    public int weight;
    private int sex;
    private T mark;
}
