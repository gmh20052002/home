package com.gmh.wzz.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gmh.wzz.api.service.WzzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "wzz-fileUpload-api", description = "文件上传服务")
@Controller
public class WzzFileUploadController {
	@Autowired
	WzzService wzzService;

	@RequestMapping(value = "/v1/UploadFile", method = RequestMethod.POST)
	@ApiOperation(value = "文件上传", httpMethod = "POST", response = String.class)
	public @ResponseBody String uploadFile(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;

		String fileName = file.getOriginalFilename();
		String uuidFileName = UUID.randomUUID().toString().replaceAll("-", "")
				+ fileName.substring(fileName.lastIndexOf("."));
		try {
			ftpClient.connect(wzzService.getWzz_ftp_url());
			ftpClient.login(wzzService.getWzz_ftp_userName(),
					wzzService.getWzz_ftp_password());
			// 设置上传目录
			ftpClient.changeWorkingDirectory(wzzService
					.getWzz_ftp_tmpfile_path());
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("UTF-8");
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.storeFile(uuidFileName, file.getInputStream());
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
		return "ftp://" + wzzService.getWzz_ftp_url()
				+ wzzService.getWzz_ftp_tmpfile_path() + uuidFileName;
	}
}
