package com.gmh.wzz.core.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.entity.WzzUserEntity;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.entity.WzzWifiShopPicEntity;
import com.gmh.wzz.api.service.WzzService;
import com.gmh.wzz.core.dao.WzzBusinessClassEntityMapper;
import com.gmh.wzz.core.dao.WzzUserEntityMapper;
import com.gmh.wzz.core.dao.WzzWifiShopEntityMapper;
import com.gmh.wzz.core.dao.WzzWifiShopPicEntityMapper;

@Service
public class WzzServiceImpl implements WzzService {
	@Autowired
	private WzzBusinessClassEntityMapper wzzBusinessClassEntityMapper;
	@Autowired
	private WzzWifiShopEntityMapper wzzWifiShopEntityMapper;
	@Autowired
	private WzzWifiShopPicEntityMapper wzzWifiShopPicEntityMapper;
	@Autowired
	private WzzUserEntityMapper wzzUserEntityMapper;

	private String wzz_ftp_url = "120.25.226.197";
	private String wzz_ftp_userName = "www";
	private String wzz_ftp_password = "a85e0d3e6";
	private String wzz_ftp_tmpfile_path = "/mydata/tmp";

	public WzzBusinessClassEntityMapper getWzzBusinessClassEntityMapper() {
		return wzzBusinessClassEntityMapper;
	}

	public void setWzzBusinessClassEntityMapper(
			WzzBusinessClassEntityMapper wzzBusinessClassEntityMapper) {
		this.wzzBusinessClassEntityMapper = wzzBusinessClassEntityMapper;
	}

	public WzzWifiShopEntityMapper getWzzWifiShopEntityMapper() {
		return wzzWifiShopEntityMapper;
	}

	public void setWzzWifiShopEntityMapper(
			WzzWifiShopEntityMapper wzzWifiShopEntityMapper) {
		this.wzzWifiShopEntityMapper = wzzWifiShopEntityMapper;
	}

	public WzzUserEntityMapper getWzzUserEntityMapper() {
		return wzzUserEntityMapper;
	}

	public void setWzzUserEntityMapper(WzzUserEntityMapper wzzUserEntityMapper) {
		this.wzzUserEntityMapper = wzzUserEntityMapper;
	}

	@Override
	public Page<WzzBusinessClassEntity> findWzzBusinessClass(
			WzzBusinessClassEntity condition, Order order, int pageIndex,
			int pageSize) throws Exception {
		Page<WzzBusinessClassEntity> page = new Page<WzzBusinessClassEntity>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		wzzBusinessClassEntityMapper.selectByCondition(condition, order, page);
		return page;
	}

	@Override
	public WzzBusinessClassEntity getWzzBusinessClassById(String id)
			throws Exception {
		return wzzBusinessClassEntityMapper.selectByPrimaryKey(id);
	}

	@Override
	public WzzBusinessClassEntity insertWzzBusinessClass(
			WzzBusinessClassEntity data) throws Exception {
		Assert.notNull(data, "新增对象[WzzBusinessClassEntity]不能为空");
		if (StringUtils.isEmpty(data.getId())) {
			data.setId(UUID.randomUUID().toString());
		}
		wzzBusinessClassEntityMapper.insert(data);
		return data;
	}

	@Override
	public WzzBusinessClassEntity updateWzzBusinessClass(
			WzzBusinessClassEntity data) throws Exception {
		Assert.notNull(data, "修改对象[WzzBusinessClassEntity]不能为空");
		wzzBusinessClassEntityMapper.updateByPrimaryKeySelective(data);
		return data;
	}

	@Override
	public WzzBusinessClassEntity deleteWzzBusinessClass(
			WzzBusinessClassEntity data) throws Exception {
		Assert.notNull(data, "删除对象[WzzBusinessClassEntity]不能为空");
		wzzBusinessClassEntityMapper.deleteByPrimaryKey(data.getId());
		return data;
	}

	@Override
	public Page<WzzWifiShopEntity> findWzzWifiShop(WzzWifiShopEntity condition,
			Order order, int pageIndex, int pageSize) throws Exception {
		Page<WzzWifiShopEntity> page = new Page<WzzWifiShopEntity>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		wzzWifiShopEntityMapper.selectByCondition(condition, order, page);
		return page;
	}

	@Override
	public WzzWifiShopEntity getWzzWifiShopById(String id) throws Exception {
		return wzzWifiShopEntityMapper.selectByPrimaryKey(id);
	}

	@Override
	public WzzWifiShopEntity insertWzzWifiShop(WzzWifiShopEntity data)
			throws Exception {
		Assert.notNull(data, "新增对象[WzzWifiShopEntity]不能为空");
		if (StringUtils.isEmpty(data.getId())) {
			data.setId(UUID.randomUUID().toString());
		}
		wzzWifiShopEntityMapper.insert(data);
		return data;
	}

	@Override
	public WzzWifiShopEntity updateWzzWifiShop(WzzWifiShopEntity data)
			throws Exception {
		Assert.notNull(data, "修改对象[WzzWifiShopEntity]不能为空");
		wzzWifiShopEntityMapper.updateByPrimaryKeySelective(data);
		return data;
	}

	@Override
	public WzzWifiShopEntity deleteWzzWifiShop(WzzWifiShopEntity data)
			throws Exception {
		Assert.notNull(data, "删除对象[WzzWifiShopEntity]不能为空");
		wzzWifiShopEntityMapper.deleteByPrimaryKey(data.getId());
		return data;
	}

	@Override
	public Page<WzzUserEntity> findWzzUser(WzzUserEntity condition,
			Order order, int pageIndex, int pageSize) throws Exception {
		Page<WzzUserEntity> page = new Page<WzzUserEntity>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		wzzUserEntityMapper.selectByCondition(condition, order, page);
		return page;
	}

	@Override
	public WzzUserEntity getWzzUserById(String id) throws Exception {
		return wzzUserEntityMapper.selectByPrimaryKey(id);
	}

	@Override
	public WzzUserEntity insertWzzUser(WzzUserEntity data) throws Exception {
		Assert.notNull(data, "新增对象[WzzUserEntity]不能为空");
		if (StringUtils.isEmpty(data.getId())) {
			data.setId(UUID.randomUUID().toString());
		}
		wzzUserEntityMapper.insert(data);
		return data;
	}

	@Override
	public WzzUserEntity updateWzzUser(WzzUserEntity data) throws Exception {
		Assert.notNull(data, "修改对象[WzzUserEntity]不能为空");
		wzzUserEntityMapper.updateByPrimaryKeySelective(data);
		return data;
	}

	@Override
	public WzzUserEntity deleteWzzUser(WzzUserEntity data) throws Exception {
		Assert.notNull(data, "删除对象[WzzUserEntity]不能为空");
		wzzUserEntityMapper.deleteByPrimaryKey(data.getId());
		return data;
	}

	@Override
	public Page<WzzWifiShopPicEntity> findWzzWifiShopPic(
			WzzWifiShopPicEntity condition, Order order, int pageIndex,
			int pageSize) throws Exception {
		Page<WzzWifiShopPicEntity> page = new Page<WzzWifiShopPicEntity>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		wzzWifiShopPicEntityMapper.selectByCondition(condition, order, page);
		return page;
	}

	@Override
	public WzzWifiShopPicEntity insertWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception {
		Assert.notNull(data, "新增对象[WzzWifiShopPicEntity]不能为空");
		Assert.notNull(data.getShopId(),
				"新增对象[WzzWifiShopPicEntity.shopId]不能为空");
		wzzWifiShopPicEntityMapper.insert(data);
		return data;
	}

	@Override
	public WzzWifiShopPicEntity deleteWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception {
		Assert.notNull(data, "删除对象[WzzWifiShopPicEntity]不能为空");
		Assert.notNull(data.getShopId(),
				"新增对象[WzzWifiShopPicEntity.shopId]不能为空");
		wzzWifiShopPicEntityMapper.deleteByShopId(data.getShopId());
		return data;
	}

	public WzzWifiShopPicEntityMapper getWzzWifiShopPicEntityMapper() {
		return wzzWifiShopPicEntityMapper;
	}

	public void setWzzWifiShopPicEntityMapper(
			WzzWifiShopPicEntityMapper wzzWifiShopPicEntityMapper) {
		this.wzzWifiShopPicEntityMapper = wzzWifiShopPicEntityMapper;
	}

	public String getWzz_ftp_url() {
		return wzz_ftp_url;
	}

	public void setWzz_ftp_url(String wzz_ftp_url) {
		this.wzz_ftp_url = wzz_ftp_url;
	}

	public String getWzz_ftp_userName() {
		return wzz_ftp_userName;
	}

	public void setWzz_ftp_userName(String wzz_ftp_userName) {
		this.wzz_ftp_userName = wzz_ftp_userName;
	}

	public String getWzz_ftp_password() {
		return wzz_ftp_password;
	}

	public void setWzz_ftp_password(String wzz_ftp_password) {
		this.wzz_ftp_password = wzz_ftp_password;
	}

	public String getWzz_ftp_tmpfile_path() {
		return wzz_ftp_tmpfile_path;
	}

	public void setWzz_ftp_tmpfile_path(String wzz_ftp_tmpfile_path) {
		this.wzz_ftp_tmpfile_path = wzz_ftp_tmpfile_path;
	}

}
