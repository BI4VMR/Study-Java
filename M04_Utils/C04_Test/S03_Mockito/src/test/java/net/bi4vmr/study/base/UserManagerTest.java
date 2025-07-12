package net.bi4vmr.study.base;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserManager的测试类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class UserManagerTest {

    @Test
    public void testGetUserNames() {
        // 模拟数据
        Map<Long, String> mockDatas = new HashMap<>();
        mockDatas.put(1L, "来宾账户");
        mockDatas.put(2L, "用户A");
        mockDatas.put(3L, "用户B");

        // 创建DBHelper的Mock对象
        DBHelper mockDBHelper = Mockito.mock();
        // 定义行为：如果 `queryUsers()` 方法被调用，则返回模拟数据。
        Mockito.when(mockDBHelper.queryUsers()).thenReturn(mockDatas);

        // 构造待测类的对象，并注入Mock对象作为依赖。
        UserManager manager = new UserManager();
        try {
            Field field = manager.getClass().getDeclaredField("mDBHelper");
            field.setAccessible(true);
            field.set(manager, mockDBHelper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 调用待测方法
        List<String> users = manager.getUserNames();

        // 查看返回的内容
        for (String user : users) {
            System.out.println(user);
        }
        // 验证Mock对象的方法是否被调用
        Mockito.verify(mockDBHelper).queryUsers();
        // 验证待测方法的返回值是否与预期一致
        Assert.assertTrue(mockDatas.values().containsAll(users));
    }
}
