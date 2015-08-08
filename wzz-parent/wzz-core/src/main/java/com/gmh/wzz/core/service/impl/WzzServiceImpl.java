package com.gmh.wzz.core.service.impl;

import java.util.List;

import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.service.WzzService;
import com.gmh.wzz.core.dao.WzzBusinessClassEntityMapper;

public class WzzServiceImpl implements WzzService {
	private WzzBusinessClassEntityMapper wzzBusinessClassEntityMapper;

	@Override
	public Page<WzzBusinessClassEntity> findWzzBusinessClass(
			WzzBusinessClassEntity condition, int pageIndex, int pageSize)
			throws Exception {
		Page<WzzBusinessClassEntity> page = new Page<WzzBusinessClassEntity>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		List<WzzBusinessClassEntity>  datas = wzzBusinessClassEntityMapper.selectByCondition(condition, page);
		return null;
	}

	public WzzBusinessClassEntityMapper getWzzBusinessClassEntityMapper() {
		return wzzBusinessClassEntityMapper;
	}

	public void setWzzBusinessClassEntityMapper(
			WzzBusinessClassEntityMapper wzzBusinessClassEntityMapper) {
		this.wzzBusinessClassEntityMapper = wzzBusinessClassEntityMapper;
	}

}
