package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzSPWifiEntity;

public interface WzzSPWifiEntityMapper {
    int insert(WzzSPWifiEntity record);
    
    int delete(WzzSPWifiEntity record);

    int insertSelective(WzzSPWifiEntity record);

	List<WzzSPWifiEntity> selectByCondition(
			@Param("condition") WzzSPWifiEntity condition,
			@Param("order") Order order, Page<WzzSPWifiEntity> page);
}