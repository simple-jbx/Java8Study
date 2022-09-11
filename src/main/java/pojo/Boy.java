package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: Boy
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/9/7
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boy {
    private Girl girl;

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                "}";
    }
}
