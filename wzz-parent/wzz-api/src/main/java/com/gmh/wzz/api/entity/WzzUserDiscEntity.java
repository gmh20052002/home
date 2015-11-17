package com.gmh.wzz.api.entity;

public class WzzUserDiscEntity {
    private String userId;

    private String discId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDiscId() {
        return discId;
    }

    public void setDiscId(String discId) {
        this.discId = discId == null ? null : discId.trim();
    }
}