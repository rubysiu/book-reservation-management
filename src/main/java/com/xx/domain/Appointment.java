package com.xx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.sql.Timestamp;

public class Appointment {
    private Integer id;
    private Long bookId;
    private Long studentId;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:ss", timezone = "Asia/Shanghai")
    private Timestamp appointTime;
    // 多对一的复合属性
    private Book book;// 图书实体

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                ", book=" + book +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Appointment() {
    }


    public Appointment(Long bookId, Long studentId, Timestamp appointTime) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Timestamp getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Timestamp appointTime) {
        this.appointTime = appointTime;
    }

}
