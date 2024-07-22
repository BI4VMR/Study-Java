package net.bi4vmr.study;

import net.bi4vmr.study.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试代码 - 基本应用。
 *
 * @author bi4vmr@outlook.com
 */
public class TestBase {

    public static void main(String[] args) throws IOException {
        // 获取配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取JDBC会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        // 获取JDBC会话，并开启事务自动提交。
        SqlSession session = sessionFactory.openSession(true);
        // 传入StudentMapper接口的Class文件，获取一个实现类。
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        // 执行Mapper接口中的方法
        mapper.createTable();
        mapper.insertStudent();
        mapper.insertStudent();
        mapper.insertStudent();
        // 关闭会话，释放资源。
        session.close();
    }
}
