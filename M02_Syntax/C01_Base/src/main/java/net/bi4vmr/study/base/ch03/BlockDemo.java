package net.bi4vmr.study.base.ch03;

/**
 * Name        : BlockDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-09-18 16:08
 * <p>
 * Description : 代码块与作用域示例。
 */
public class BlockDemo {

    public static void main(String[] args) {
        example01();
    }

    /*
     * 变量的作用域
     */
    static void example01() {
        int i = 1;
        // 定义一个“块”
        {
            int x = 5;
            // 块的内部可以访问自己的变量与父级块的变量
            System.out.println("i:" + i + "; x:" + x);
        }
        // 块的外部不能访问块内部的变量
        System.out.println("i:" + i + "; x:can not be accessed!");
    }
}
