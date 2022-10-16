package tech.snnukf.java8study.pojo;

import tech.snnukf.java8study.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;
/**
 * @className: User
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/7/31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@SuperBuilder
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;
}
