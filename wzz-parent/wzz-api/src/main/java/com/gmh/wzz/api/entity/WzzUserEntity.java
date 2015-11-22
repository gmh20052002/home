package com.gmh.wzz.api.entity;

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
}