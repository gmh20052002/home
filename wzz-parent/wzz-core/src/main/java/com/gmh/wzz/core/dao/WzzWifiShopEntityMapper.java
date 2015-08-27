package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;

public interface WzzWifiShopEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(WzzWifiShopEntity record);

    int insertSelective(WzzWifiShopEntity record);

    WzzWifiShopEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WzzWifiShopEntity record);

    int updateByPrimaryKey(WzzWifiShopEntity record);

	List<WzzWifiShopEntity> selectByCondition(
			@Param("condition") WzzWifiShopEntity condition,
			@Param("order") Order order, Page<WzzWifiShopEntity> page);
}