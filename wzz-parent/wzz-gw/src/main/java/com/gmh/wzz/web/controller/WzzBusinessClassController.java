package com.gmh.wzz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/v1")
public class WzzBusinessClassController {
	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/bc", method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取机构", httpMethod = "GET", response = Page.class, notes = "/v1/bc")
	public @ResponseBody Page<WzzBusinessClassEntity> findBusinessClasses(
			WzzBusinessClassEntity condition, Order order, int pageIndex,
			int pageSize) {
		Page<WzzBusinessClassEntity> results = null;
		try {
			results = wzzService.findWzzBusinessClass(
					condition, order, pageIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	public WzzService getWzzService() {
		return wzzService;
	}

	public void setWzzService(WzzService wzzService) {
		this.wzzService = wzzService;
	}
}
