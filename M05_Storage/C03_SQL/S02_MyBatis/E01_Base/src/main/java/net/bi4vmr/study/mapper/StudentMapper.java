package net.bi4vmr.study.mapper;

/**
 * Mapper接口 - 学生信息。
 *
 * @author bi4vmr@outlook.com
 */
public interface StudentMapper {

    // 创建数据库
    void createTable();

    // 插入记录
    int insertStudent();
}
