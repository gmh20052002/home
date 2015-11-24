package com.gmh.wzz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

@Api(value = "Wzz-Rest-Controller-V2", description = "网蜘蛛Rest接口V2版本", position = 1)
@Controller
public class WzzV2RestController {

	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v2/registryUser", method = RequestMethod.POST)
	@ApiOperation(value = "注册用户", httpMethod = "POST", response = WzzUserEntity.class)
	public @ResponseBody
	WzzUserEntity addUseres(
			@RequestBody @ApiParam(value = "用户信息实体对象") WzzUserEntity data) {
		WzzUserEntity result = null;
		try {
			result = wzzService.insertWzzUser(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v2/User/login", method = RequestMethod.GET)
	@ApiOperation(value = "用户登录", httpMethod = "GET", response = Boolean.class)
	public @ResponseBody
	WzzUserEntity login(
			@RequestParam(required = true) @ApiParam(value = "用户类型") String userType,
			@RequestParam(required = true) @ApiParam(value = "用户登录名(手机号)") String userName,
			@RequestParam(required = true) @ApiParam(value = "登录密码") String password) {
		Page<WzzUserEntity> results = null;
		try {
			WzzUserEntity condition = new WzzUserEntity();
			condition.setUserType(userType);
			condition.setUserName(userName);
			condition.setPassword(password);
			results = wzzService.findWzzUser(condition, null, 1, 10);
			if (results != null && results.getTotalSize() > 0
					&& results.getDatas() != null) {
				return results.getDatas().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/v2/User/findPassword", method = RequestMethod.GET)
	@ApiOperation(value = "找回密码，短信接收", httpMethod = "GET", response = String.class)
	public @ResponseBody
	String findPassword(
			@RequestParam(required = true) @ApiParam(value = "用户登录名(手机号)") String userName) {
		Page<WzzUserEntity> results = null;
		try {
			WzzUserEntity condition = new WzzUserEntity();
			condition.setUserName(userName);
			results = wzzService.findWzzUser(condition, null, 1, 10);
			if (results != null && results.getTotalSize() > 0
					&& results.getDatas() != null) {
				WzzUserEntity ret = results.getDatas().get(0);
				if (ret != null) {
					String password = ret.getPassword();
					String msgContent = "【网蜘蛛】我们不仅仅是全城免费WIFI工具。您通过手机短信验证找回原密码，您的原密码为"
							+ password;
					wzzService.sendMsg(msgContent, userName);
					return "找回密码成功，已发送到手机号：" + userName;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "密码获取失败";
	}

	public WzzService getWzzService() {
		return wzzService;
	}

	public void setWzzService(WzzService wzzService) {
		this.wzzService = wzzService;
	}
}
