package net.bi4vmr.study.callback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * FileHelper的测试类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
@RunWith(MockitoJUnitRunner.class)
public class FileHelperTest {

    @Test
    public void testSaveFileCallback() {
        // 创建待测类的实例
        FileHelper fileHelper = new FileHelper();

        // 创建模拟的Callback对象
        FileCallback callbackMock = mock(FileCallback.class);

        // 调用待测方法
        fileHelper.saveFile(callbackMock);

        // 使用timeout验证异步回调，设置超时时间稍大于延迟时间（2000L）
        verify(callbackMock, timeout(3000L)).onResult(eq(true), anyString());
    }
}
