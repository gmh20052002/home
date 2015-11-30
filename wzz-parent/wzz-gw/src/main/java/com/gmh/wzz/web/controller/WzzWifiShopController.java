package com.gmh.wzz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.ApiOperation;

//@Api(value = "wzz-wifishop-api", description = "WIFI店铺信息的CURD操作")
//@Controller
public class WzzWifiShopController {
	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v1/WifiShop", method = RequestMethod.GET)
	@ApiOperation(value = "查询WIFI店铺", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopEntity> findWifiShops(
			@ModelAttribute WzzWifiShopEntity condition, @ModelAttribute Order order, @RequestParam(defaultValue="1") Integer pageIndex,
			@RequestParam(defaultValue="10")Integer pageSize) {
		Page<WzzWifiShopEntity> results = null;
		try {
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageIndex;
			results = wzzService.findWzzWifiShop(condition, order, pageIndex,
					pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/WifiShop", method = RequestMethod.POST)
	@ApiOperation(value = "新增WIFI店铺", httpMethod = "POST", response = WzzWifiShopEntity.class)
	public @ResponseBody WzzWifiShopEntity addWifiShopes(@RequestBody WzzWifiShopEntity data) {
		WzzWifiShopEntity result = null;
		try {
			wzzService.insertWzzWifiShop(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/WifiShop/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取WIFI店铺", httpMethod = "GET", response = WzzWifiShopEntity.class)
	public @ResponseBody WzzWifiShopEntity getWzzWifiShopById(
			@PathVariable String id) throws Exception {
		WzzWifiShopEntity result = null;
		try {
			result = wzzService.getWzzWifiShopById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/WifiShop", method = RequestMethod.PUT)
	@ApiOperation(value = "修改WIFI店铺", httpMethod = "PUT", response = WzzWifiShopEntity.class)
	public WzzWifiShopEntity updateWzzWifiShop(@RequestBody WzzWifiShopEntity data)
			throws Exception {
		WzzWifiShopEntity result = null;
		try {
			result = wzzService.updateWzzWifiShop(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/WifiShop", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除WIFI店铺", httpMethod = "DELETE", response = WzzWifiShopEntity.class)
	public WzzWifiShopEntity deleteWzzWifiShop(@RequestBody WzzWifiShopEntity data)
			throws Exception {
		WzzWifiShopEntity result = null;
		try {
			result = wzzService.deleteWzzWifiShop(data);
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
