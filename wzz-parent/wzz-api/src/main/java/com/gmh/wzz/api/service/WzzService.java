package com.gmh.wzz.api.service;

import java.util.List;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.entity.WzzUserDiscEntity;
import com.gmh.wzz.api.entity.WzzUserEntity;
import com.gmh.wzz.api.entity.WzzWifiShopDiscEntity;
import com.gmh.wzz.api.entity.WzzWifiShopEntity;
import com.gmh.wzz.api.entity.WzzWifiShopJobEntity;
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
			WzzWifiShopPicEntity condition, Order order, int pageIndex,
			int pageSize) throws Exception;

	public WzzWifiShopPicEntity insertWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception;

	public WzzWifiShopPicEntity deleteWzzWifiShopPic(WzzWifiShopPicEntity data)
			throws Exception;

	/*
	 * ==========================================================================
	 */

	public Page<WzzWifiShopDiscEntity> findWzzWifiShopDisc(
			WzzWifiShopDiscEntity condition, Order order, int pageIndex,
			int pageSize) throws Exception;

	public WzzWifiShopDiscEntity insertWzzWifiShopDisc(
			WzzWifiShopDiscEntity data) throws Exception;

	public WzzWifiShopDiscEntity updateWzzWifiShopDisc(
			WzzWifiShopDiscEntity data) throws Exception;

	public WzzWifiShopDiscEntity deleteWzzWifiShopDiscByShopId(
			WzzWifiShopDiscEntity data) throws Exception;

	public WzzWifiShopDiscEntity deleteWzzWifiShopDiscById(
			WzzWifiShopDiscEntity data) throws Exception;

	public WzzWifiShopDiscEntity getWzzWifiShopDiscById(String id)
			throws Exception;

	public Page<WzzWifiShopJobEntity> findWzzWifiShopJob(
			WzzWifiShopJobEntity condition, Order order, int pageIndex,
			int pageSize) throws Exception;

	public WzzWifiShopJobEntity insertWzzWifiShopJob(WzzWifiShopJobEntity data)
			throws Exception;

	public WzzWifiShopJobEntity updateWzzWifiShopJob(WzzWifiShopJobEntity data)
			throws Exception;

	public WzzWifiShopJobEntity deleteWzzWifiShopJobByShopId(WzzWifiShopJobEntity data)
			throws Exception;

	public WzzWifiShopJobEntity deleteWzzWifiShopJobById(WzzWifiShopJobEntity data)
			throws Exception;
	
	public WzzWifiShopJobEntity getWzzWifiShopJobById(String id)
			throws Exception;


	/*
	 * ==========================================================================
	 * ===
	 */
	public void sendMsg(String msgContent, String mobile) throws Exception;
	
	

	/*
	 * ====================================v2======================================
	 * ===
	 */
	
	public List<WzzWifiShopDiscEntity> findDiscsByUserId(String userId);
	
	public boolean insertDiscOfUser(WzzUserDiscEntity record) throws Exception ;
	
	public boolean deleteDiscOfUser(WzzUserDiscEntity record) throws Exception ;
	
	public List<WzzWifiShopDiscEntity> findDiscssByUserName(String userName);
	
	
	public String getWzz_ftp_url();

	public String getWzz_ftp_userName();

	public String getWzz_ftp_password();

	public String getWzz_ftp_tmpfile_path();

	public Float getWzz_wifi_search_scope();

	public String getSMSServerHost();

	public String getSMSServerPort();

	public String getSMSServerUserName();

	public String getSMSServerPassword();

	public String getSMSServerAppId();

	public String getSMSServerTempleteId();

	public String getSMSServerTimeout();
}
