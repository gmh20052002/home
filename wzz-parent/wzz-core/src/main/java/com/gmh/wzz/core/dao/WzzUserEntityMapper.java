package com.gmh.wzz.core.dao;

import com.gmh.wzz.api.entity.WzzUserEntity;

public interface WzzUserEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(WzzUserEntity record);

    int insertSelective(WzzUserEntity record);

    WzzUserEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WzzUserEntity record);

    int updateByPrimaryKey(WzzUserEntity record);
}