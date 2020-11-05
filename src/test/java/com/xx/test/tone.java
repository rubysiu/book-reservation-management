package com.xx.test;

import com.github.pagehelper.PageInfo;
import com.xx.dao.StudentDao;
import com.xx.domain.Admin;
import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.service.AdminService;
import com.xx.service.BookService;
import com.xx.service.impl.AdminServiceImpl;
import com.xx.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")
@Transactional
public class tone {

    @Autowired
    private BookService bookService;
    @Autowired
    private AdminServiceImpl adminService;
    @Test
    public void test1() {

        List<Book> list = this.bookService.getList();
        System.out.println(list);
    }

    @Test
    public void test2() {

        Admin admin = this.adminService.validate("a8023eb311f7c554a58ba4db991b41ad");
        System.out.println(admin);
    }


}
