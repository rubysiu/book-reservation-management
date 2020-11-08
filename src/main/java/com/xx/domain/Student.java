package com.xx.domain;

public class Student {
    private Long studentId;
    private String password;

    public Student() {
    }

    public Student(Long studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
