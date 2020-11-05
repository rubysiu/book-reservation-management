package com.xx.service;

import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.domain.Student;
import com.xx.dto.AppointExecution;

import java.util.List;

public interface BookService {
    /**
     * 查询一本书
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * 查询所有书
     * @return
     */
    List<Book> getList();

    /**
     * 登陆时查询数据库是否有该学生记录
     * @param studentId
     * @param password
     * @return
     */
    Student validateStu(Long studentId,String password);

    /**
     * 按照书名查询
     * 按条件搜索
     * @param name
     * @return
     */
    List<Book> getSomeList(String name);

    /**
     * 查看某学生预约的所有图书
     * @param studentId
     * @return
     */
    List<Appointment> getAppointByStu(long studentId);
    /**
     * 预约图书
     *
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookId, long studentId);//返回预约成功的实体类

}
