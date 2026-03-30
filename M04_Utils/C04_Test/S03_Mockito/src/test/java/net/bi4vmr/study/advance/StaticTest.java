package net.bi4vmr.study.advance;

import static org.mockito.Mockito.mockStatic;

import org.junit.Test;

/**
 * 静态方法模拟案例。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class StaticTest {

    /**
     * 示例十三：模拟静态方法。
     * <p>
     * 在本示例中，我们为工具类UtilsClass中的静态方法设置模拟行为。
     */
    @Test
    public void test_Base() {
        // 创建UtilsClass的静态Mock对象
        try (var staticMock = mockStatic(UtilsClass.class)) {
            // 定义静态方法的模拟行为
            staticMock.when(UtilsClass::methodStatic)
                    .thenAnswer(invocation -> {
                        System.out.println("Static method mock call!");
                        return null;
                    });

            // 调用静态方法，观察控制台输出内容。
            UtilsClass.methodStatic();

            // 验证静态方法是否被调用
            staticMock.verify(UtilsClass::methodStatic);
        }
    }
}
