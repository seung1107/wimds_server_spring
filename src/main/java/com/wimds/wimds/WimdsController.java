package com.wimds.wimds;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;










import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.wimds.bean.BleBean;
import com.wimds.bean.ResultBean;
import com.wimds.service.WimdsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WimdsController {
	
	private static final Logger logger = LoggerFactory.getLogger(WimdsController.class);
	
	@Autowired
	private WimdsService wimdsService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/checkAndroid_id/{android_id}/{s_id}", method = RequestMethod.GET)
	public ModelAndView checkAndroid_id(BleBean bleBean) {
		ModelAndView mav = new ModelAndView();
		List result = new ArrayList();
		
		mav.setViewName("pageJsonReport");
		
		int countAndroid_id = wimdsService.getCountAndroid_id(bleBean.getAndroid_id());
		ResultBean rb = new ResultBean(); 
		if(countAndroid_id == 0){
			rb.setResult(false);
		}else{
			wimdsService.updateS_id(bleBean);
			rb.setResult(true);
		}
		result.add(rb);
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value = "/getMac_id_list", method = RequestMethod.GET)
	public ModelAndView getMac_id_list() {
		ModelAndView mav = new ModelAndView();
		
		List<BleBean> mac_id_list = wimdsService.getBleMac_id_List();
		
		mav.setViewName("pageJsonReport");
		
		mav.addObject("result", mac_id_list);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/getLostDevice/{android_id}", method = RequestMethod.GET)
	public ModelAndView getLostDevice(@PathVariable("android_id") String android_id) {
		ModelAndView mav = new ModelAndView();
		
		List<BleBean> lostDevice = wimdsService.getLostDevice();
		List<BleBean> result = lostDevice;
		for (int i = 0; i < lostDevice.size(); i++) {
			if(lostDevice.get(i).getAndroid_id().equals(android_id)) result.remove(i);
		}
		
		
		mav.setViewName("pageJsonReport");
		
		mav.addObject("result", result);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/getLostDeviceInfo/{b_mac_id}", method = RequestMethod.GET)
	public ModelAndView getLostDeviceInfo(@PathVariable ("b_mac_id") String b_mac_id) {
		ModelAndView mav = new ModelAndView();
		
		BleBean bean = getBleInfo(b_mac_id);
		List result = new ArrayList();
		result.add(bean);
		mav.setViewName("pageJsonReport");
		
		mav.addObject("result", result);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/insertDevice/{android_id}/{s_id}/{b_name}/{s_number}/{b_mac_id}/{c_name}/{c_gender}/{c_etc}", method = RequestMethod.GET)
	public ModelAndView insertDevice(BleBean bleBean) {
		ModelAndView mav = new ModelAndView();
		List result = new ArrayList();
		
		mav.setViewName("pageJsonReport");
		
		
		int check_ble = wimdsService.checkDevice(bleBean.getB_mac_id());
		if(check_ble == 1){
			int count = wimdsService.insertDevice(bleBean);
			ResultBean rb = new ResultBean(); 
			if(count == 1){
				bleBean.setB_stat("1");
				wimdsService.updateWd_stat(bleBean);
				rb.setResult(true);
			}else{
				rb.setResult(false);
			}
			result.add(rb);
			mav.addObject("result", result);
		}
		
	
		return mav;
	}
	
	@RequestMapping(value = "/getMyMac/{android_id}", method = RequestMethod.GET)
	public ModelAndView getMyMac(@PathVariable ("android_id") String android_id) {
		ModelAndView mav = new ModelAndView();
		
		List mac_id_list = wimdsService.getMyMac(android_id);
		
		mav.setViewName("pageJsonReport");
		
		mav.addObject("result", mac_id_list);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/deleteDevice/{b_mac_id}", method = RequestMethod.GET)
	public ModelAndView deleteDevice(@PathVariable ("b_mac_id") String b_mac_id) {
		ModelAndView mav = new ModelAndView();
		List result = new ArrayList();
		ResultBean rb = new ResultBean();
		int delete_result = wimdsService.deleteDevice(b_mac_id);
		BleBean bleBean = new BleBean();
		if(delete_result == 1){
			bleBean.setB_mac_id(b_mac_id);
			bleBean.setB_stat("0");
			wimdsService.updateWd_stat(bleBean);
			rb.setResult(true);
		}else{
			rb.setResult(false);
		}
		result.add(rb);
		mav.setViewName("pageJsonReport");
		
		mav.addObject("result", result);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/registerLostDevice/{android_id}", method = RequestMethod.GET)
	public ModelAndView registerLostDevice(@PathVariable ("android_id") String android_id) {
		ModelAndView mav = new ModelAndView();
		int registerLost_result = wimdsService.registerLostDevice(android_id);
		List result = new ArrayList();
		ResultBean rb = new ResultBean();
		if(registerLost_result != 1){
			rb.setResult(false);
		}else{
			rb.setResult(true);
		}	
		result.add(rb);
		mav.setViewName("pageJsonReport");	
		mav.addObject("result", result);	
		return mav;
	}
	
	@RequestMapping(value = "/cancelLostDevice/{android_id}", method = RequestMethod.GET)
	public ModelAndView cancelLostDevice(@PathVariable ("android_id") String android_id) {
		ModelAndView mav = new ModelAndView();
		int cancelLost_result = wimdsService.cancelLostDevice(android_id);
		List result = new ArrayList();
		ResultBean rb = new ResultBean();
		if(cancelLost_result != 1){
			rb.setResult(false);
		}else{
			BleBean bean = wimdsService.getBleInfoForAndroid_id(android_id);
			wimdsService.deleteFindLostDevice(bean.getB_mac_id());
			rb.setResult(true);
		}	
		result.add(rb);
		mav.setViewName("pageJsonReport");	
		mav.addObject("result", result);	
		return mav;
	}
	
	@RequestMapping(value = "/modifyDevice/{android_id}/{b_name}/{c_name}/{c_gender}/{c_etc}", method = RequestMethod.GET)
	public ModelAndView modifyDevice(BleBean bleBean) {
		ModelAndView mav = new ModelAndView();
		int registerLost_result = wimdsService.modifyDevice(bleBean);
		List result = new ArrayList();
		ResultBean rb = new ResultBean();
		if(registerLost_result != 1){
			rb.setResult(false);
		}else{
			rb.setResult(true);
		}	
		result.add(rb);
		mav.setViewName("pageJsonReport");	
		mav.addObject("result", result);	
		return mav;
	}
	
	@RequestMapping(value = "/findLostDevice/{android_id}/{b_mac_id}/{b_lat}/{b_lng}", method = RequestMethod.GET)
	public ModelAndView findLostDevice(BleBean bleBean) {
		List result = new ArrayList();
		ResultBean rb = new ResultBean();
		ModelAndView mav = new ModelAndView();
		int check_findLostDevice = wimdsService.checkFindLostDevice(bleBean);
		if(check_findLostDevice == 1){
			int updateFindLostDevice = wimdsService.updateFindLostDevice(bleBean);
			if(updateFindLostDevice != 1){
				rb.setResult(false);
			}else{
				rb.setResult(true);
			}
		}else{
			int findLostDevice_result = wimdsService.findLostDevice(bleBean);
			
			if(findLostDevice_result != 1){
				rb.setResult(false);
			}else{
				BleBean beanInfo = getBleInfo(bleBean.getB_mac_id());
				try {
					pushService(beanInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				rb.setResult(true);
			}	
			
		}
		result.add(rb);
		mav.setViewName("pageJsonReport");	
		mav.addObject("result", result);	
		return mav;
	}
	
	@RequestMapping(value = "/checkLostDevice/{b_mac_id}", method = RequestMethod.GET)
	public ModelAndView checkLostDevice(@PathVariable ("b_mac_id") String b_mac_id) {
		ModelAndView mav = new ModelAndView();
		
		List lostDevice = wimdsService.checkLostDevice(b_mac_id);
		mav.setViewName("pageJsonReport");
		
		mav.addObject("result", lostDevice);
		
		
		return mav;
	}
	
	public BleBean getWdBleInfo(String b_mac_id){
		BleBean bleBean = wimdsService.getWdBleInfo(b_mac_id);
		return bleBean;
	}
	
	public BleBean getBleInfo(String b_mac_id){
		BleBean bleBean = wimdsService.getBleInfo(b_mac_id);
		return bleBean;
	}
	
	public void pushService(final BleBean bean) throws Exception{
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sender sender = new Sender("AIzaSyCxij_oGf79yC0119Ip4vFqYSEWGnBReNc");
				Message message = new Message.Builder().addData("title", "Wimds -  미아를 발견했습니다.").addData("message", "미아를 발견했습니다. 확인해보세요.").build();
				
				try {
					String regId = bean.getS_id();
					Result result = sender.send(message, regId, 5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
}
