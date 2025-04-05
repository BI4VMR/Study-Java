package net.bi4vmr.study.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * MathUtil的测试类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestMathUtil {

    @Test
    @DisplayName("测试TestMath#Divide方法")
    public void testDivide() {
        // 测试正常的情况
        Integer result1 = MathUtil.divideSafe(32, 8);
        // 断言：结果非空
        Assertions.assertNotNull(result1);
        // 断言：结果等于4
        Assertions.assertEquals(4L, result1.longValue());

        // 测试除数为"0"的情况
        Integer result2 = MathUtil.divideSafe(100, 0);
        // 断言：结果为空
        Assertions.assertNull(result2);
    }
}
