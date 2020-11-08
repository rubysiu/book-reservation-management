package com.xx.dao;

import com.xx.domain.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentDao {
    //ͨ��ͼ��ID��ѧ��IDԤԼ�鼮��������
    int addAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    //ͨ��һ��ѧ��ID��ѯ�Ѿ�ԤԼ����Щ�顣
    List<Appointment> findAndReturn(long studentId);
//	//��ѯ�����Ѿ�ԤԼ�鼮����ʱ����������Ա����
	List<Appointment> findAll(@Param("studentId") Long studentId);


    int delAppointById(Integer id);
}
