package net.bi4vmr.study.base.ch05;

import java.util.Arrays;

/**
 * Name        : ArrayDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-27 23:18
 * <p>
 * Description : 数组示例。
 */
public class ArrayDemo {

    public static void main(String[] args) {
        example08();
    }

    /*
     * 基本应用
     */
    static void example01() {
        // 定义一个长度为5的字符串数组，保存考试科目信息
        String[] subjects = new String[5];
        // 分别为数组中的元素赋值
        subjects[0] = "Oracle";
        subjects[1] = "PHP";
        subjects[2] = "Linux";
        subjects[3] = "Java";
        subjects[4] = "HTML";
        // 访问第四个元素
        System.out.println("数组中第4个科目为：" + subjects[3]);
    }

    /*
     * 初始化数组
     */
    static void example02() {
        // 创建包含三个元素的整型数组
        int[] array = new int[3];
        // 查看元素的默认值
        System.out.print("默认值：");
        System.out.print(array[0] + " ");
        System.out.print(array[1] + " ");
        System.out.println(array[2]);

        // 初始化数组，将所有元素的值设为100。
        Arrays.fill(array, 100);
        // 查看填充后各元素的值
        System.out.print("填充后：");
        System.out.print(array[0] + " ");
        System.out.print(array[1] + " ");
        System.out.print(array[2]);
    }

    /*
     * 使用循环语句操作数组
     */
    static void example03() {
        // 定义一个长度为3的字符串数组。
        String[] hobbys = {"sports", "game", "movie"};
        System.out.println("循环输出数组中元素的值：");
        // 使用循环遍历数组中的元素
        for (int i = 0; i < hobbys.length; i++) {
            System.out.println(hobbys[i]);
        }
    }

    /*
     * 使用"foreach"操作数组
     */
    static void example04() {
        // 定义一个整型数组，保存成绩信息
        int[] scores = {89, 72, 64, 58, 93};
        // 使用foreach遍历输出数组中的元素
        for (int score : scores) {
            System.out.print(score + "; ");
        }
    }

    /*
     * 复制数组（错误示范）
     */
    static void example05() {
        int[] array1 = {1, 2, 3};
        // 定义"array2"并将"array1"赋值给它
        int[] array2 = array1;
        //输出"array1"和"array2"的内存地址
        System.out.println(array1);
        System.out.println(array2);
        // 更改"array1"的第一个元素
        array1[0] = 10;
        // 输出"array2"的第一个元素
        System.out.println(array2[0]);
    }

    /*
     * 复制数组（正确示范）
     */
    static void example06() {
        // 创建包含3个元素的整型数组
        int[] array1 = {1, 2, 3};
        // 复制数组
        int[] array2 = Arrays.copyOfRange(array1, 0, array1.length);
        // 查看内存地址
        System.out.println(array1);
        System.out.println(array2);
    }

    /*
     * 使用Arrays类操作数组
     */
    static void example07() {
        int[] scores = {89, 72, 64, 58, 93};
        // 使用"sort()"方法对数组进行排序
        Arrays.sort(scores);

        System.out.print("升序排列结果：");
        for (int score : scores) {
            System.out.print(score + ";");
        }
        System.out.println();

        // 使用"toString()"方法将数组转换为字符串
        String i = Arrays.toString(scores);
        System.out.print("数组内容：" + i);
    }

    /*
     * 尝试声明并访问二维数组。
     */
    static void example08() {
        // 定义2行3列的二维数组并赋值
        String[][] names = {{"tom", "jack", "mike"}, {"张三", "李四", "王五"}};
        // 通过二重循环输出二维数组中元素的值
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                System.out.println(names[i][j]);
            }
            System.out.println();
        }
    }
}
