package net.bi4vmr.study.base.ch03;

/**
 * Name        : IfDemo
 * Author      : BI4VMR
 * Email       : bi4vmr@qq.com
 * Date        : 2022-09-18 16:42
 * Description : "if"语句示例
 */
public class IfDemo {
    public static void main(String[] args) {
        // "if"的基本结构（执行单条语句）
        int a = 2;
        int b = 1;
        if (a > b) System.out.println("a is bigger than b.");

        // "if"的基本结构（执行多条语句）
        if (a > b) {
            System.out.println("a is bigger than b.");
            System.out.println("test");
        }
    }
}
