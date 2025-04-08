package net.bi4vmr.study.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * MathUtil的测试类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class MathUtilTest {

    /**
     * 示例一：构建JUnit4环境。
     */
    @Test
    public void testDivide() {
        // 测试正常的情况
        Integer result1 = MathUtil.divideSafe(32, 8);
        // 断言：结果非空
        Assert.assertNotNull(result1);
        // 断言：结果等于4
        Assert.assertEquals(4L, result1.longValue());

        // 测试除数为"0"的情况
        Integer result2 = MathUtil.divideSafe(100, 0);
        // 断言：结果为空
        Assert.assertNull(result2);
    }

    /**
     * 示例二：检测异常。
     */
    @Test(expected = ArithmeticException.class)
    public void testException() {
        int a = 100 / 0;
    }

    /**
     * 示例三：检测超时。
     */
    @Test(timeout = 1000L)
    public void testTimeout() throws InterruptedException {
        // > 1s，会导致执行失败。
        // Thread.sleep(5000L);

        // < 1s，不会导致执行失败。
        Thread.sleep(500L);
    }
}
