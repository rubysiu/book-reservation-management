package com.xx.service.impl;

import com.sun.org.slf4j.internal.LoggerFactory;
import com.xx.dao.AppointmentDao;
import com.xx.dao.BookDao;
import com.xx.dao.StudentDao;
import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.domain.Student;
import com.xx.dto.AppointExecution;
import com.xx.enums.AppointStateEnum;
import com.xx.exception.AppointException;
import com.xx.exception.NoNumberException;
import com.xx.exception.RepeatAppointException;
import com.xx.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("bookService")
@Transactional
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppointmentDao appointmentDao;
    public Book getById(long bookId) {
        return bookDao.findById(bookId);
    }

    public List<Book> getList() {
        return bookDao.findAll();

    }

    public Student validateStu(Long studentId, String password) {
        return studentDao.findStudent(studentId, password);
    }

    public List<Book> getSomeList(String name) {
        System.out.println(bookDao.findSome(name));
        return bookDao.findSome(name);
    }

    public List<Appointment> getAppointByStu(long studentId) {
        return appointmentDao.findAndReturn(studentId);
    }

    public AppointExecution appoint(long bookId, long studentId) {
        try{
            int reduceNumber = bookDao.reduceNumber(bookId);
            if (reduceNumber<=0){
                //已无库存
                throw new NoNumberException("no number");
            }else {
                int insert = appointmentDao.addAppointment(bookId, studentId);
                if (insert<=0){
                    //重复预约
                    throw new RepeatAppointException("repeat appoint");

                }else {
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS);
                }
            }
        }catch (NoNumberException i){
                throw i;
        }catch (RepeatAppointException c){
                throw c;
        }catch (Exception e){

            log.error(e.getMessage(),e);
            throw new AppointException("appoint inner error:" +e.getMessage());
        }

    }


}
