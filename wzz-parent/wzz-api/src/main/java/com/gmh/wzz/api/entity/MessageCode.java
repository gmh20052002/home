package com.gmh.wzz.api.entity;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="MessageCode-短信验证码返回对象")
public class MessageCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="验证码")
	private String messageCode;

	@ApiModelProperty(value="验证码超时时间毫秒数")
	private Long timeOut;
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public Long getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Long timeOut) {
		this.timeOut = timeOut;
	}
}
