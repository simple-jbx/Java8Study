package optional;

import org.junit.Test;
import pojo.Boy;
import pojo.Girl;

import java.nio.file.OpenOption;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @className: OptionalTest
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/9/10
 **/
public class OptionalTest {

    @Test
    public void test01() {
        Girl girl = new Girl();
        // girl 不能为null
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);

        Girl girl1 = null;
        //girl可以为null
        Optional<Girl> optionalGirl1 = Optional.ofNullable(girl1);
        System.out.println(optionalGirl1);

        Girl girl2 = new Girl("simple");
        Optional<Girl> optionalGirl2 = Optional.ofNullable(girl2);
        System.out.println(optionalGirl2.orElse(new Girl("test")));
    }
}
