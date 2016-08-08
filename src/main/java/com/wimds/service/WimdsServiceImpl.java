package com.wimds.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wimds.bean.BleBean;
import com.wimds.dao.WimdsDao;




@Service
public class WimdsServiceImpl implements WimdsService{
	@Autowired
	private WimdsDao wimdsDao;

	@Override
	public List getBleMac_id_List() {
		return wimdsDao.getBleMac_id_List();
	}

	@Override
	public int getCountAndroid_id(String android_id) {
		return wimdsDao.getCountAndroid_id(android_id);
	}

	@Override
	public int insertDevice(BleBean bean) {
		return wimdsDao.insertDevice(bean);
	}

	@Override
	public int checkDevice(String b_mac_id) {
		return wimdsDao.checkDevice(b_mac_id);
	}

	@Override
	public List getMyMac(String s_id) {
		return wimdsDao.getMyMac(s_id);
	}

	@Override
	public int deleteDevice(String b_mac_id) {
		return wimdsDao.deleteDevice(b_mac_id);
	}

	@Override
	public int registerLostDevice(String android_id) {
		return wimdsDao.registerLostDevice(android_id);
	}

	@Override
	public void updateS_id(BleBean bleBean) {
		wimdsDao.updateS_id(bleBean);
	}

	@Override
	public void updateWd_stat(BleBean bean) {
		wimdsDao.updateWd_stat(bean);
	}

	@Override
	public int cancelLostDevice(String android_id) {
		return wimdsDao.cancelLostDevice(android_id);
	}

	@Override
	public List<BleBean> getLostDevice() {
		return wimdsDao.getLostDevice();
	}

	@Override
	public int modifyDevice(BleBean bean) {
		return wimdsDao.modifyDevice(bean);
	}

	@Override
	public int findLostDevice(BleBean bean) {
		return wimdsDao.findLostDevice(bean);
	}

	@Override
	public BleBean getBleInfo(String b_mac_id) {
		return wimdsDao.getBleInfo(b_mac_id);
	}

	@Override
	public int checkFindLostDevice(BleBean bleBean) {
		return wimdsDao.checkFindLostDevice(bleBean);
	}

	@Override
	public int updateFindLostDevice(BleBean bleBean) {
		return wimdsDao.updateFindLostDevice(bleBean);
	}

	@Override
	public List checkLostDevice(String b_mac_id) {
		return wimdsDao.checkLostDevice(b_mac_id);
	}

	@Override
	public BleBean getWdBleInfo(String b_mac_id) {
		return wimdsDao.getWdBleInfo(b_mac_id);
	}

	@Override
	public BleBean getBleInfoForAndroid_id(String android_id) {
		return wimdsDao.getBleInfoForAndroid_id(android_id);
	}

	@Override
	public void deleteFindLostDevice(String b_mac_id) {
		wimdsDao.deleteFindLostDevice(b_mac_id);
	}


}
