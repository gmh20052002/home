package com.gmh.wzz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzUserEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "wzz-user-api", description = "用户信息的CURD操作")
@Controller
public class WzzUserController {

	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v1/User", method = RequestMethod.GET)
	@ApiOperation(value = "查询用户信息", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzUserEntity> findUsers(
			@ModelAttribute WzzUserEntity condition, @ModelAttribute Order order, @RequestParam(defaultValue="1") Integer pageIndex,
			@RequestParam(defaultValue="10")Integer pageSize) {
		Page<WzzUserEntity> results = null;
		try {
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageIndex;
			results = wzzService.findWzzUser(condition, order, pageIndex,
					pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/User", method = RequestMethod.POST)
	@ApiOperation(value = "新增用户信息", httpMethod = "POST", response = WzzUserEntity.class)
	public @ResponseBody WzzUserEntity addUseres(WzzUserEntity data) {
		WzzUserEntity result = null;
		try {
			wzzService.insertWzzUser(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/User/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取用户信息", httpMethod = "GET", response = WzzUserEntity.class)
	public @ResponseBody WzzUserEntity getWzzUserById(
			@PathVariable String id) throws Exception {
		WzzUserEntity result = null;
		try {
			result = wzzService.getWzzUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/User", method = RequestMethod.PUT)
	@ApiOperation(value = "修改用户信息", httpMethod = "PUT", response = WzzUserEntity.class)
	public WzzUserEntity updateWzzUser(WzzUserEntity data)
			throws Exception {
		WzzUserEntity result = null;
		try {
			result = wzzService.updateWzzUser(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/User", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除用户信息", httpMethod = "DELETE", response = WzzUserEntity.class)
	public WzzUserEntity deleteWzzUser(WzzUserEntity data)
			throws Exception {
		WzzUserEntity result = null;
		try {
			result = wzzService.deleteWzzUser(data);
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
