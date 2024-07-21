package net.bi4vmr.study.reflection;

import java.lang.reflect.Field;

/**
 * 测试代码 - 反射。
 *
 * @author bi4vmr@outlook.com
 */
public class TestReflection {

    public static void main(String[] args) {
        example02();
    }

    /**
     * 示例：获取类的Class对象。
     */
    static void example01() {
        try {
            // 方式一：通过"<类>.class"获取Class对象
            Class<Father> clazz1 = Father.class;

            // 方式二：通过"<对象>.getClass()"方法获取Class对象
            Father father = new Father();
            Class<?> clazz2 = father.getClass();

            // 方式三：通过"Class.forName("<类的完全限定名称>")"获取Class对象
            Class<?> clazz3 = Class.forName("net.bi4vmr.study.reflection.Father");

            System.out.println(clazz1);
            System.out.println(clazz2);
            System.out.println(clazz3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：获取类的Class对象 - 基本数据类型与引用数据类型。
     */
    static void example02() {
        try {
            // 获取基本数据类型"int"的Class对象。
            Class<?> clazz1 = int.class;
            Class<Integer> clazz2 = Integer.TYPE;

            // 获取包装类Integer的Class对象。
            Class<?> clazz3 = Integer.class;

            System.out.println(clazz1);
            System.out.println(clazz2);
            System.out.println(clazz3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：获取类的信息。
     */
    static void example03() throws Exception {
        // 获取Class对象
        Class<Father> clazz = Father.class;

        // 获取完全限定名称
        String canonicalName = clazz.getCanonicalName();
        // 获取类名
        String simpleName = clazz.getSimpleName();
        // 获取包名
        String packageName = clazz.getPackageName();

        System.out.println("完全限定名称：" + canonicalName);
        System.out.println("类名：" + simpleName);
        System.out.println("包名：" + packageName);
    }

    /**
     * 示例：获取类的信息。
     */
    static void example04() {
        //
        Child child = new Child("张三", '男', 22);
        // 获取Class对象
        Class<?> clazz = child.getClass();

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("f：" + field);
        }
        System.out.println("=============");
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("f：" + field);
        }

//        clazz.getMethod("sss",Integer.TYPE);
//        clazz.getMethod("sss",int.class);

//        clazz.getMethod("sss",Integer.class);
    }
}
