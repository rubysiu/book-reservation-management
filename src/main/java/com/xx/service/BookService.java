package com.xx.service;

import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.domain.Student;
import com.xx.dto.AppointExecution;

import java.util.List;

public interface BookService {
    /**
     * ��ѯһ����
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * ��ѯ������
     * @return
     */
    List<Book> getList();

    /**
     * ��½ʱ��ѯ���ݿ��Ƿ��и�ѧ����¼
     * @param studentId
     * @param password
     * @return
     */
    Student validateStu(Long studentId,String password);

    /**
     * ����������ѯ
     * ����������
     * @param name
     * @return
     */
    List<Book> getSomeList(String name);

    /**
     * �鿴ĳѧ��ԤԼ������ͼ��
     * @param studentId
     * @return
     */
    List<Appointment> getAppointByStu(long studentId);
    /**
     * ԤԼͼ��
     *
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookId, long studentId);//����ԤԼ�ɹ���ʵ����

}
