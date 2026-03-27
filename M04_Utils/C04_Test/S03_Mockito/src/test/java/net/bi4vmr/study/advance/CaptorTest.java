package net.bi4vmr.study.advance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

import java.util.logging.Level;

/**
 * 参数捕获器使用案例。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class CaptorTest {

    /**
     * 示例二十一：捕获回调接口并模拟事件。
     * <p>
     * 在本示例中，我们捕获被测对象向依赖组件注册的监听器实例，并模拟事件触发。
     */
    @Test
    public void test_Base() {
        // 创建LogConfigTool的静态Mock对象
        try (MockedStatic<LogConfigTool> toolMS = mockStatic(LogConfigTool.class)) {
            // 创建被测类的实例
            LogManager manager = new LogManager();
            System.out.println("初始的日志级别：" + manager.getMinLevel());

            // 创建ArgumentCaptor，捕获LogManager注册的监听器。
            ArgumentCaptor<LogConfigTool.ConfigListener> captor = ArgumentCaptor.forClass(LogConfigTool.ConfigListener.class);
            // 通过静态Mock对象验证回调方法，并捕获LogManager传入的实现。
            toolMS.verify(() -> LogConfigTool.addConfigListener(captor.capture()));

            // 调用捕获到的监听器方法，模拟事件回调。
            captor.getValue().onLevelChange(Level.WARNING);
            System.out.println("事件触发后的日志级别：" + manager.getMinLevel());

            // 验证事件触发是否确实改变了被测对象的属性
            assertEquals(Level.WARNING, manager.getMinLevel());
        }
    }

    /**
     * 示例二十二：捕获多次调用的参数。
     * <p>
     * 在本示例中，我们捕获被测对象向依赖组件注册的监听器实例，并计算平均耗时。
     */
    @Test
    public void test_Multiple() {
        // 创建ArgumentCaptor，捕获每次监听器返回的耗时数据。
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);

        // 创建监听器的Mock对象
        LogManager.StateCallback mockListener = mock(LogManager.StateCallback.class);
        // 定义行为：每当监听器的 `onEnd()` 方法被调用时，捕获其返回的参数。
        doNothing().when(mockListener).onEnd(captor.capture());

        // 创建被测类的实例
        LogManager manager = new LogManager();
        // 调用5次保存日志的方法
        for (int i = 0; i < 5; i++) {
            manager.saveLog(mockListener);
        }

        // 查看捕获到的参数
        for (int i = 0; i < captor.getAllValues().size(); i++) {
            long time = captor.getAllValues().get(i);
            System.out.println("第" + (i + 1) + "次调用，耗时：" + time + "ms。");
        }
        // 计算平均耗时
        double average = captor.getAllValues().stream().mapToLong(Long::longValue).average().orElse(0);
        System.out.println("平均耗时：" + average + "ms。");
    }
}
