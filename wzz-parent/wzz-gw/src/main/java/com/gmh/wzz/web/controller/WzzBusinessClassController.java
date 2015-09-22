package com.gmh.wzz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

//@Api(value = "wzz-businessClass-api", description = "有关于业务分类的CURD操作")
//@Controller
public class WzzBusinessClassController {
	@Autowired
	WzzService wzzService;

	@RequestMapping(value="/v1/BusinessClass", method = RequestMethod.GET)
	@ApiOperation(value = "查询业务分类", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzBusinessClassEntity> findBusinessClasses(
			@ModelAttribute WzzBusinessClassEntity condition, @ModelAttribute Order order, @RequestParam(defaultValue="1") Integer pageIndex,
			@RequestParam(defaultValue="10")Integer pageSize) {
		Page<WzzBusinessClassEntity> results = null;
		try {
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageSize;
			results = wzzService.findWzzBusinessClass(
					condition, order, pageIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value="/v1/BusinessClass",method = RequestMethod.POST)
	@ApiOperation(value = "新增业务分类", httpMethod = "POST", response = WzzBusinessClassEntity.class)
	public @ResponseBody WzzBusinessClassEntity addBusinessClasses(@RequestBody WzzBusinessClassEntity data) {
		WzzBusinessClassEntity result = null;
		try {
			wzzService.insertWzzBusinessClass(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value="/v1/BusinessClass/{id}",method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取业务分类", httpMethod = "GET", response = WzzBusinessClassEntity.class)
	public @ResponseBody WzzBusinessClassEntity getWzzBusinessClassById(@PathVariable String id)
			throws Exception {
		WzzBusinessClassEntity result = null;
		try {
			result = wzzService.getWzzBusinessClassById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value="/v1/BusinessClass",method = RequestMethod.PUT)
	@ApiOperation(value = "修改业务分类", httpMethod = "PUT", response = WzzBusinessClassEntity.class)
	public WzzBusinessClassEntity updateWzzBusinessClass(
			@RequestBody WzzBusinessClassEntity data) throws Exception {
		WzzBusinessClassEntity result = null;
		try {
			result = wzzService.updateWzzBusinessClass(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value="/v1/BusinessClass",method = RequestMethod.DELETE)
	@ApiOperation(value = "删除业务分类", httpMethod = "DELETE", response = WzzBusinessClassEntity.class)
	public WzzBusinessClassEntity deleteWzzBusinessClass(
			@RequestBody WzzBusinessClassEntity data) throws Exception {
		WzzBusinessClassEntity result = null;
		try {
			result = wzzService.deleteWzzBusinessClass(data);
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
