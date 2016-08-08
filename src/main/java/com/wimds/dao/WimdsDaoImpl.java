package com.wimds.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.wimds.bean.BleBean;





@SuppressWarnings("deprecation")
public class WimdsDaoImpl extends SqlMapClientDaoSupport implements WimdsDao{

	@Override
	public List getBleMac_id_List() {
		return this.getSqlMapClientTemplate().queryForList("bleSql.getBleMac_id_List");
	}

	@Override
	public int getCountAndroid_id(String android_id) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("bleSql.getCountAndroid_id", android_id);
	}

	@Override
	public int insertDevice(BleBean bean) {
		this.getSqlMapClientTemplate().insert("bleSql.insertDevice", bean);
		return 1;
	}

	@Override
	public int checkDevice(String b_mac_id) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("bleSql.checkDevice", b_mac_id);
	}

	@Override
	public List getMyMac(String s_id) {
		return this.getSqlMapClientTemplate().queryForList("bleSql.getMyMac", s_id);
	}

	@Override
	public int deleteDevice(String b_mac_id) {
		this.getSqlMapClientTemplate().delete("bleSql.deleteDevice", b_mac_id);
		return 1;
	}

	@Override
	public int registerLostDevice(String android_id) {
		this.getSqlMapClientTemplate().update("bleSql.registerLostDevice", android_id);
		return 1;
	}

	@Override
	public void updateS_id(BleBean bleBean) {
		this.getSqlMapClientTemplate().update("bleSql.updateS_id", bleBean);
	}

	@Override
	public void updateWd_stat(BleBean bean) {
		this.getSqlMapClientTemplate().update("bleSql.updateWd_stat", bean);
	}

	@Override
	public int cancelLostDevice(String android_id) {
		this.getSqlMapClientTemplate().update("bleSql.cancelLostDevice", android_id);
		return 1;
	}

	@Override
	public List<BleBean> getLostDevice() {
		return this.getSqlMapClientTemplate().queryForList("bleSql.getLostDevice");
	}

	@Override
	public int modifyDevice(BleBean bean) {
		this.getSqlMapClientTemplate().update("bleSql.modifyDevice", bean);
		return 1;
	}

	@Override
	public int findLostDevice(BleBean bean) {
		this.getSqlMapClientTemplate().insert("bleSql.findLostDevice", bean);
		return 1;
	}

	@Override
	public BleBean getBleInfo(String b_mac_id) {
		return (BleBean) this.getSqlMapClientTemplate().queryForObject("bleSql.getBleInfo", b_mac_id);
	}

	@Override
	public int checkFindLostDevice(BleBean bleBean) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("bleSql.checkFindLostDevice", bleBean);
	}

	@Override
	public int updateFindLostDevice(BleBean bleBean) {
		this.getSqlMapClientTemplate().update("bleSql.updateFindLostDevice", bleBean);
		return 1;
	}

	@Override
	public List checkLostDevice(String b_mac_id) {
		return this.getSqlMapClientTemplate().queryForList("bleSql.checkLostDevice", b_mac_id);
	}

	@Override
	public BleBean getWdBleInfo(String b_mac_id) {
		return (BleBean) this.getSqlMapClientTemplate().queryForObject("bleSql.getWdBleInfo", b_mac_id);
	}

	@Override
	public BleBean getBleInfoForAndroid_id(String android_id) {
		return (BleBean) this.getSqlMapClientTemplate().queryForObject("bleSql.getBleInfoForAndroid_id", android_id);
	}

	@Override
	public void deleteFindLostDevice(String b_mac_id) {
		this.getSqlMapClientTemplate().delete("bleSql.deleteFindLostDevice", b_mac_id);
	}

	/*@Override
	public int getTotalCount() {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("companySql.getTotalCount");
	}

	@Override
	public List<CompanyViewBean> getCompanyList(int firstRow) {
		return this.getSqlMapClientTemplate().queryForList("companySql.getCompanyList", firstRow);
	}

	@Override
	public int insertCompany(String company_name) {
		this.getSqlMapClientTemplate().insert("companySql.insertCompany", company_name);
		return 1;
	}*/
}
