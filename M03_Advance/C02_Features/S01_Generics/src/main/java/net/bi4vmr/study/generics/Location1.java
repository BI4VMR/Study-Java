package net.bi4vmr.study.generics;

/**
 * 坐标类（未使用泛型）。
 *
 * @author BI4VMR。
 */
public class Location1 {

    private Object x, y;

    // 构造实例并设置坐标
    public Location1(Object x, Object y) {
        this.x = x;
        this.y = y;
    }

    // 设置坐标
    public void setXY(Object x, Object y) {
        this.x = x;
        this.y = y;
    }

    // 获取坐标(X)
    public Object getX() {
        return x;
    }

    // 获取坐标(Y)
    public Object getY() {
        return y;
    }
}
