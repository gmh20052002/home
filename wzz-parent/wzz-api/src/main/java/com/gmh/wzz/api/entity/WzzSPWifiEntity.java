package com.gmh.wzz.api.entity;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WzzSPWifiEntity-商铺wifi对象")
public class WzzSPWifiEntity {
	@ApiModelProperty(value = "商铺id，新增可以为空")
    private String shopId;

	@ApiModelProperty(value = "wifi-ssid，可以为空")
    private String ssid;
	
	@ApiModelProperty(value = "wifiBSSID，唯一标识")
    private String wifi;

	@ApiModelProperty(value = "wifi密码")
    private String wifiPassword;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
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

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
}