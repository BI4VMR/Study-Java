package net.bi4vmr.study.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * MathUtil的测试类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class MathUtilTest {

    @Test
    public void testDivide() {
        // 测试正常的情况
        Integer result1 = MathUtil.divide(32, 8);
        // 断言：结果非空
        Assert.assertNotNull(result1);
        // 断言：结果等于4
        Assert.assertEquals(result1.longValue(), 4L);

        // 测试除数为"0"的情况
        Integer result2 = MathUtil.divide(100, 0);
        // 断言：结果为空
        Assert.assertNull(result2);
    }
}
