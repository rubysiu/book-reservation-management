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

    List<Student> getStudentAll(@Param("studentId") Long studentId);

    int delStudent(int id);

    Student getStudentById(Long studentId);

    int editStudent(@Param("id") Integer id, @Param("studentId") Long studentId,@Param("password") String password);

    int addStudent(@Param("studentId")Long studentId, @Param("password") String password);
}
