package net.bi4vmr.study.resultcheck;

import org.junit.Assert;
import org.junit.Test;

/**
 * 验证结果。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class AssertTest {

    @Test
    public void testAssert() {
        // 判断两个输入参数是否相等（对于引用类型为调用 `equals()` 方法进行比较）
        Assert.assertEquals(4, 2 + 2);
        // 判断两个输入参数是否不相等（对于引用类型为调用 `equals()` 方法进行比较）
        Assert.assertNotEquals(4, 2 + 2 + 2);

        // 判断两个输入参数的内存地址是否相等
        String s = "Hello";
        Assert.assertSame(s, s);
        // 判断两个输入参数的内存地址是否不相等
        Assert.assertNotSame(new Object(), new Object());

        // 判断输入参数是否为空
        Assert.assertNull(null);
        // 判断输入参数是否为非空
        Assert.assertNotNull(new Object());

        // 判断输入参数是否为真
        Assert.assertTrue(10 == 5 + 5);
        // 判断输入参数是否为假
        Assert.assertFalse(10 != 5 + 5);

        int[] array = {1, 2, 3, 4, 5};
        // 比较数组是否相同
        Assert.assertArrayEquals(array, array);

        // 断言失败（可用于编写自定义断言）
        // Assert.fail();
    }
}
