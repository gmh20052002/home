package com.gmh.wzz.api.entity;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="WzzUserEntity-用户账户实体对象")
public class WzzUserEntity {
	@ApiModelProperty(value="主键，必填",required=true)
    private String id;

	@ApiModelProperty(value="用户登录名(手机号)，必填",required=true)
    private String userName;

	@ApiModelProperty(value="用户密码，必填",required=true)
    private String password;

	@ApiModelProperty(value="手机imei标识")
    private String imei;

	@ApiModelProperty(value="用户中文名")
    private String userCname;

	@ApiModelProperty(value="用户描述")
    private String remark;

	@ApiModelProperty(value="省")
    private String province;

	@ApiModelProperty(value="市")
    private String userType;

	@ApiModelProperty(value="vip到期时间，格式：yyyy-MM-dd hh:mm:ss")
    private Date endTime;
	
	@ApiModelProperty(value="vip到期时间，格式：yyyy-MM-dd hh:mm:ss")
    private Date endTimeBegin;

	@ApiModelProperty(value="vip到期时间，格式：yyyy-MM-dd hh:mm:ss")
    private Date endTimeEnd;
	
	@ApiModelProperty(value = "是否VIP")
	private Boolean vip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public String getUserCname() {
        return userCname;
    }

    public void setUserCname(String userCname) {
        this.userCname = userCname == null ? null : userCname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTimeBegin() {
		return endTimeBegin;
	}

	public void setEndTimeBegin(Date endTimeBegin) {
		this.endTimeBegin = endTimeBegin;
	}

	public Date getEndTimeEnd() {
		return endTimeEnd;
	}

	public void setEndTimeEnd(Date endTimeEnd) {
		this.endTimeEnd = endTimeEnd;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}
}