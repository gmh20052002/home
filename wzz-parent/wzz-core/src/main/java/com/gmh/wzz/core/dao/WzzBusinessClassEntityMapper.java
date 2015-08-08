package com.gmh.wzz.core.dao;

import java.util.List;

import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;

public interface WzzBusinessClassEntityMapper {
	int deleteByPrimaryKey(String id);

	int insert(WzzBusinessClassEntity record);

	int insertSelective(WzzBusinessClassEntity record);

	WzzBusinessClassEntity selectByPrimaryKey(String id);

	List<WzzBusinessClassEntity> selectByCondition(
			WzzBusinessClassEntity condition, Page<WzzBusinessClassEntity> page);

	int updateByPrimaryKeySelective(WzzBusinessClassEntity record);

	int updateByPrimaryKey(WzzBusinessClassEntity record);
}