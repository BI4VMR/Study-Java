package net.bi4vmr.study.callback;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * MathUtil的测试类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class FileUtilTest {

    @Test
    public void testSaveFileCallback() {
        // 创建模拟的Callback对象
        FileCallback callbackMock = mock(FileCallback.class);

        // 调用被测试的方法
        FileUtil.saveFile(callbackMock);

        // 使用timeout验证异步回调，设置超时时间稍大于延迟时间
        verify(callbackMock, timeout(3000)).onResult(true, "OK.");
    }
}
