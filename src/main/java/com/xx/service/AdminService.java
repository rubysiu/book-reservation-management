package com.xx.service;

import com.github.pagehelper.PageInfo;
import com.xx.domain.Admin;
import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin validate(String token);
    int editToken(Integer id,String token,String password);
    PageInfo<Appointment> queryByPage(Long studentId,Integer pageNo, Integer pageSize);
    PageInfo<Book> getBookAll(String name,Integer pageNo, Integer pageSize);

    int delBook(Integer[] bookIds);

    int addBook(String name, String introd, int number);
    Book getById(long bookId);

    int editBook(Long bookId, String name, String introd, Integer number);

    int delAppoint(Integer[] ids);

    PageInfo<Student> getStudentAll(Long studentId,Integer pageNo, Integer pageSize);
//    Admin findAdmin(String token);
}
