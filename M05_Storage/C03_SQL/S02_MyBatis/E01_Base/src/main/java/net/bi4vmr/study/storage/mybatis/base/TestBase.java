package net.bi4vmr.study.storage.mybatis.base;

import net.bi4vmr.study.storage.mybatis.base.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Name        : TestBase
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-10-18 23:26
 * <p>
 * Description : 测试类：基本应用。
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
        // 执行接口中的方法
        mapper.insertStudent();
        mapper.insertStudent();
        mapper.insertStudent();
        // 关闭会话，释放资源。
        session.close();
    }
}
