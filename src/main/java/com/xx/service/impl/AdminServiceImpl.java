package com.xx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.dao.AdminDao;
import com.xx.dao.AppointmentDao;
import com.xx.dao.BookDao;
import com.xx.dao.StudentDao;
import com.xx.domain.Admin;
import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.domain.Student;
import com.xx.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
@Transactional
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private StudentDao studentDao;

    public Admin validate(String token) {
        return adminDao.findAdmin(token);

    }

    public int editToken(Integer id, String token, String password) {
        return adminDao.editToken(id,token,password);
    }

    public PageInfo<Appointment> queryByPage(Long studentId,Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Appointment> list = appointmentDao.findAll(studentId);
        //用PageInfo对结果进行包装
        PageInfo<Appointment> page = new PageInfo<Appointment>(list);
//        System.out.println(page.getPageNum());
//        System.out.println(page.getPageSize());
//        System.out.println(page.getStartRow());
//        System.out.println(page.getEndRow());
//        System.out.println(page.getTotal());
//        System.out.println(page.getPages());
//        System.out.println(page.getFirstPage());
//        System.out.println(page.getLastPage());
//        System.out.println(page.isHasPreviousPage());
//        System.out.println(page.isHasNextPage());
        return page;
    }

    public PageInfo<Book> getBookAll(String name,Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Book> list = bookDao.findAll(name);
        //用PageInfo对结果进行包装
        PageInfo<Book> page = new PageInfo<Book>(list);
        return page;
    }

    public int delBook(Integer[] bookIds) {
        int num = 0;
        for (Integer bookId : bookIds) {
            num =num+bookDao.delBookById(bookId);
        }
        return num;
    }

    public int addBook(String name, String introd, int number) {
        return bookDao.addBook(name,introd,number);
    }

    public Book getById(long bookId) {
        return bookDao.findById(bookId);
    }

    public int editBook(Long bookId, String name, String introd, Integer number) {
        return bookDao.editBook(bookId,name,introd,number);
    }

    public int delAppoint(Integer[] ids) {
        int num = 0;
        for (Integer id : ids) {
            System.out.println(id);
            num =num+appointmentDao.delAppointById(id);
        }
        return num;

    }

    public PageInfo<Student> getStudentAll(Long studentId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Student> list = studentDao.getStudentAll(studentId);
        //用PageInfo对结果进行包装
        PageInfo<Student> page = new PageInfo<Student>(list);
        return page;
    }

    public int delStudent(Integer[] ids) {
        int num = 0;
        for (int id : ids) {
            System.out.println(id);
            num =num+studentDao.delStudent(id);
        }
        return num;
    }

    public Student getStudentById(Long studentId) {
        return studentDao.getStudentById(studentId);
    }

    public int editStudent(Integer id, Long studentId, String password) {
        return studentDao.editStudent(id,studentId,password);
    }

    public int addStudent(Long studentId, String password) {
        return studentDao.addStudent(studentId,password);
    }
}
