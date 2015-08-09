package com.gmh.wzz.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;

public interface WzzBusinessClassEntityMapper {
	int deleteByPrimaryKey(String id);

	int insert(WzzBusinessClassEntity record);

	int insertSelective(WzzBusinessClassEntity record);

	WzzBusinessClassEntity selectByPrimaryKey(String id);

	List<WzzBusinessClassEntity> selectByCondition(
			Page<WzzBusinessClassEntity> page, @Param("condition")WzzBusinessClassEntity condition);

	int updateByPrimaryKeySelective(WzzBusinessClassEntity record);

	int updateByPrimaryKey(WzzBusinessClassEntity record);
}