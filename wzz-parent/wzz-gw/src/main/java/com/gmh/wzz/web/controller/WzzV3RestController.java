package com.gmh.wzz.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzUserEntity;
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

	public WzzService getWzzService() {
		return wzzService;
	}

	public void setWzzService(WzzService wzzService) {
		this.wzzService = wzzService;
	}
}
