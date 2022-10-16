package tech.snnukf.java8study.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @className: SexEnum
 * @description: 性别枚举
 * @author: simple.jbx
 * @date: 2022/8/7
 **/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SexEnum {
    MALE(1, "男"),
    FEMAL(2, "女"),
    OTHER(3, "其他");

    @EnumValue
    private Integer code;
    private String desc;

    public Integer codeOf(String sex) {
        return 0;
    }
}
