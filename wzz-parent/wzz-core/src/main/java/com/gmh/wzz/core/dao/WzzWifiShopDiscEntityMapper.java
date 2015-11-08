package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzWifiShopDiscEntity;

public interface WzzWifiShopDiscEntityMapper {
    int deleteByShopId(String shopId);
    
    int insert(WzzWifiShopDiscEntity record);

    int insertSelective(WzzWifiShopDiscEntity record);

    WzzWifiShopDiscEntity selectByPrimaryKey(String id);

	List<WzzWifiShopDiscEntity> selectByCondition(
			@Param("condition") WzzWifiShopDiscEntity condition,
			@Param("order") Order order, Page<WzzWifiShopDiscEntity> page);
}