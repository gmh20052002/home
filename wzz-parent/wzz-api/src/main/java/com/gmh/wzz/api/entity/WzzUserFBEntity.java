package com.gmh.wzz.api.entity;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="WzzUserFBEntity-用户反馈实体对象")
public class WzzUserFBEntity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="主键，必填",required=true)
    private String id;

	@ApiModelProperty(value="用户id，必填",required=true)
    private String userId;

	@ApiModelProperty(value="反馈时间",required=false)
    private Date feedTime;

	@ApiModelProperty(value="回复时间",required=false)
    private Date replayTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getFeedTime() {
        return feedTime;
    }

    public void setFeedTime(Date feedTime) {
        this.feedTime = feedTime;
    }

    public Date getReplayTime() {
        return replayTime;
    }

    public void setReplayTime(Date replayTime) {
        this.replayTime = replayTime;
    }
	@ApiModelProperty(value="反馈意见",required=true)
    private String feedBack;

	@ApiModelProperty(value="回复内容",required=false)
    private String replay;

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack == null ? null : feedBack.trim();
    }

    public String getReplay() {
        return replay;
    }

    public void setReplay(String replay) {
        this.replay = replay == null ? null : replay.trim();
    }
}