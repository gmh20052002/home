package com.gmh.wzz.core.dao;

import com.gmh.wzz.api.entity.WzzBusinessClassEntity;

public interface WzzBusinessClassEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(WzzBusinessClassEntity record);

    int insertSelective(WzzBusinessClassEntity record);

    WzzBusinessClassEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WzzBusinessClassEntity record);

    int updateByPrimaryKey(WzzBusinessClassEntity record);
}