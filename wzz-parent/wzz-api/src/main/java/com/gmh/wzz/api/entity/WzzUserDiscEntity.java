package com.gmh.wzz.api.entity;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="WzzUserDiscEntity-用户优惠券关联对象")
public class WzzUserDiscEntity {
	@ApiModelProperty(value="用户id，必填",required=true)
    private String userId;

	@ApiModelProperty(value="优惠信息id，必填",required=true)
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