package com.gmh.wzz.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzSPWifiEntity;
import com.gmh.wzz.api.entity.WzzUserEntity;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "Wzz-Rest-Controller-V3", description = "网蜘蛛Rest接口V3版本", position = 2)
@Controller
public class WzzV3RestController {
	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v3/delayVipUser", method = RequestMethod.POST)
	@ApiOperation(value = "修改VIP用户到期时间", httpMethod = "POST", response = WzzUserEntity.class)
	public @ResponseBody WzzUserEntity delayVipUser(
			@RequestParam(required = true) @ApiParam(value = "vip用户账号(手机号)") String userName,
			@RequestParam(required = true) @ApiParam(value = "vip到期时间，格式：yyyy-MM-dd HH:mm:ss") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
		WzzUserEntity data = null;
		try {
			WzzUserEntity condition = new WzzUserEntity();
			condition.setUserName(userName);
			Page<WzzUserEntity> results = wzzService.findWzzUser(condition, null, 1, 10);
			if (results != null && results.getTotalSize() > 0 && results.getDatas() != null) {
				data = results.getDatas().get(0);
				data.setEndTime(endTime);
				wzzService.updateWzzUser(data);
				data = wzzService.getWzzUserById(data.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@RequestMapping(value = "/v3/findWifisByShopId", method = RequestMethod.GET)
	@ApiOperation(value = "根据商铺id查询所有的wifi", httpMethod = "GET", response = WzzUserEntity.class)
	public @ResponseBody List<WzzSPWifiEntity> findShopIdsByWifi(
			@RequestParam(required = true) @ApiParam(value = "商铺id") String shopId) {
		List<WzzSPWifiEntity> result = null;
		try {
			WzzSPWifiEntity condition = new WzzSPWifiEntity();
			condition.setShopId(shopId);
			Page<WzzSPWifiEntity> results = wzzService.findWzzSPWifiEntity(condition, null, 1, 10);
			if (results != null && results.getTotalSize() > 0 && results.getDatas() != null) {
				result = results.getDatas();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*@RequestMapping(value = "/v3/getWifiShopsByWifiBSSID", method = RequestMethod.GET)
	@ApiOperation(value = "根据WIFI BSSID查询所有WIFI商铺", httpMethod = "GET", response = WzzWifiShopEntity.class)
	public @ResponseBody List<WzzWifiShopEntity> getWifiShopByWifiSSID(
			@RequestParam @ApiParam(value = "wifi地址BSSID") String wifiBSSId) {
		List<WzzWifiShopEntity> results = null;
		try {
			Order order = new Order();
			WzzSPWifiEntity condition1 = new WzzSPWifiEntity();
			condition1.setWifi(wifiBSSId);
			Page<WzzSPWifiEntity> wifis = wzzService.findWzzSPWifiEntity(condition1, order, 1, 1000);
			results = new ArrayList<WzzWifiShopEntity>();
			if (wifis != null && wifis.getDatas() != null && wifis.getTotalSize() > 0) {
				for (WzzSPWifiEntity wifi : wifis.getDatas()) {
					WzzWifiShopEntity tmp = wzzService.getWzzWifiShopById(wifi.getShopId());
					if (tmp != null) {
						results.add(tmp);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}*/

	public WzzService getWzzService() {
		return wzzService;
	}

	public void setWzzService(WzzService wzzService) {
		this.wzzService = wzzService;
	}
}
