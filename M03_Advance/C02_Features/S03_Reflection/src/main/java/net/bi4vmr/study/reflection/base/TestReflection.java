package net.bi4vmr.study.reflection.base;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试代码 - 反射。
 *
 * @author bi4vmr@outlook.com
 */
public class TestReflection {

    public static void main(String[] args) {
        example06();
    }

    /**
     * 示例：获取类的Class对象。
     * <p>
     * 在本示例中，我们通过不同的方式获取自定义类Father的Class对象。
     */
    static void example01() {
        try {
            // 方式一：通过"<类>.class"获取Class对象
            Class<Animal> clazz1 = Animal.class;

            // 方式二：通过"<对象>.getClass()"方法获取Class对象
            Animal animal = new Animal();
            Class<?> clazz2 = animal.getClass();

            // 方式三：通过"Class.forName("<类的完全限定名称>")"获取Class对象
            Class<?> clazz3 = Class.forName("net.bi4vmr.study.reflection.base.Animal");

            System.out.println(clazz1);
            System.out.println(clazz2);
            System.out.println(clazz3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：获取类的Class对象 - 基本数据类型与引用数据类型。
     * <p>
     * 在本示例中，我们分别获取"int"类型与Integer类型的Class对象。
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

            System.out.println(clazz1.isPrimitive());
            System.out.println(clazz2.isPrimitive());
            System.out.println(clazz3.isPrimitive());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：获取类的Class对象 - 其他类型。
     * <p>
     * 在本示例中，我们获取"void"类型与数组类型的Class对象。
     */
    static void example03() {
        try {
            // 获取基本数据类型"void"的Class对象。
            Class<?> clazz1 = void.class;

            // 获取"int"数组的Class对象。
            Class<?> clazz2 = int[].class;

            // 获取"String"多维数组的Class对象。
            Class<?> clazz3 = String[][].class;

            System.out.println(clazz1);
            System.out.println(clazz2);
            System.out.println(clazz3);

            System.out.println(clazz1.isArray());
            System.out.println(clazz2.isArray());
            System.out.println(clazz3.isArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：获取类的信息 - 基本信息。
     * <p>
     * 在本示例中，我们获取类的Class对象，并获取类的基本信息。
     */
    static void example04() {
        // 获取Class对象
        Class<String> clazz = String.class;

        // 获取完全限定名称
        String canonicalName = clazz.getCanonicalName();
        // 获取类名
        String simpleName = clazz.getSimpleName();
        // 获取包名
        String packageName = clazz.getPackageName();
        // 获取父类Class对象
        Class<? super String> superClass = clazz.getSuperclass();

        System.out.println("完全限定名称：" + canonicalName);
        System.out.println("类名：" + simpleName);
        System.out.println("包名：" + packageName);
        System.out.println("父类：" + superClass);
    }

    /**
     * 示例：获取类的信息 - 获取成员变量信息。
     */
    static void example05() {
        Human son = new Human("田所浩二", 24);
        Class<?> clazz = son.getClass();

        // 输出
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("Field：" + field);
        }
        System.out.println("=============");
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("Field：" + field);
        }
    }

    /**
     * 示例：获取类的信息 - 访问成员变量。
     * <p>
     * 在本示例中，我们通过反射对成员变量进行读写。
     */
    static void example06() {
        Human human = new Human("田所浩二", 24);
        Class<?> clazz = human.getClass();

        try {
            /* 读取成员变量 */
            // 获取变量
            Field field = clazz.getDeclaredField("age");
            // 解除私有变量的访问检查
            field.setAccessible(true);
            // 获取变量值
            Object age = field.get(human);
            // 转换变量类型
            if (age instanceof Integer) {
                Integer value = (Integer) age;
                System.out.println("变量age的值：" + value);
            }

            /* 写入成员变量 */
            // 写入变量
            field.set(human, 25);
            System.out.println("修改后的对象：" + human);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 示例：获取类的信息 - 属性与方法。
     */
    static void example066666666666666() {
        //
        Human son = new Human("田所浩二", 24);
        // 获取Class对象
        Class<?> clazz = son.getClass();

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("Field：" + field);
        }
        System.out.println("=============");
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("Field：" + field);
        }

        System.out.println("=============");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("Method：" + method);
        }
        System.out.println("=============");
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println("Method：" + method);
        }

        System.out.println("=============");

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor：" + constructor);
        }
        System.out.println("=============");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation：" + annotation);
        }

        Annotation[] annotations2 = clazz.getDeclaredAnnotations();
        for (Annotation annotation : annotations2) {
            System.out.println("dd annotation：" + annotation);
        }

        System.out.println("=============");
        try {
//            Field field = clazz.getField("name");
//            Object name = field.get(son);
//            System.out.println(name.getClass());

            Field field2 = clazz.getDeclaredField("age");
            field2.setAccessible(true);
            Object age = field2.get(son);
            System.out.println(age);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
