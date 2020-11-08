package com.xx.dao;

import com.xx.domain.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentDao {
    //通过图书ID和学生ID预约书籍，并插入
    int addAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    //通过一个学生ID查询已经预约了哪些书。
    List<Appointment> findAndReturn(long studentId);
//	//查询所有已经预约书籍，暂时不开发管理员界面
	List<Appointment> findAll(@Param("studentId") Long studentId);


    int delAppointById(Integer id);
}
