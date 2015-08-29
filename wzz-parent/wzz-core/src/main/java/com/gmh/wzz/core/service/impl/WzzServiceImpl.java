package com.gmh.wzz.core.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.entity.WzzUserEntity;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.entity.WzzWifiShopPicEntity;
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
		if(data.getId() == null){
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzUserEntity getWzzUserById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzUserEntity insertWzzUser(WzzUserEntity data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzUserEntity updateWzzUser(WzzUserEntity data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzUserEntity deleteWzzUser(WzzUserEntity data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<WzzWifiShopPicEntity> findWzzWifiShopPic(
			WzzWifiShopPicEntity condition, Order order, int pageIndex,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzWifiShopPicEntity gettWzzWifiShopById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzWifiShopPicEntity insertWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzWifiShopPicEntity updateWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WzzWifiShopPicEntity deleteWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
