package net.bi4vmr.study;

/**
 * 测试代码：分支结构。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestBranch {

    public static void main(String[] args) {
        example06();
    }

    /**
     * 示例一："if"语句的基本应用。
     * <p>
     * 在本示例中，我们给定两个整数，当 `a` 的值比 `b` 的值大时，在控制台上输出结果。
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

    /**
     * 示例二："if-else"语句的基本应用。
     * <p>
     * 在本示例中，我们给定一个年龄，当年龄低于18岁时，在控制台上输出文本“未成年人”；否则输出“成年人”。
     */
    static void example02() {
        int age = 17;
        if (age >= 18) {
            System.out.println("成年人");
        } else {
            System.out.println("未成年人");
        }
    }

    /**
     * 示例三：多重"if-else"语句的基本应用。
     * <p>
     * 在本示例中，我们给定一个百分制的成绩，并在控制台上输出成绩所属的等第。
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

    /**
     * 示例四："switch"语句的基本应用。
     * <p>
     * 在本示例中，我们给定一个表示季度的整数，范围为： `[1, 4]` ，并通过"switch"语句将其转换为对应的季度编号。
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

    /**
     * 示例五：省略"break"语句以合并相同的分支。
     * <p>
     * 在本示例中，我们给定一个表示季度的整数，范围为： `[1, 4]` ，并通过"switch"语句将其转换为“上半年”或“下半年”文本。
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

    /**
     * 示例六：判断输入值与区间的关系。
     * <p>
     * 在本示例中，我们给定一个数字，判断它与区间 `(4, 6)` 的关系。
     */
    static void example06() {
        int x = 5;
        if (x > 4) {
            if (x > 6) {
                System.out.println("x大于6");
            } else {
                System.out.println("x在4到6之间");
            }
        } else {
            System.out.println("x小于等于4");
        }
    }
}
