package com.gmh.wzz.core.dao;

import com.gmh.wzz.api.entity.WzzWifiShopEntity;

public interface WzzWifiShopEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(WzzWifiShopEntity record);

    int insertSelective(WzzWifiShopEntity record);

    WzzWifiShopEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WzzWifiShopEntity record);

    int updateByPrimaryKey(WzzWifiShopEntity record);
}