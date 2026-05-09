package net.bi4vmr.study.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class DBHelper {

    /**
     * 查询用户信息。
     * <p/>
     * 此处为示例代码，只是返回随意生成的数据。
     *
     * @return 用户信息Map，键为ID，值为名称。
     */
    public Map<Long, String> queryUsers() {
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "张三");
        map.put(2L, "李四");
        return map;
    }
}
