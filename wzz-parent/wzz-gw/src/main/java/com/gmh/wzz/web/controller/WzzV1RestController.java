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
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "Wzz-Rest-Controller-V1", description = "网蜘蛛Rest接口V1版本",position=1)
@Controller()
public class WzzV1RestController {

	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v1/findWifiShopsByType", method = RequestMethod.GET)
	@ApiOperation(value = "根据类别分页查询WIFI商铺", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopEntity> findWifiShopsByType(
			@RequestParam(defaultValue = "", required = true) @ApiParam(required = true, value = "业务大类，值以注册wifi商铺时传入为准") String classType1,
			@RequestParam(defaultValue = "1") @ApiParam(defaultValue = "1", value = "分页参数，当前页码") Integer pageIndex,
			@RequestParam(defaultValue = "10") @ApiParam(defaultValue = "10", value = "分页参数，每页最大记录数") Integer pageSize) {
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
	@ApiOperation(value = "附近的WIFI商铺，默认搜索范围500", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopEntity> findWifiShopsByXY(
			@RequestParam(defaultValue = "0", required = true) @ApiParam(value = "wifi坐标X轴的值") Integer wifiX,
			@RequestParam(defaultValue = "0", required = true) @ApiParam(value = "wifi坐标Y轴的值") Integer wifiY,
			@RequestParam(defaultValue = "1") @ApiParam(value = "分页参数，当前页码") Integer pageIndex,
			@RequestParam(defaultValue = "10") @ApiParam(value = "分页参数，每页最大记录数") Integer pageSize) {
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
	@ApiOperation(value = "根据ID查询WIFI商铺", httpMethod = "GET", response = WzzWifiShopEntity.class)
	public @ResponseBody WzzWifiShopEntity getWifiShopById(
			@RequestParam(required = true) @ApiParam(value = "wifi商铺ID") String shopId) {
		WzzWifiShopEntity results = null;
		try {
			results = wzzService.getWzzWifiShopById(shopId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/getWifiShopByWifiBSSID", method = RequestMethod.GET)
	@ApiOperation(value = "根据WIFI BSSID查询WIFI商铺，可以判断wifi是否开通商铺", httpMethod = "GET", response = WzzWifiShopEntity.class)
	public @ResponseBody WzzWifiShopEntity getWifiShopByWifiSSID(
			@RequestParam @ApiParam(value = "wifi地址BSSID") String wifiBSSId) {
		WzzWifiShopEntity results = null;
		Page<WzzWifiShopEntity> list = null;
		try {
			WzzWifiShopEntity condition = new WzzWifiShopEntity();
			condition.setWifi(wifiBSSId);
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
	@ApiOperation(value = "新增WIFI商铺", httpMethod = "POST", response = WzzWifiShopEntity.class)
	public @ResponseBody WzzWifiShopEntity addWifiShopes(
			@RequestBody @ApiParam(value = "wifi商铺实体对象") WzzWifiShopEntity data) {
		WzzWifiShopEntity result = null;
		try {
			wzzService.insertWzzWifiShop(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/WifiShop", method = RequestMethod.PUT)
	@ApiOperation(value = "修改WIFI商铺", httpMethod = "PUT", response = WzzWifiShopEntity.class)
	public WzzWifiShopEntity updateWzzWifiShop(
			@RequestBody @ApiParam(value = "wifi商铺实体对象") WzzWifiShopEntity data)
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
