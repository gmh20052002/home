package com.gmh.wzz.api.service;

import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;

public interface WzzService {
	public Page<WzzBusinessClassEntity> findWzzBusinessClass(
			WzzBusinessClassEntity condition, int pageIndex, int pageSize) throws Exception;
}
