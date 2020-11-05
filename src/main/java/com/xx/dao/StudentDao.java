package com.xx.dao;

import com.xx.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ѧ��
 */
public interface StudentDao {
    /**
     * ��֤����
     * @param studentId
     * @param password
     * @return
     */
    Student findStudent(@Param("studentId") Long studentId,@Param("password") String password);

    List<Student> getAll(@Param("offset") int offset,@Param("limit") int limit);
}
