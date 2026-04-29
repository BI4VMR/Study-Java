package net.bi4vmr.study.base;

/**
 * 坐标类（使用泛型）。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class Location2<T1, T2> {

    // 变量的类型由调用者决定
    private T1 x;
    private T2 y;

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
