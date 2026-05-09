package net.bi4vmr.study.behavior_define;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义行为。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class DefineBehaviorTest {

    /**
     * 示例三：模拟固定返回值。
     * <p>
     * 在本示例中，我们为Mock对象定义行为，每当指定方法被调用时，返回测试用例中指定的值。
     */
    @Test
    public void test_Define_Return_Value() throws IOException {
        // 创建Mock对象
        File mockFile = mock(File.class);
        // 定义行为：当 `mockFile` 的 `getCanonicalPath()` 方法被访问时，返回 `/data/file1` 。
        when(mockFile.getCanonicalPath()).thenReturn("/data/file1");
        // 上一条语句的等价语法
        doReturn("/data/file1").when(mockFile).getCanonicalPath();

        // 调用Mock对象的 `getCanonicalPath()` 方法并输出结果
        System.out.println("File Path:[" + mockFile.getCanonicalPath() + "]");
        // 再次调用Mock对象的 `getCanonicalPath()` 方法并输出结果
        System.out.println("File Path:[" + mockFile.getCanonicalPath() + "]\n");


        // 修改行为：当 `mockFile` 的 `getCanonicalPath()` 方法被访问时，返回 `/data/file2` 。
        when(mockFile.getCanonicalPath()).thenReturn("/data/file2");

        // 调用Mock对象的 `getCanonicalPath()` 方法并输出结果
        System.out.println("File Path:[" + mockFile.getCanonicalPath() + "]");
    }

    /**
     * 示例四：模拟序列返回值。
     * <p>
     * 在本示例中，我们为Mock对象定义行为，每当指定方法被调用时，依次返回不同的值。
     */
    @Test
    public void test_Define_Return_Sequence_Value() {
        // 创建Mock对象
        File mockFile = mock(File.class);
        // 设置每次调用时返回的值序列
        // 定义行为：当 `mockFile` 的 `length()` 方法被访问时，依次返回 `mockResult` 列表中的值。
        when(mockFile.length()).thenReturn(100L, 200L, 1024L);

        // 多次访问Mock对象的属性并输出结果
        for (int i = 1; i <= 5; i++) {
            System.out.println("第 " + i + " 次调用： Length:[" + mockFile.length() + "]");
        }
    }

    /**
     * 示例五：自定义行为。
     * <p>
     * 在本示例中，我们为Mock对象定义行为，每当指定方法被调用时，输出控制台消息。
     */
    @Test
    public void test_Define_Answers() throws IOException {
        // 创建Mock对象
        File mockFile = mock(File.class);
        // 定义行为：当 `mockFile` 的 `getCanonicalPath()` 方法被访问时，返回 `/data/file1` 。
        when(mockFile.getCanonicalPath()).thenAnswer(invocation -> {
            // 输出消息
            System.out.println(invocation.getMock() + " `getCanonicalPath()` was called.");

            // 此时 `thenAnswer` 的返回值将作为Mock方法的返回值
            return "/data/file1";
        });

        // 调用Mock对象的 `getCanonicalPath()` 方法并输出结果
        System.out.println("File Path:[" + mockFile.getCanonicalPath() + "]");
    }

    /**
     * 示例六：模拟异常。
     * <p>
     * 在本示例中，我们为Mock对象定义行为，每当指定方法被调用时，抛出测试用例指定的异常。
     */
    @Test(expected = IOException.class)
    public void test_Define_Exception() throws IOException {
        // 创建Mock对象
        File mockFile = mock(File.class);
        // 定义行为：当 `mockFile` 的 `getCanonicalPath()` 方法被访问时，抛出异常。
        when(mockFile.getCanonicalPath()).thenThrow(new IOException("This is a mock exception!"));

        // 调用Mock对象的 `getCanonicalPath()` 方法
        mockFile.getCanonicalPath();
    }

    /**
     * 示例七：参数匹配器。
     * <p>
     * 在本示例中，我们使用参数匹配器定义Mock方法接收到不同参数时的行为。
     */
    @Test
    public void test_Parameter_Matchers() {
        DBHelper mockDBHelper = mock(DBHelper.class);
        // 定义不同条件下 `queryUserName()` 方法的返回值
        when(mockDBHelper.queryUserName(anyInt())).thenReturn("MockUser");
        when(mockDBHelper.queryUserName(1)).thenReturn("Alice");
        when(mockDBHelper.queryUserName(2)).thenReturn("Bob");

        // 查看返回值
        System.out.println("QueryUserName of ID=1:[" + mockDBHelper.queryUserName(1) + "]");
        System.out.println("QueryUserName of ID=2:[" + mockDBHelper.queryUserName(2) + "]");
        System.out.println("QueryUserName of ID=3:[" + mockDBHelper.queryUserName(3) + "]");
    }

    /**
     * 示例八：匹配重载方法。
     * <p>
     * 在本示例中，我们使用参数匹配器定义不同重载方法的行为。
     */
    @Test
    public void test_Parameter_Overloading() {
        DBHelper mockDBHelper = mock(DBHelper.class);

        // 匹配参数为Int类型的方法
        when(mockDBHelper.queryUserName(anyInt())).thenReturn("MockUserA");

        // 匹配参数为String类型的方法
        when(mockDBHelper.queryUserName(anyString())).thenReturn("MockUserB");

        // 查看返回值
        System.out.println("QueryUserName by ID:[" + mockDBHelper.queryUserName(1) + "]");
        System.out.println("QueryUserName by CardID:[" + mockDBHelper.queryUserName("1999") + "]");
    }

    /**
     * 示例九：具体值与 `eq()` 匹配器。
     * <p>
     * 在本示例中，我们演示参数具体值与 `eq()` 匹配器的区别。
     */
    @Test
    public void test_Parameter_ValueAndEQ() {
        DBHelper mockDBHelper = mock(DBHelper.class);

        // 错误用法：字面量与匹配器混用
        // when(mockDBHelper.queryUserNames(20, anyBoolean())).thenReturn(new ArrayList<>());

        // 正确用法：全部使用匹配器
        when(mockDBHelper.queryUserNames(eq(20), anyBoolean())).thenReturn(new ArrayList<>());
        // 正确用法：全部使用字面量
        when(mockDBHelper.queryUserNames(20, false)).thenReturn(new ArrayList<>());
    }

    /**
     * 示例十：偏函数模拟。
     * <p>
     * 在本示例中，我们调用Mock对象的原始方法，对返回值进行处理后再传递给调用者。
     */
    @Test
    public void test_OriginalCall() {
        DBHelper mockDBHelper = mock(DBHelper.class);
        when(mockDBHelper.queryUserNames(anyInt(), anyBoolean())).thenAnswer(invocation -> {
            // 调用原始方法
            // 由于是Mock对象而非Spy，调用原始方法需要确保方法不是抽象的。
            Object rawResult = invocation.callRealMethod();
            @SuppressWarnings("unchecked")
            List<String> rawList = (List<String>) rawResult;
            System.out.println("真实调用的返回值：" + rawList);

            // 追加一些模拟数据再作为新的返回值
            List<String> result = new ArrayList<>(rawList);
            result.add("MockUser1");
            result.add("MockUser2");
            return result;
        });

        // 调用Mock对象的 `queryUserNames()` 方法并输出结果
        List<String> result = mockDBHelper.queryUserNames(22, false);
        System.out.println("Mock方法的返回值：" + result);
    }
}
