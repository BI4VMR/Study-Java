package net.bi4vmr.study.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 坐标类（使用泛型）。
 *
 * @author BI4VMR。
 */
public class Location3<T1, T2> {

    // 变量"x"和"y"的类型由外部调用者决定
    private T1 x;
    private T2 y;

    // 构造实例并设置坐标
    public Location3(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    // 设置坐标
    public void setXY(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    // 获取坐标(X)
    public T1 getX() {
        return x;
    }

    // 获取坐标(Y)
    public T2 getY() {
        return y;
    }

    /**
     * 将数组转换为列表。
     * <p>
     * 该方法提供了一种将泛型数组转换为泛型列表的便捷方式。它避免了直接操作数组可能带来的局限性，比如数组长度不可变。
     * 使用列表可以使元素的添加、删除等操作更加灵活。
     *
     * @param <F>   泛型类型，表示数组和列表中元素的类型。
     * @param array 输入的泛型数组，将被转换为列表。
     * @return 返回一个新的列表，包含与输入数组相同的元素。
     */
    public static <F> List<F> arrayToList(F[] array) {
        List<F> list = new ArrayList<>();
        for (F item : array) {
            list.add(item);
        }
        return list;
    }

    /**
     * 非静态泛型方法。
     */
    public <F> F fun(F f, T1 x, T2 y) {
        // 该方法无实际意义，仅用于演示非静态泛型方法。
        return f;
    }
}
