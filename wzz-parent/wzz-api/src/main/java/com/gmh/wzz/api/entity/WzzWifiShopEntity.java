package com.gmh.wzz.api.entity;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="WzzWifiShopEntity-wifi商铺实体对象")
public class WzzWifiShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="主键，必填",required=true)
    private String id;

	@ApiModelProperty(value="店铺名称，必填",required=true)
    private String name;

	@ApiModelProperty(value="店铺地址")
    private String address;

	@ApiModelProperty(value="店铺描述")
    private String remark;

	@ApiModelProperty(value="一级分类",required=true)
    private String classType1;

	@ApiModelProperty(value="二级分类")
    private String classType2;

	@ApiModelProperty(value="工作电话")
    private String workTel;

	@ApiModelProperty(value="拥有者")
    private String overUser;

	@ApiModelProperty(value="手机")
    private String mobileTel;

	@ApiModelProperty(value="代理用户手机号")
    private String userName;

	@ApiModelProperty(value="WIFI唯一标识BSSID，必填",required=true)
    private String wifi;

	@ApiModelProperty(value="WIFI密码，必填",required=true)
    private String wifiPassword;

	@ApiModelProperty(value="楼层")
    private String floor;

	@ApiModelProperty(value="WIFI经度坐标")
    private Float wifiLng;

	@ApiModelProperty(value="WIFI纬度坐标")
    private Float wifiLat;

	@ApiModelProperty(value="WIFI坐标X")
    private Float wifiX;

	@ApiModelProperty(value="WIFI坐标Y")
    private Float wifiY;

	@ApiModelProperty(value="省")
    private String province;

	@ApiModelProperty(value="市")
    private String city;

	@ApiModelProperty(value="图片地址，多个用逗号分隔")
    private String picUrl;

	@ApiModelProperty(value="缩略图片地址，多个用逗号分隔")
    private String zoomPicUrl;

	@ApiModelProperty(value="注册时间")
    private Date createTime;

	@ApiModelProperty(value="更新时间")
    private Date updateTime;

	@ApiModelProperty(value="创建会员到期时间，可以用于判断是否VIP")
	private Date vipEndTime;
    
    private Float wifiXMin = null;
    private Float wifiXMax = null;
    private Float wifiYMin = null;
    private Float wifiYMax = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getWorkTel() {
        return workTel;
    }

    public void setWorkTel(String workTel) {
        this.workTel = workTel == null ? null : workTel.trim();
    }

    public String getOverUser() {
        return overUser;
    }

    public void setOverUser(String overUser) {
        this.overUser = overUser == null ? null : overUser.trim();
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel == null ? null : mobileTel.trim();
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi == null ? null : wifi.trim();
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword == null ? null : wifiPassword.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

	public String getClassType1() {
		return classType1;
	}

	public void setClassType1(String classType1) {
		this.classType1 = classType1;
	}

	public String getClassType2() {
		return classType2;
	}

	public void setClassType2(String classType2) {
		this.classType2 = classType2;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Float getWifiLng() {
		return wifiLng;
	}

	public void setWifiLng(Float wifiLng) {
		this.wifiLng = wifiLng;
	}

	public Float getWifiLat() {
		return wifiLat;
	}

	public void setWifiLat(Float wifiLat) {
		this.wifiLat = wifiLat;
	}

	public Float getWifiX() {
		return wifiX;
	}

	public void setWifiX(Float wifiX) {
		this.wifiX = wifiX;
	}

	public Float getWifiY() {
		return wifiY;
	}

	public void setWifiY(Float wifiY) {
		this.wifiY = wifiY;
	}

	public Float getWifiXMin() {
		return wifiXMin;
	}

	public void setWifiXMin(Float wifiXMin) {
		this.wifiXMin = wifiXMin;
	}

	public Float getWifiXMax() {
		return wifiXMax;
	}

	public void setWifiXMax(Float wifiXMax) {
		this.wifiXMax = wifiXMax;
	}

	public Float getWifiYMin() {
		return wifiYMin;
	}

	public void setWifiYMin(Float wifiYMin) {
		this.wifiYMin = wifiYMin;
	}

	public Float getWifiYMax() {
		return wifiYMax;
	}

	public void setWifiYMax(Float wifiYMax) {
		this.wifiYMax = wifiYMax;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getZoomPicUrl() {
		if(picUrl != null && !"".equals(picUrl)){
			zoomPicUrl = picUrl.replaceAll("/showFtpFile", "/showFtpZoomFile");
		}
		return zoomPicUrl;
	}

	public void setZoomPicUrl(String zoomPicUrl) {
		this.zoomPicUrl = zoomPicUrl;
	}

	public Date getVipEndTime() {
		return vipEndTime;
	}

	public void setVipEndTime(Date vipEndTime) {
		this.vipEndTime = vipEndTime;
	}
}