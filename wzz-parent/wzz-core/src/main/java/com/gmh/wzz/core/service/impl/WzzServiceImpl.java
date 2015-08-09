package com.gmh.wzz.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.service.WzzService;
import com.gmh.wzz.core.dao.WzzBusinessClassEntityMapper;

public class WzzServiceImpl implements WzzService {
	@Autowired
	private WzzBusinessClassEntityMapper wzzBusinessClassEntityMapper;

	@Override
	public Page<WzzBusinessClassEntity> findWzzBusinessClass(
			WzzBusinessClassEntity condition, int pageIndex, int pageSize)
			throws Exception {
		Page<WzzBusinessClassEntity> page = new Page<WzzBusinessClassEntity>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		wzzBusinessClassEntityMapper.selectByCondition(page, condition);
		return page;
	}

	public WzzBusinessClassEntityMapper getWzzBusinessClassEntityMapper() {
		return wzzBusinessClassEntityMapper;
	}

	public void setWzzBusinessClassEntityMapper(
			WzzBusinessClassEntityMapper wzzBusinessClassEntityMapper) {
		this.wzzBusinessClassEntityMapper = wzzBusinessClassEntityMapper;
	}

}
