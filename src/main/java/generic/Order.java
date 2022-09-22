package generic;

import lombok.Data;

/**
 * 自定义泛型类
 *
 * @className: Order
 * @author: simple.jbx
 * @date: 2022/9/12
 **/
@Data
public class Order<T> {
    String orderName;
    int orderId;

    //类内部就可以使用类的泛型
    T orderT;

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public Order() {}

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}
