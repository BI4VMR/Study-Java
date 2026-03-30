package net.bi4vmr.study.behavior_verify;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 验证行为。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class VerifyBehaviorTest {

    /**
     * 示例十一：基本的行为验证。
     * <p>
     * 在本示例中，我们使用 `verify()` 方法验证被测接口是否正确地调用了依赖组件。
     */
    @Test
    public void testBase() {
        // 创建Logger的Mock对象
        Logger mockLogger = mock(Logger.class);

        // 创建待测类的实例并注入Mock对象
        LogManager manager = new LogManager();
        manager.setLogger(mockLogger);

        // 执行业务方法
        List<String> text = Arrays.asList("LineA", "LineB");
        manager.printInfo(text);

        // 验证行为：Logger的记录方法应当被调用2次
        verify(mockLogger, times(2)).log(eq(Level.INFO), anyString());

        // 再次执行业务方法
        List<String> text2 = Arrays.asList("Line1", "Line2", "Line3");
        manager.printInfo(text2);

        // 验证行为：Logger的记录方法应当被调用2次 + 3次
        verify(mockLogger, times(2 + text2.size())).log(eq(Level.INFO), anyString());
    }

    /**
     * 示例十二：验证一组方法的调用顺序。
     * <p>
     * 在本示例中，我们使用 `InOrder` 验证被测接口是否正确地按顺序调用了依赖组件。
     */
    @Test
    public void testSequence() {
        // 创建监听器的Mock对象
        LogManager.StateCallback mockListener = mock(LogManager.StateCallback.class);

        // 执行业务方法并传入监听器
        new LogManager().saveLog(mockListener);

        // 验证行为：日志导出后，监听器中的起始和结束方法都应当被调用，且符合先开始后结束的顺序。
        InOrder inOrder = inOrder(mockListener);
        inOrder.verify(mockListener).onStart();
        inOrder.verify(mockListener).onEnd(anyLong());
    }
}
