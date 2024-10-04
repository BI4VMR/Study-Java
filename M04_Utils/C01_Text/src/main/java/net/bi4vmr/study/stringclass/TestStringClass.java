package net.bi4vmr.study.stringclass;

/**
 * 测试类：String类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestStringClass {

    public static void main(String[] args) {
        example06();
    }

    /**
     * 示例一：验证字符串的不变性。
     * <p>
     * 在本示例中，我们创建一个字符串对象，并更改字符串的内容，比较操作前后该对象的内存地址。
     */
    static void example01() {
        // 创建字符串
        String s = "Test";
        System.out.println("内容：" + s + " 内存地址：" + s.hashCode());

        // 向字符串追加内容
        s += " Test";
        System.out.println("内容：" + s + " 内存地址：" + s.hashCode());
    }

    /**
     * 示例二：验证字符串的不变性。
     * <p>
     * 在本示例中，我们创建一些字符串对象，分别通过赋值符号和构造方法设置内容，并比较它们的内存地址。
     */
    static void example02() {
        // 使用赋值方式声明两个String对象
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        // 使用对象方式声明两个String对象
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s3 == s4);
    }

    /**
     * 示例三：字符串的等值判断。
     * <p>
     * 在本示例中，我们创建两个内容相同的字符串对象，并分别通过判等符号( `==` )和 `equals()` 方法测试它们是否相等。
     */
    static void example03() {
        String s1 = "abc";
        String s2 = new String("abc");

        // 使用"=="比较字符串内容
        System.out.println(s1 == s2);
        // 使用"equals()"比较字符串内容
        System.out.println(s1.equals(s2));
    }

    /**
     * 示例四：判断文件名是否为Java源代码。
     * <p>
     * 在本示例中，我们综合利用String类提供的方法，解析文件名称，校验文件是否为Java源代码。
     */
    static void example04() {
        // 待测试的文件名
        String filename = "HelloWorld.java";

        // 获取最后一个"."的索引
        int index = filename.lastIndexOf(".");

        // 找不到"."或者"."在首位均为无效
        if (index == -1 || index == 0) {
            System.out.println("文件名无效！");
        } else {
            // 获取文件的前缀和后缀
            String prefix = filename.substring(0, index);
            String suffix = filename.substring(index + 1);
            System.out.println("文件名：" + prefix);
            System.out.println("扩展名：" + suffix);
            // 后缀必须为"java"
            if (suffix.equals("java")) {
                System.out.println("Java文件名正确。");
            } else {
                System.out.println("Java文件名无效！");
            }
        }
    }

    /**
     * 示例五：判断邮箱地址是否符合规则。
     * <p>
     * 在本示例中，我们综合利用String类提供的方法，校验输入的邮箱地址是否符合规则。
     */
    static void example05() {
        // 待测试的邮箱地址
        String email = "bi4vmr@outlook.com";

        // 获取"@"和"."的位置索引
        int at_index = email.indexOf('@');
        int dot_index = email.indexOf('.');

        // "@"和"."必须存在且"@"必须在"."之前
        if (at_index != -1 && dot_index != -1 && at_index < dot_index) {
            String username = email.substring(0, at_index);
            String domain = email.substring(at_index + 1);

            // 用户名和域名不能为空
            if (!username.equals("") && !domain.equals("")) {
                System.out.println("用户名：" + username);
                System.out.println("域名：" + domain);
                System.out.println("邮箱格式正确。");
            } else {
                System.out.println("用户名或域名为空！");
            }
        } else {
            System.out.println("邮箱格式无效！");
        }
    }

    /**
     * 示例六：StringBuilder的基本应用。
     * <p>
     * 在本示例中，我们使用StringBuilder构建字符串。
     */
    static void example06() {
        // 初始化
        StringBuilder sb = new StringBuilder("abc");
        System.out.println("初始内容：" + sb);

        // 追加内容
        sb.append("123");
        System.out.println("追加后：" + sb);

        // 插入内容
        sb.insert(3, "DEF");
        System.out.println("插入后：" + sb);
    }
}
