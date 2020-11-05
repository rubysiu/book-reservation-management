package com.xx.service;

import com.github.pagehelper.PageInfo;
import com.xx.domain.Admin;
import com.xx.domain.Appointment;
import com.xx.domain.Book;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin validate(String token);

    PageInfo<Appointment> queryByPage(Integer pageNo, Integer pageSize);
    PageInfo<Book> getBookAll(Integer pageNo, Integer pageSize);
}
