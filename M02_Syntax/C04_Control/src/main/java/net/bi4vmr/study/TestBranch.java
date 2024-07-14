package net.bi4vmr.study.base.ch03;

/**
 * Name        : BranchDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-09-18 16:08
 * <p>
 * Description : 分支结构示例。
 */
public class TestBranch {

    public static void main(String[] args) {
        example06();
    }

    /*
     * 给定两个整数a和b，当a的值比b的值大时，在控制台上输出结果。
     */
    static void example01() {
        int a = 2;
        int b = 1;

        // "if"的基本结构（简化写法）
        if (a > b) System.out.println("a is bigger than b.");

        // "if"的基本结构（完整写法）
        if (a > b) {
            System.out.println("a is bigger than b.");
        }
    }

    /*
     * 输入一个年龄，当年龄低于18岁时，在控制台上输出文本“未成年人”；否则输出“成年人”。
     */
    static void example02() {
        int age = 17;
        if (age >= 18) {
            System.out.println("成年人");
        } else {
            System.out.println("未成年人");
        }
    }

    /*
     * 输入一个百分制的成绩，并在控制台上输出成绩所属的等第。
     *
     * 当成绩大于90分时等第为“优”；当成绩属于区间 `(90, 75]` 时等第为“良”；
     * 当成绩属于区间 `(75, 60]` 时等第为“中”，当成绩低于60分时等第为“差”。
     */
    static void example03() {
        int score = 60;
        System.out.print("等第为：");
        if (score >= 90) {
            System.out.println("优");
        } else if (score >= 75) {
            System.out.println("良");
        } else if (score >= 60) {
            System.out.println("中");
        } else {
            System.out.println("差");
        }
    }

    /*
     * 给定一个表示季度的整数，范围为： `[1, 4]` ，将其转换为对应的季度编号。
     */
    static void example04() {
        int x = 2;
        switch (x) {
            case 1:
                System.out.print("Q1");
                break;
            case 2:
                System.out.print("Q2");
                break;
            case 3:
                System.out.print("Q3");
                break;
            case 4:
                System.out.print("Q4");
                break;
            default:
                System.out.print("输入值不合法");
                break;
        }
    }

    /*
     * 给定一个表示季度的整数，范围为： `[1, 4]` ，将其转换为“上半年”或“下半年”文本。
     */
    static void example05() {
        int x = 2;
        switch (x) {
            case 1:
            case 2:
                System.out.print("上半年");
                break;
            case 3:
            case 4:
                System.out.print("下半年");
                break;
            default:
                System.out.print("输入值不合法");
                break;
        }
    }

    /*
     * 输入一个数字，判断它与区间 `[4, 6]` 的关系。
     */
    static void example06() {
        int x = 5;
        if (x > 4) {
            if (x > 6) {
                System.out.println("x大于6");
            } else {
                System.out.println("x在4~6之间");
            }
        } else {
            System.out.println("x小于等于4");
        }
    }
}
