package net.bi4vmr.study.utils.ch04;

import java.util.ArrayList;
import java.util.List;

/**
 * Name        : CollectionUtil
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-07-20 23:50
 * <p>
 * Description : 集合相关工具。
 */
public class CollectionUtils {

    public static void main(String[] args) {
        example04();
    }

    /*
     * 创建一个列表存放String，然后向其中添加内容。
     */
    static void example01() {
        List<String> list = new ArrayList<>();
        // 新增元素
        list.add("A");
        list.add("B");
        list.add("C");
        // 显示List内容
        System.out.println(list);

        // 在2号位置插入元素，后移其他元素。
        list.add(2,"TEST");
        // 显示List内容
        System.out.println(list);
    }

    /*
     * 查询指定位置的元素。
     */
    static void example02() {
        List<String> list = new ArrayList<>();
        // 新增元素
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // 查询指定位置的元素
        String item2 = list.get(2);
        System.out.println(item2);
    }

    /*
     * 替换指定位置的元素。
     */
    static void example03() {
        List<String> list = new ArrayList<>();
        // 新增元素
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("原始列表："+list);

        // 替换指定位置的元素
        String newItem = "TEST";
        String item2 = list.set(2,newItem);
        System.out.println("替换操作后的列表："+list);
        System.out.println("被替换的旧元素："+item2);
    }

    /*
     * 移除指定位置的元素。
     */
    static void example04() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("原始列表："+list);

        // 移除指定位置的元素
        String item2 = list.remove(2);
        System.out.println("替换操作后的列表："+list);
        System.out.println("被替换的旧元素："+item2);
    }
}
