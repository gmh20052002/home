package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzWifiShopPicEntity;

public interface WzzWifiShopPicEntityMapper {
    int deleteByShopId(String shopId);
    
    int insert(WzzWifiShopPicEntity record);

    int insertSelective(WzzWifiShopPicEntity record);

	List<WzzWifiShopPicEntity> selectByCondition(
			@Param("condition") WzzWifiShopPicEntity condition,
			@Param("order") Order order, Page<WzzWifiShopPicEntity> page);
}