package com.gmh.wzz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzWifiShopPicEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

//@Api(value = "wzz-WifiShopPic-api", description = "WIFI店铺图片信息的CURD操作")
//@Controller
public class WzzWifiShopPicController {
	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v1/WifiShopPic", method = RequestMethod.GET)
	@ApiOperation(value = "查询WIFI店铺图片", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopPicEntity> findWifiShopPics(
			@ModelAttribute WzzWifiShopPicEntity condition, @ModelAttribute Order order, @RequestParam(defaultValue="1") Integer pageIndex,
			@RequestParam(defaultValue="10")Integer pageSize) {
		Page<WzzWifiShopPicEntity> results = null;
		try {
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageIndex;
			results = wzzService.findWzzWifiShopPic(condition, order, pageIndex,
					pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/WifiShopPic", method = RequestMethod.POST)
	@ApiOperation(value = "新增WIFI店铺图片", httpMethod = "POST", response = WzzWifiShopPicEntity.class)
	public @ResponseBody WzzWifiShopPicEntity addWifiShopPices(@RequestBody WzzWifiShopPicEntity data) {
		WzzWifiShopPicEntity result = null;
		try {
			wzzService.insertWzzWifiShopPic(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value = "/v1/WifiShopPic", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除WIFI店铺图片", httpMethod = "DELETE", response = WzzWifiShopPicEntity.class)
	public WzzWifiShopPicEntity deleteWzzWifiShopPic(@RequestBody WzzWifiShopPicEntity data)
			throws Exception {
		WzzWifiShopPicEntity result = null;
		try {
			result = wzzService.deleteWzzWifiShopPic(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public WzzService getWzzService() {
		return wzzService;
	}

	public void setWzzService(WzzService wzzService) {
		this.wzzService = wzzService;
	}
}
