package net.bi4vmr.study.base;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 示例代码：基本应用。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestBase {

    public static void main(String[] args) {
        example011();
    }

    /**
     * 示例一：将对象转换为JSON文本。
     * <p>
     * 在本示例中，我们将Student对象转换为对应的JSON文本。
     */
    static void example01() {

        Student s = new Student(1L, "Alice", 30);
        String t = new Gson().toJson(s);
        System.out.println(t);
    }

    // 空字段
    static void example02() {
        // 名称属性为null
        Student s = new Student(1L, null, 30);
        String t = new Gson().toJson(s);
        System.out.println(t);
    }

    // 将JSON文本转换为对象。
    static void example03() {
        String p = "{\"name\": \"Alice\", \"age\": 30}";
        Student s1 = new Gson().fromJson(p, Student.class);
        System.out.println("缺失基本类型字段: " + s1);
    }

    // 将JSON文本转换为对象。
    static void example04() {
        // 缺失基本类型字段
        String p = "{\"name\": \"Alice\", \"age\": 30}";
        Student s1 = new Gson().fromJson(p, Student.class);
        System.out.println("缺失基本类型字段: " + s1);

        // 缺失对象类型字段
        String p2 = "{ \"age\": 30}";
        Student s2 = new Gson().fromJson(p2, Student.class);
        System.out.println("缺失对象类型字段: " + s2);

        // 基本字段为null
        String p3 = "{\"name\": null, \"age\": 30}";
        Student s3 = new Gson().fromJson(p3, Student.class);
        System.out.println(" 字段为null: " + s3);

        String p4 = "{\"name\": null, \"age\": 30}";
        Student s4 = new Gson().fromJson(p4, Student.class);
        System.out.println(" 字段为null: " + s4);
    }

    // 注解
    static void example05() {
        String p4 = "{\"name\": null, \"age\": 30}";
        Student s4 = new Gson().fromJson(p4, Student.class);
        System.out.println(" 字段为null: " + s4);
    }

    // 构建JSON
    static void example011() {
        JsonObject o = new JsonObject();
        o.addProperty("id", 1234567890123456789L);
        o.addProperty("name", "Alice");
        o.addProperty("isStudent", true);
        o.addProperty("score", 95.5);
        System.out.println(o);
    }
}
