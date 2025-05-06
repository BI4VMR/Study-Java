package net.bi4vmr.study;

/**
 * 测试代码：循环结构。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestLoop {

    public static void main(String[] args) {
        example12();
    }

    /**
     * 示例七："while"语句的基本应用。
     * <p>
     * 在本示例中，我们向控制台输出从"1"到"5"的所有整数。
     */
    static void example07() {
        int i = 1;
        // 当变量“小于等于5”时执行循环
        while (i <= 5) {
            // 输出变量的值，并且使变量加1。
            System.out.println(i);
            i++;
        }
    }

    /**
     * 示例八："do-while"语句的基本应用。
     * <p>
     * 在本示例中，我们计算"1"到"50"之间所有偶数之和，并将结果输出到控制台上。
     */
    static void example08() {
        // 保存 1-50 之间偶数的和
        int sum = 0;
        // 循环变量，代表 1-50 之间的偶数，每轮循环数值都将被改变一次。
        int num = 2;

        do {
            // 实现累加求和
            sum = sum + num;
            // 每执行一次将数值加2，以便下一轮循环进行条件判断。
            num = num + 2;
        } while (num <= 50);

        System.out.println("50以内的偶数之和为：" + sum);
    }

    /**
     * 示例九："for"语句的基本应用。
     * <p>
     * 在本示例中，我们计算"1"到"100"之间不能被"3"整除的数之和，并将结果输出到控制台上。
     */
    static void example09() {
        // 保存不能被3整除的数之和
        int sum = 0;

        // 循环变量i初始值为1,每执行一次对变量加1,只要小于等于100就重复执行循环。
        for (int i = 1; i <= 100; i++) {
            // 变量i与3进行取模，如果不等于0 ，则表示不能被3整除。
            if (i % 3 != 0) {
                // 累加求和
                sum = sum + i;
            }
        }

        System.out.print("1到100之间不能被3整除的数之和为：" + sum);
    }

    /**
     * 示例十：在控制台上输出三角形。
     * <p>
     * 在本示例中，我们使用"*"在控制台上输出直角三角形。
     */
    static void example10() {
        // 外层循环控制行数
        for (int i = 1; i <= 5; i++) {
            // 内层循环控制每行的*号数
            // 内层循环变量的最大值和外层循环变量的值相等
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 每打印完一行后进行换行
            System.out.println();
        }
    }

    /**
     * 示例十一："break"语句的基本应用。
     * <p>
     * 在本示例中，我们累加从"1"开始的正整数，并找出使和超过"20"的数字。
     */
    static void example11() {
        // 保存累加数值
        int sum = 0;
        for (int i = 1; ; i++) {
            // 每次循环时累加求和
            sum += i;
            // 判断累加数值是否大于20，如果满足条件则直接退出循环
            if (sum > 20) {
                System.out.println("当前的整数为: " + i);
                System.out.println("当前的累加数值为: " + sum);
                // 退出循环
                break;
            }
        }
    }

    /**
     * 示例十二："continue"语句的基本应用。
     * <p>
     * 在本示例中，我们计算"1"到"10"之间所有偶数之和。
     */
    static void example12() {
        // 保存累加值
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            // 如果i为奇数，不执行累加操作，直接结束本轮循环，进入下一轮循环操作。
            if (i % 2 != 0) {
                continue;
            }
            sum += i;
        }

        System.out.print("1到10之间的所有偶数的和为：" + sum);
    }
}
