package net.bi4vmr.study.behavior_define;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class DBHelper {

    public String queryUserName(int id) {
        return "Real Name";
    }

    public String queryUserName(String cardID) {
        return "Real Name";
    }

    public List<String> queryUserNames(int age, boolean male) {
        List<String> real = new ArrayList<>();
        real.add("Real Name");
        return real;
    }
}
