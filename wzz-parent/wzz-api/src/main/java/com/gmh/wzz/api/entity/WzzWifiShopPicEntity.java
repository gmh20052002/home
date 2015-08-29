package com.gmh.wzz.api.entity;

import java.io.Serializable;

public class WzzWifiShopPicEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    private String shopId;

    private String picUrl;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }
}