package net.bi4vmr.study.base;

/**
 * 坐标类（未使用泛型）。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class Location1 {

    private Object x, y;

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
