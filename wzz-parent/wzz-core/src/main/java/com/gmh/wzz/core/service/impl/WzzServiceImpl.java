package com.gmh.wzz.core.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.service.WzzService;
import com.gmh.wzz.core.dao.WzzBusinessClassEntityMapper;
import com.gmh.wzz.core.dao.WzzWifiShopEntityMapper;
@Service
public class WzzServiceImpl implements WzzService {
	@Autowired
	private WzzBusinessClassEntityMapper wzzBusinessClassEntityMapper;
	@Autowired
	private WzzWifiShopEntityMapper wzzWifiShopEntityMapper;

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

	@Override
	public Page<WzzBusinessClassEntity> findWzzBusinessClass(
			WzzBusinessClassEntity condition, Order order, int pageIndex, int pageSize)
			throws Exception {
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
		if(data.getId() == null){
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

}
