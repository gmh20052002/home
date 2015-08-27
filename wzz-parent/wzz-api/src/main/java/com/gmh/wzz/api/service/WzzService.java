package com.gmh.wzz.api.service;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;

public interface WzzService {
	public Page<WzzBusinessClassEntity> findWzzBusinessClass(
			WzzBusinessClassEntity condition, Order order, int pageIndex,
			int pageSize) throws Exception;

	public WzzBusinessClassEntity getWzzBusinessClassById(String id)
			throws Exception;

	public WzzBusinessClassEntity insertWzzBusinessClass(
			WzzBusinessClassEntity data) throws Exception;

	public WzzBusinessClassEntity updateWzzBusinessClass(
			WzzBusinessClassEntity data) throws Exception;

	public WzzBusinessClassEntity deleteWzzBusinessClass(
			WzzBusinessClassEntity data) throws Exception;
}
