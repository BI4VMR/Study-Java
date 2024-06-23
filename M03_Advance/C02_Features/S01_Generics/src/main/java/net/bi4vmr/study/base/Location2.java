package net.bi4vmr.study.base;

/**
 * 坐标类（使用泛型）。
 *
 * @author BI4VMR。
 */
public class Location2<T1, T2> {

    // 变量"x"和"y"的类型由外部调用者决定
    private T1 x;
    private T2 y;

    // 构造实例并设置坐标
    public Location2(T1 x, T2 y) {
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
}
