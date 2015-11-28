package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzUserEntity;
import com.gmh.wzz.api.entity.WzzWifiShopDiscEntity;
import com.gmh.wzz.api.entity.WzzWifiShopJobEntity;

public interface WzzUserEntityMapper {
	int deleteByPrimaryKey(String id);

	int insert(WzzUserEntity record);

	int insertSelective(WzzUserEntity record);

	WzzUserEntity selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WzzUserEntity record);

	int updateByPrimaryKey(WzzUserEntity record);

	List<WzzUserEntity> selectByCondition(
			@Param("condition") WzzUserEntity condition,
			@Param("order") Order order, Page<WzzUserEntity> page);
}