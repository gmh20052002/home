package com.gmh.wzz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "Wzz-Rest-Controller-V1", description = "网蜘蛛Rest接口V1版本")
@Controller
public class WzzV1RestController {

	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v1/findWifiShopsByType", method = RequestMethod.GET)
	@ApiOperation(value = "根据类别分页查询WIFI店铺", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopEntity> findWifiShopsByType(
			@RequestParam(defaultValue = "") String classType1,
			@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Page<WzzWifiShopEntity> results = null;
		try {
			WzzWifiShopEntity condition = new WzzWifiShopEntity();
			condition.setClassType1(classType1);
			Order order = new Order();
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageIndex;
			results = wzzService.findWzzWifiShop(condition, order, pageIndex,
					pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/findWifiShopsByXY", method = RequestMethod.GET)
	@ApiOperation(value = "附近的WIFI店铺", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopEntity> findWifiShopsByXY(
			@RequestParam(defaultValue = "0",required=true) Integer wifiX,
			@RequestParam(defaultValue = "0",required=true) Integer wifiY,
			@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Page<WzzWifiShopEntity> results = null;
		try {
			WzzWifiShopEntity condition = new WzzWifiShopEntity();
			int wifiScope = wzzService.getWzz_wifi_search_scope();
			condition.setWifiXMin(wifiX - wifiScope);
			condition.setWifiYMin(wifiY - wifiScope);
			condition.setWifiXMax(wifiX + wifiScope);
			condition.setWifiYMax(wifiY + wifiScope);
			Order order = new Order();
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageIndex;
			results = wzzService.findWzzWifiShop(condition, order, pageIndex,
					pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/getWifiShopById", method = RequestMethod.GET)
	@ApiOperation(value = "根据ID查询WIFI店铺", httpMethod = "GET", response = WzzWifiShopEntity.class)
	public @ResponseBody WzzWifiShopEntity getWifiShopById(@RequestParam String shopId) {
		WzzWifiShopEntity results = null;
		try {
			results = wzzService.getWzzWifiShopById(shopId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/getWifiShopByWifiSSID", method = RequestMethod.GET)
	@ApiOperation(value = "根据WIFI标识查询WIFI店铺，可以判断wifi是否开通店铺", httpMethod = "GET", response = WzzWifiShopEntity.class)
	public @ResponseBody WzzWifiShopEntity getWifiShopByWifiSSID(@RequestParam String wifiSSId) {
		WzzWifiShopEntity results = null;
		Page<WzzWifiShopEntity> list = null;
		try {
			WzzWifiShopEntity condition = new WzzWifiShopEntity();
			condition.setWifi(wifiSSId);
			Order order = new Order();
			list = wzzService.findWzzWifiShop(condition, order, 1, 1);
			if (list != null && list.getDatas() != null) {
				results = list.getDatas().get(0);
			}
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

	public WzzService getWzzService() {
		return wzzService;
	}

	public void setWzzService(WzzService wzzService) {
		this.wzzService = wzzService;
	}
}
