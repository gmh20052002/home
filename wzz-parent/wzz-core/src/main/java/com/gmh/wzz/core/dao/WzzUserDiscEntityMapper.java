package com.gmh.wzz.core.dao;

import com.gmh.wzz.api.entity.WzzUserDiscEntity;

public interface WzzUserDiscEntityMapper {
    int insert(WzzUserDiscEntity record);
    
    int delete(WzzUserDiscEntity record);

    int insertSelective(WzzUserDiscEntity record);
}