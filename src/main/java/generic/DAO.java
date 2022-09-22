package generic;

import java.util.List;

/**
 * @className: DAO
 * @author: simple.jbx
 * @date: 2022/9/12
 **/
public class DAO<T> {
    //增删改查

    public void add(T t){};

    public boolean remove(int index) {
        return false;
    }

    public void update(int index, T t) {};

    public T getIndex(int index) {
        return null;
    }

    public List<T> getForList(int index) {
        return null;
    }

    //泛型方法
    //举例：获取表中一共有多少条记录/获取员工最大年龄
    public <E> E getValue() {
        return null;
    }
}
