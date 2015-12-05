package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzUserFBEntity;

public interface WzzUserFBEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(WzzUserFBEntity record);

    int insertSelective(WzzUserFBEntity record);

    WzzUserFBEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WzzUserFBEntity record);

    int updateByPrimaryKey(WzzUserFBEntity record);

	List<WzzUserFBEntity> selectByCondition(
			@Param("condition") WzzUserFBEntity condition,
			@Param("order") Order order, Page<WzzUserFBEntity> page);
}