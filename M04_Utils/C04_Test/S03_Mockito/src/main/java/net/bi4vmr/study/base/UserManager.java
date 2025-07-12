package net.bi4vmr.study.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户管理。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class UserManager {

    // 依赖项：数据库
    private final DBHelper mDBHelper = new DBHelper();

    // 获取所有用户名称
    public List<String> getUserNames() {
        Collection<String> collection = mDBHelper.queryUsers()
                .values();
        return new ArrayList<>(collection);
    }

    // 获取所有用户名称（新增了日志记录的步骤）
    public List<String> getUserNames2() {
        Collection<String> collection = mDBHelper.queryUsers()
                .values();
        return new ArrayList<>(collection);
    }
}
