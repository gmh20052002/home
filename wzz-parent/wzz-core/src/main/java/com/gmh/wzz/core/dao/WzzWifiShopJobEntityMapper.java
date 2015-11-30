package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzWifiShopJobEntity;

public interface WzzWifiShopJobEntityMapper {
    int insert(WzzWifiShopJobEntity record);

    int insertSelective(WzzWifiShopJobEntity record);
    
    int deleteByShopId(String shopId);
	
    int deleteByPrimaryKey(String id);

    WzzWifiShopJobEntity selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WzzWifiShopJobEntity record);

	int updateByPrimaryKey(WzzWifiShopJobEntity record);

	List<WzzWifiShopJobEntity> selectByCondition(
			@Param("condition") WzzWifiShopJobEntity condition,
			@Param("order") Order order, Page<WzzWifiShopJobEntity> page);
	

	public List<WzzWifiShopJobEntity> findJobsByUserId(String userId);
	
	public List<WzzWifiShopJobEntity> findJobsByUserName(String userName);
}