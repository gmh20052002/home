package com.gmh.wzz.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
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
	Logger logger = Logger.getLogger(getClass());

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
	public @ResponseBody
	Page<WzzWifiShopEntity> findWifiShopsByTypeAndCity(
			@RequestParam(defaultValue = "", required = true) @ApiParam(required = true, value = "业务大类，值以注册wifi商铺时传入为准") String classType1,
			@RequestParam(required = false) @ApiParam(required = false, value = "城市，值以注册wifi商铺时传入为准") String city,
			@RequestParam(defaultValue = "1") @ApiParam(defaultValue = "1", value = "分页参数，当前页码") Integer pageIndex,
			@RequestParam(defaultValue = "10") @ApiParam(defaultValue = "10", value = "分页参数，每页最大记录数") Integer pageSize) {
		Page<WzzWifiShopEntity> results = null;
		try {
			WzzWifiShopEntity condition = new WzzWifiShopEntity();
			condition.setClassType1(classType1);
			condition.setCity(city);
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
	public @ResponseBody
	Page<WzzWifiShopEntity> findWifiShopsByXY(
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
	public @ResponseBody
	WzzWifiShopEntity getWifiShopById(
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
	public @ResponseBody
	WzzWifiShopEntity getWifiShopByWifiSSID(
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
	public @ResponseBody
	WzzWifiShopEntity addWifiShop(
			@RequestBody @ApiParam(value = "wifi商铺实体对象") WzzWifiShopEntity data) {
		WzzWifiShopEntity result = null;
		try {
			result = wzzService.insertWzzWifiShop(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/WifiShop", method = RequestMethod.PUT)
	@ApiOperation(value = "修改WIFI商铺", httpMethod = "PUT", response = WzzWifiShopEntity.class)
	public @ResponseBody
	WzzWifiShopEntity updateWzzWifiShop(
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
	public @ResponseBody
	MessageCode getMessageCode(
			@RequestParam(required = true) @ApiParam(value = "手机号码，必填") String mobilePhone) {
		MessageCode ret = null;
		String randNum = getRandNum(6);
		String timeOut = wzzService.getSMSServerTimeout();

		String msgContent = "【网蜘蛛】无线智慧城市创新实践者：您本次的短信验证码" + randNum + "请在" + timeOut
				+ "分钟内输入。";
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

	@RequestMapping(value = "/v1/UploadFiles", method = RequestMethod.POST)
	@ApiOperation(value = "文件上传", httpMethod = "POST", response = String.class)
	public @ResponseBody
	Map<String, Object> uploadFile(
			HttpServletRequest request,
			@RequestParam(required = false) @ApiParam(value = "省份代码") String province,
			@RequestParam(required = false) @ApiParam(value = "地市代码") String city,
			@RequestParam(value = "file", required = true) @ApiParam(value = "文件附件对象<MultipartFile>，必填") MultipartFile file) {
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;
		String fileUrls = "";
		try {
			// if (files != null) {
			// for (MultipartFile file : files) {
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
				ftpClient.makeDirectory(uploadPath);
			}
			if (!StringUtils.isEmpty(city)) {
				uploadPath += city + "/";
				ftpClient.makeDirectory(uploadPath);
			}
			// 设置上传目录
			ftpClient.changeWorkingDirectory(uploadPath);
			ftpClient.setBufferSize(1024);
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.setAutodetectUTF8(true);
			ftpClient.setControlEncoding("utf-8");
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(uuidFileName, file.getInputStream());
			fileUrls = uploadPath + uuidFileName;
			System.out.println("成功！");
			// }
			// }
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fileUrl",
				"http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl="
						+ fileUrls);
		return map;
	}

	@RequestMapping(value = "/v1/showFtpFile", method = RequestMethod.GET)
	@ApiOperation(value = "ftp文件显示", httpMethod = "GET")
	public void showFtpPic(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "ftpUrl", required = true) @ApiParam(value = "ftp文件路径") String ftpUrl) {
		FTPClient ftpClient = new FTPClient();
//		FileInputStream is = null;
//		OutputStream os = null;
//		OutputStream toClient = null;
//		File localFile = null;
		try {
			ftpClient.connect(wzzService.getWzz_ftp_url());
			ftpClient.login(wzzService.getWzz_ftp_userName(),
					wzzService.getWzz_ftp_password());
			// response.setContentType("multipart/form-data");
			// response.setContentType("application/x-msdownload");
			// response.setCharacterEncoding("UTF-8");
			/*
			 * <option value="image/bmp">BMP</option> <option
			 * value="image/gif">GIF</option> <option
			 * value="image/jpeg">JPEG</option> <option
			 * value="image/tiff">TIFF</option> <option
			 * value="image/x-dcx">DCX</option> <option
			 * value="image/x-pcx">PCX</option>
			 */
			logger.debug("response.getContentType====1=====>"
					+ response.getContentType());
			if (ftpUrl.toLowerCase().endsWith("bmp")) {
				response.setContentType("image/bmp");
			} else if (ftpUrl.toLowerCase().endsWith("gif")) {
				response.setContentType("image/gif");
			} else if (ftpUrl.toLowerCase().endsWith("jpeg")) {
				response.setContentType("image/jpeg");
			} else if (ftpUrl.toLowerCase().endsWith("tiff")) {
				response.setContentType("image/tiff");
			} else if (ftpUrl.toLowerCase().endsWith("dcx")) {
				response.setContentType("image/x-dcx");
			} else if (ftpUrl.toLowerCase().endsWith("pcx")) {
				response.setContentType("image/x-pcx");
			} else if (ftpUrl.toLowerCase().endsWith("png")) {
				response.setContentType("image/png");
			} else {
				response.setContentType("image/jpeg");
			}
			ftpClient.setAutodetectUTF8(true);
			ftpClient.setControlEncoding("utf-8");
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			logger.debug("ftpClient.getControlEncoding=========>"
					+ ftpClient.getControlEncoding());
			logger.debug("response.getContentType====2=====>"
					+ response.getContentType());
			response.setLocale(Locale.CHINA);
			logger.debug("response.getLocale=========>" + response.getLocale());
//			String localPath = request.getSession().getServletContext()
//					.getRealPath("");
//			localFile = new File(localPath + File.separator
//					+ ftpUrl.substring(ftpUrl.lastIndexOf("/")));
//			os = new FileOutputStream(localFile);
//			System.out.println(ftpClient.retrieveFile(ftpUrl, os));
//
//			is = new FileInputStream(localFile);
//			int i = is.available(); // 得到文件大小
//			byte data[] = new byte[i];
//			is.read(data); // 读数据
//			toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
//			toClient.write(data); // 输出数据
			ftpClient.retrieveFile(ftpUrl, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ftpClient.disconnect();
//				if(toClient != null){
//					toClient.close();
//				}
//				if (is != null) {
//					is.close();
//				}
//				if (os != null) {
//					os.flush();
//					os.close();
//				}
//				if(localFile != null){
//					localFile.delete();
//				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
		// return response;
	}

	@RequestMapping(value = "/v1/WifiShopDisc", method = RequestMethod.POST)
	@ApiOperation(value = "发布WIFI商铺优惠信息", httpMethod = "POST", response = WzzWifiShopDiscEntity.class)
	public @ResponseBody
	WzzWifiShopDiscEntity addWifiShopDisc(
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
	public @ResponseBody
	Page<WzzWifiShopDiscEntity> findWifiShopDiscs(
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

	@RequestMapping(value = "/v1/getWifiShopDiscById", method = RequestMethod.GET)
	@ApiOperation(value = "获取优惠信息明细", httpMethod = "GET", response = WzzWifiShopDiscEntity.class)
	public @ResponseBody
	WzzWifiShopDiscEntity getWifiShopDiscById(
			@RequestParam(required = true) @ApiParam(value = "优惠信息Id") String id) {
		WzzWifiShopDiscEntity result = null;
		try {
			result = wzzService.getWzzWifiShopDiscById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/v1/WifiShopJob", method = RequestMethod.POST)
	@ApiOperation(value = "发布WIFI商铺招聘信息", httpMethod = "POST", response = WzzWifiShopJobEntity.class)
	public @ResponseBody
	WzzWifiShopJobEntity addWifiShopJob(
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
	public @ResponseBody
	Page<WzzWifiShopJobEntity> findWifiShopJobs(
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

	@RequestMapping(value = "/v1/getWifiShopJobById", method = RequestMethod.GET)
	@ApiOperation(value = "获取招聘信息明细", httpMethod = "GET", response = WzzWifiShopJobEntity.class)
	public @ResponseBody
	WzzWifiShopJobEntity getWifiShopJobById(
			@RequestParam(required = true) @ApiParam(value = "招聘信息Id") String id) {
		WzzWifiShopJobEntity result = null;
		try {
			result = wzzService.getWzzWifiShopJobById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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
