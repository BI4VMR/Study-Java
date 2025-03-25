package net.bi4vmr.study.base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

/**
 * MathUtil的测试类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
// `@RunWith` 注解用于指定运行环境，如果我们指定为MockitoJUnitRunner，则可以省略 `MockitoAnnotations.openMocks()` 等代码。
// @RunWith(MockitoJUnitRunner.class)
public class MathUtilTest {

    @Mock
    private List<String> mockList;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() {
        System.out.println("@After：在每个测试方法之后被执行");
    }

    @Test
    public void test1212e() {
        Mockito.when(mockList.get(anyInt())).thenReturn("BI4VMR");

        System.out.println(mockList.get(3));
    }

    @Test
    public void testDivide() {
        // 测试正常的情况
        Integer result1 = MathUtil.divide(32, 8);
        // 断言：结果非空
        Assert.assertNotNull(result1);
        // 断言：结果等于4
        Assert.assertEquals(result1.longValue(), 4L);

        // 测试除数为"0"的情况
        // Integer result2 = MathUtil.divide(100, 0);
        // 断言：结果为空
        // Assert.assertNull(result2);
    }
}
