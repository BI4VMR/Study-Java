package net.bi4vmr.study.advance;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Spy使用案例。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class SpyTest {

    /**
     * 示例二十五：Spy模式。
     * <p>
     * 在本示例中，我们创建MemoryInfo的Spy对象，并为 `getFreeMemory()` 方法定义行为，模拟剩余内存较低的场景。
     */
    @Test
    public void test_Base() {
        // 创建Spy对象
        MemoryInfo spyMemoryInfo = spy(new MemoryInfo());

        System.out.println("初始状态...");
        System.out.println("内存总量：" + spyMemoryInfo.getTotalMemory());
        System.out.println("空闲内存：" + spyMemoryInfo.getFreeMemory());

        // 定义行为：模拟剩余内存为8KB的情况
        when(spyMemoryInfo.getFreeMemory()).thenReturn(8 * 1024L);

        System.out.println("定义行为后...");
        System.out.println("内存总量：" + spyMemoryInfo.getTotalMemory());
        System.out.println("空闲内存：" + spyMemoryInfo.getFreeMemory());
    }
}
