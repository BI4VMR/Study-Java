package net.bi4vmr.study.callback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * MathUtil的测试类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
@RunWith(MockitoJUnitRunner.class)
public class FileHelperTest {

    @Test
    public void testSaveFileCallback() {
        // 创建FileHelper的Mock对象
        FileHelper fileHelper = mock(FileHelper.class);

        // 创建模拟的Callback对象
        FileCallback callbackMock = mock(FileCallback.class);
        // ArgumentCaptor
        // 调用被测试的方法
        fileHelper.saveFile(callbackMock);

        // 使用timeout验证异步回调，设置超时时间稍大于延迟时间
        // verify(callbackMock, timeout(3000)).onResult(true, "OK.");
    }
}
