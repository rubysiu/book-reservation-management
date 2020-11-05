package com.xx.dto;

import com.xx.enums.AppointStateEnum;

public class AppointExecution {
    // 图书ID
    private long bookId;
    // 秒杀预约结果状态
    private int state;
    // 状态标识
    private String stateInfo;

    //预约失败的构造器
    public AppointExecution() {
    }
    public AppointExecution(long bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public AppointExecution(long bookId, int state, String stateInfo) {
        this.bookId = bookId;
        this.state = state;
        this.stateInfo = stateInfo;
    }



    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo=" + stateInfo +
                '}';
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }


}
