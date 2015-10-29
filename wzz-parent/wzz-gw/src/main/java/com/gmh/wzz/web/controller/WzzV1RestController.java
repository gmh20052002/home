package com.gmh.wzz.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gmh.wzz.api.entity.MessageCode;
import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.Sort;
import com.gmh.wzz.api.entity.WzzWifiShopDiscEntity;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.entity.WzzWifiShopJobEntity;
import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "Wzz-Rest-Controller-V1", description = "网蜘蛛Rest接口V1版本", position = 1)
@Controller()
public class WzzV1RestController {

	@Autowired
	WzzService wzzService;

	public WzzService getWzzService() {
		return wzzService;
	}

	public void setWzzService(WzzService wzzService) {
		this.wzzService = wzzService;
	}

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
			pageSize = pageSize == null ? 10 : pageSize;
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
			@RequestParam(defaultValue = "0", required = true) @ApiParam(value = "wifi坐标经度距离") Float wifix,
			@RequestParam(defaultValue = "0", required = true) @ApiParam(value = "wifi坐标纬度距离") Float wifiY,
			@RequestParam(defaultValue = "1") @ApiParam(value = "分页参数，当前页码") Integer pageIndex,
			@RequestParam(defaultValue = "10") @ApiParam(value = "分页参数，每页最大记录数") Integer pageSize) {
		Page<WzzWifiShopEntity> results = null;
		try {
			WzzWifiShopEntity condition = new WzzWifiShopEntity();
			Float wifiScope = wzzService.getWzz_wifi_search_scope();
			condition.setWifiXMin(wifix - wifiScope);
			condition.setWifiYMin(wifiY - wifiScope);
			condition.setWifiXMax(wifix + wifiScope);
			condition.setWifiYMax(wifiY + wifiScope);
			Order order = new Order();
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageSize;
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
	public @ResponseBody WzzWifiShopEntity addWifiShop(
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
	public @ResponseBody WzzWifiShopEntity updateWzzWifiShop(
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
	
	@RequestMapping(value = "/v1/getMessageCode", method = RequestMethod.GET)
	@ApiOperation(value = "获取短信验证码", httpMethod = "GET", response = MessageCode.class)
	public @ResponseBody MessageCode getMessageCode(
			@RequestParam(required = true) @ApiParam(value = "手机号码，必填") String mobilePhone) {
		MessageCode ret = null;
		String randNum = getRandNum(6);
		String timeOut = wzzService.getSMSServerTimeout();
		
		String msgContent = "【网蜘蛛】短信验证码:" + randNum + "请在"+timeOut+"分钟内输入，校验码很重要，打死都不能告诉别人~~";
		try {
			wzzService.sendMsg(msgContent, mobilePhone);
			ret = new MessageCode();
			ret.setMessageCode(randNum);
			ret.setTimeOut(Long.parseLong(timeOut));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*@RequestMapping(value = "/v1/getMessageCode", method = RequestMethod.GET)
	@ApiOperation(value = "获取短信验证码", httpMethod = "GET", response = MessageCode.class)
	public @ResponseBody MessageCode getMessageCode(
			@RequestParam(required = true) @ApiParam(value = "手机号码，必填") String mobilePhone) {
		MessageCode ret = null;
		HashMap<String, Object> result = null;

		// 初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

		// ******************************注释*********************************************
		// *初始化服务器地址和端口 *
		// *沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
		// *生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883"); *
		// *******************************************************************************
		restAPI.init(wzzService.getSMSServerHost(),
				wzzService.getSMSServerPort());

		// ******************************注释*********************************************
		// *初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN *
		// *ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
		// *参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。 *
		// *******************************************************************************
		restAPI.setAccount(wzzService.getSMSServerUserName(),
				wzzService.getSMSServerPassword());

		// ******************************注释*********************************************
		// *初始化应用ID *
		// *测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID *
		// *应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
		// *******************************************************************************
		restAPI.setAppId(wzzService.getSMSServerAppId());

		// ******************************注释****************************************************************
		// *调用发送模板短信的接口发送短信 *
		// *参数顺序说明： *
		// *第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号 *
		// *第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。 *
		// *系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
		// *第三个参数是要替换的内容数组。 *
		// **************************************************************************************************

		// **************************************举例说明***********************************************************************
		// *假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为
		// *
		// *result = restAPI.sendTemplateSMS("13800000000","1" ,new
		// String[]{"6532","5"}); *
		// *则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入 *
		// *********************************************************************************************************************
		String randNum = getRandNum(6);
		String timeOut = wzzService.getSMSServerTimeout();
		result = restAPI.sendTemplateSMS(mobilePhone,
				wzzService.getSMSServerTempleteId(), new String[] { randNum,
						timeOut });

		System.out.println("SDKTestGetSubAccounts result=" + result);
		if ("000000".equals(result.get("statusCode"))) {
			long time = System.currentTimeMillis();
			// 正常返回输出data包体信息（map）
			
			 * HashMap<String, Object> data = (HashMap<String, Object>) result
			 * .get("data"); Set<String> keySet = data.keySet(); for (String key
			 * : keySet) { Object object = data.get(key); System.out.println(key
			 * + " = " + object); }
			 
			ret = new MessageCode();
			ret.setMessageCode(randNum);
			ret.setTimeOut(time + Long.parseLong(timeOut) * 60 * 1000);
		} else {
			// 异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= "
					+ result.get("statusMsg"));
		}
		return ret;
	}*/

	@RequestMapping(value = "/v1/UploadFiles", method = RequestMethod.POST)
	@ApiOperation(value = "文件上传", httpMethod = "POST", response = String.class)
	public @ResponseBody String uploadFile(
			HttpServletRequest request,
			@RequestParam(required = false) @ApiParam(value = "省份代码") String province,
			@RequestParam(required = false) @ApiParam(value = "地市代码") String city,
			@RequestParam(value = "file", required = true) @ApiParam(value = "文件附件对象<MultipartFile>，必填") MultipartFile file) {
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;
		String fileUrls = "";
		try {
			String fileName = file.getOriginalFilename();
			String uuidFileName = UUID.randomUUID().toString()
					.replaceAll("-", "")
					+ fileName.substring(fileName.lastIndexOf("."));
			ftpClient.connect(wzzService.getWzz_ftp_url());
			ftpClient.login(wzzService.getWzz_ftp_userName(),
					wzzService.getWzz_ftp_password());

			String uploadPath = wzzService.getWzz_ftp_tmpfile_path();
			if (!StringUtils.isEmpty(province)) {
				uploadPath += province + "/";
			}
			if (!StringUtils.isEmpty(city)) {
				uploadPath += city + "/";
			}
			ftpClient.makeDirectory(uploadPath);
			// 设置上传目录
			ftpClient.changeWorkingDirectory(uploadPath);
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("UTF-8");
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.storeFile(uuidFileName, file.getInputStream());
			fileUrls = "ftp://" + wzzService.getWzz_ftp_url() + uploadPath
					+ uuidFileName;
			System.out.println("成功！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("FTP客户端出错！", e);
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
		return fileUrls;
	}

	@RequestMapping(value = "/v1/WifiShopDisc", method = RequestMethod.POST)
	@ApiOperation(value = "发布WIFI商铺优惠信息", httpMethod = "POST", response = WzzWifiShopDiscEntity.class)
	public @ResponseBody WzzWifiShopDiscEntity addWifiShopDisc(
			@RequestBody @ApiParam(value = "wifi商铺优惠信息实体对象") WzzWifiShopDiscEntity data) {
		WzzWifiShopDiscEntity result = null;
		try {
			result = wzzService.insertWzzWifiShopDisc(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/wifiShopDiscs", method = RequestMethod.GET)
	@ApiOperation(value = "查询WIFI商铺优惠信息", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopDiscEntity> findWifiShopDiscs(
			@RequestParam(required = true) @ApiParam(value = "wifi商铺ID") String shopId,
			@RequestParam(defaultValue = "1") @ApiParam(value = "分页参数，当前页码") Integer pageIndex,
			@RequestParam(defaultValue = "10") @ApiParam(value = "分页参数，每页最大记录数") Integer pageSize) {
		Page<WzzWifiShopDiscEntity> results = null;
		try {
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageSize;
			Order order = new Order();
			order.setOrderBy("START", Sort.DESC);
			WzzWifiShopDiscEntity condition = new WzzWifiShopDiscEntity();
			condition.setShopId(shopId);
			results = wzzService.findWzzWifiShopDisc(condition, order,
					pageIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@RequestMapping(value = "/v1/WifiShopJob", method = RequestMethod.POST)
	@ApiOperation(value = "发布WIFI商铺招聘信息", httpMethod = "POST", response = WzzWifiShopJobEntity.class)
	public @ResponseBody WzzWifiShopJobEntity addWifiShopJob(
			@RequestBody @ApiParam(value = "wifi商铺招聘信息实体对象") WzzWifiShopJobEntity data) {
		WzzWifiShopJobEntity result = null;
		try {
			result = wzzService.insertWzzWifiShopJob(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/wifiShopJobs", method = RequestMethod.GET)
	@ApiOperation(value = "查询WIFI商铺招聘信息", httpMethod = "GET", response = Page.class)
	public @ResponseBody Page<WzzWifiShopJobEntity> findWifiShopJobs(
			@RequestParam(required = true) @ApiParam(value = "wifi商铺ID") String shopId,
			@RequestParam(defaultValue = "1") @ApiParam(value = "分页参数，当前页码") Integer pageIndex,
			@RequestParam(defaultValue = "10") @ApiParam(value = "分页参数，每页最大记录数") Integer pageSize) {
		Page<WzzWifiShopJobEntity> results = null;
		try {
			pageIndex = (pageIndex == null || pageIndex <= 0) ? 1 : pageIndex;
			pageSize = pageSize == null ? 10 : pageSize;
			Order order = new Order();
			order.setOrderBy("START", Sort.DESC);
			WzzWifiShopJobEntity condition = new WzzWifiShopJobEntity();
			condition.setShopId(shopId);
			results = wzzService.findWzzWifiShopJob(condition, order,
					pageIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	private String getRandNum(int charCount) {
		String charValue = "";
		for (int i = 0; i < charCount; i++) {
			char c = (char) (randomInt(0, 10) + '0');
			charValue += String.valueOf(c);
		}
		return charValue;
	}

	private int randomInt(int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to - from);
	}
}
