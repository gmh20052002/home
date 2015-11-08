package com.gmh.wzz.api.entity;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="WzzWifiShopDiscEntity-wifi商铺优惠信息")
public class WzzWifiShopDiscEntity {
	@ApiModelProperty(value="主键，必填",required=true)
    private String id;

	@ApiModelProperty(value="店铺ID，必填",required=true)
    private String shopId;

	@ApiModelProperty(value="标题，必填",required=true)
    private String title;

	@ApiModelProperty(value="描述",required=false)
    private String remark;

	@ApiModelProperty(value="电话",required=false)
    private String phone;

	@ApiModelProperty(value="开始时间，格式：yyyy-MM-dd",required=false)
    private Date start;

	@ApiModelProperty(value="结束时间，格式：yyyy-MM-dd",required=false)
    private Date end;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}