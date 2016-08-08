package com.wimds.dao;

import java.util.List;

import com.wimds.bean.BleBean;


public interface WimdsDao {
	List getBleMac_id_List();
	List<BleBean> getLostDevice();
	int getCountAndroid_id(String android_id);
	int insertDevice(BleBean bean);
	int checkDevice(String b_mac_id);
	List getMyMac(String s_id);
	int deleteDevice(String b_mac_id);
	int registerLostDevice(String android_id);
	int cancelLostDevice(String android_id);
	void updateS_id(BleBean bleBean);
	void updateWd_stat(BleBean bean);
	int modifyDevice(BleBean bean);
	int findLostDevice(BleBean bean);
	BleBean getWdBleInfo(String b_mac_id);
	BleBean getBleInfo(String b_mac_id);
	BleBean getBleInfoForAndroid_id(String android_id);
	int checkFindLostDevice(BleBean bleBean);
	int updateFindLostDevice(BleBean bleBean);
	List checkLostDevice(String b_mac_id);
	void deleteFindLostDevice(String b_mac_id);
}
