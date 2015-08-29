package com.gmh.wzz.api.service;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.entity.WzzUserEntity;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.entity.WzzWifiShopPicEntity;

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

	/*
	 * ==========================================================================
	 */
	public Page<WzzWifiShopEntity> findWzzWifiShop(WzzWifiShopEntity condition,
			Order order, int pageIndex, int pageSize) throws Exception;

	public WzzWifiShopEntity getWzzWifiShopById(String id) throws Exception;

	public WzzWifiShopEntity insertWzzWifiShop(WzzWifiShopEntity data)
			throws Exception;

	public WzzWifiShopEntity updateWzzWifiShop(WzzWifiShopEntity data)
			throws Exception;

	public WzzWifiShopEntity deleteWzzWifiShop(WzzWifiShopEntity data)
			throws Exception;

	/*
	 * ==========================================================================
	 */

	public Page<WzzUserEntity> findWzzUser(WzzUserEntity condition,
			Order order, int pageIndex, int pageSize) throws Exception;

	public WzzUserEntity getWzzUserById(String id) throws Exception;

	public WzzUserEntity insertWzzUser(WzzUserEntity data) throws Exception;

	public WzzUserEntity updateWzzUser(WzzUserEntity data) throws Exception;

	public WzzUserEntity deleteWzzUser(WzzUserEntity data) throws Exception;

	/*
	 * ==========================================================================
	 */

	public Page<WzzWifiShopPicEntity> findWzzWifiShopPic(
			WzzWifiShopPicEntity condition) throws Exception;

	public WzzWifiShopPicEntity insertWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception;

	public WzzWifiShopPicEntity updateWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception;

	public WzzWifiShopPicEntity deleteWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception;
}
