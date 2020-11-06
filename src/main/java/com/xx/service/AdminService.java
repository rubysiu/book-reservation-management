package com.xx.service;

import com.github.pagehelper.PageInfo;
import com.xx.domain.Admin;
import com.xx.domain.Appointment;
import com.xx.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin validate(String token);

    PageInfo<Appointment> queryByPage(Long studentId,Integer pageNo, Integer pageSize);
    PageInfo<Book> getBookAll(String name,Integer pageNo, Integer pageSize);
//    Admin findAdmin(String token);
}
