package net.bi4vmr.study.advance;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 参数捕获器使用案例。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class CaptorTest {

    /**
     * 示例二十一：捕获回调接口并模拟事件。
     *
     * 在本示例中，我们捕获被测对象向依赖组件注册的监听器实例，并模拟事件触发。
     */
    @Test
    public void testBase() {
        /*
         * 注意：由于标准Mockito不支持静态方法Mock，此处假设LogConfigTool提供实例方法，
         * 或者使用mockito-inline扩展进行MockStatic。
         *
         * 为了演示通用用法，此处以LogManager内部调用为例。
         */

        // 创建监听器的Mock对象
        LogManager.StateCallback mockListener = mock(LogManager.StateCallback.class);

        // 创建ArgumentCaptor
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);

        // 创建被测类的实例
        LogManager manager = new LogManager();
        manager.saveLog(mockListener);

        // 验证并捕获参数
        verify(mockListener).onEnd(captor.capture());

        System.out.println("捕获到的耗时：" + captor.getValue());
        assertEquals(150L, (long) captor.getValue());
    }

    /**
     * 示例二十二：捕获多次调用的参数。
     *
     * 在本示例中，我们捕获被测对象向依赖组件注册的监听器实例，并计算平均耗时。
     */
    @Test
    public void testMultiple() {
        // 创建监听器的Mock对象
        LogManager.StateCallback mockListener = mock(LogManager.StateCallback.class);
        // 创建ArgumentCaptor
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);

        // 创建被测类的实例
        LogManager manager = new LogManager();
        // 调用5次保存日志的方法
        for (int i = 0; i < 5; i++) {
            manager.saveLog(mockListener);
        }

        // 验证被调用5次，并捕获所有参数
        verify(mockListener, times(5)).onEnd(captor.capture());

        // 获取所有捕获到的参数
        List<Long> values = captor.getAllValues();
        long sum = 0;
        for (int i = 0; i < values.size(); i++) {
            long v = values.get(i);
            System.out.println("第" + (i + 1) + "次调用，耗时：" + v + " ms。");
            sum += v;
        }
        // 计算平均耗时
        System.out.println("平均耗时：" + (sum / (double) values.size()) + " ms。");
    }
}
