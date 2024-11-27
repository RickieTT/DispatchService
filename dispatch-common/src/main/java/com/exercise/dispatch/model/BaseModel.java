package com.exercise.dispatch.model;

import java.time.LocalDateTime;

public class BaseModel {

    protected LocalDateTime createTime;

    protected LocalDateTime modifyTime;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "BaseModel{" + "createTime=" + createTime + ", updateTime=" + modifyTime + '}';
    }
}
