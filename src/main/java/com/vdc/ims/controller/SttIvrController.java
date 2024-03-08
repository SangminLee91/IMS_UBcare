package com.vdc.ims.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.common.util.DateUtil;
import com.vdc.ims.common.util.ExcelView;
import com.vdc.ims.service.SttIvrService;
import com.vdc.ims.service.SttUBTotalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller
 * @author Mir
 *
 */
@Controller
public class SttIvrController {

	@Resource(name="sttIvrService")
	private SttIvrService sttIvrService;

	@Resource(name="sttUBTotalService")
	private SttUBTotalService sttUBTotalService;




	/**
	 * 수신통계
	*/
	@RequestMapping(value="/stt/ivr/incall/")
    public ModelAndView sttInCall(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/ivr/incall");
    	return mv;
    }
	
	
	/**
	 * 서비스별 통계
	*/
	@RequestMapping(value="/stt/ivr/service/")
    public ModelAndView sttService(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/ivr/service");
    	return mv;
    }
	
	@RequestMapping(value="/stt/ivr/service/stat") // /stt/ivr/getServiceStat.do
	public ModelAndView getServiceStat(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = sttIvrService.getServiceStat(commandMap.getMap());
        mv.addObject("SrvStat", calls);
    	return mv; 
    }
	
	
	/**
	 * 메뉴별 통계
	*/
	@RequestMapping(value="/stt/ivr/menu/")
    public ModelAndView sttMenu(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/ivr/menu");
    	return mv;
    }
	
	@RequestMapping(value="/stt/ivr/menu/stat") // /stt/ivr/getMenuStat.do
	public ModelAndView getMenuStat(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = sttIvrService.getMenuStat(commandMap.getMap());
        mv.addObject("MenuStat", calls);
    	return mv; 
    }
	
	//메뉴별 통계 -> DNIS별 서비스 통계
	@RequestMapping(value="/stt/ivr/menu/dnis") // /stt/ivr/getServiceStatbyDNIS.do
	public ModelAndView getServiceStatbyDNIS(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = sttIvrService.getServiceStatbyDNIS(commandMap.getMap());
        mv.addObject("SvcDNISStat", calls);
    	return mv; 
    }
	
	/**
	 * 콜백 통계
	*/
	@RequestMapping(value="/stt/ivr/callback/")
    public ModelAndView sttCallback(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/ivr/callback");
    	return mv;
    }
	
	@RequestMapping(value="/stt/ivr/callback/stat") // /stt/ivr/getCallbackStat.do
    public ModelAndView getCallbackStat(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = sttIvrService.getCallbackStat(commandMap.getMap());
        mv.addObject("CBStat", calls);
    	return mv; 
    }
	
	
	/**
	 * 콜백 처리 리스트
	*/
	@RequestMapping(value="/stt/ivr/callback/list/") // /stt/ivr/callback_list.do
    public ModelAndView sttCallbackList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/ivr/callback_list");
    	return mv;
    }
	
	@RequestMapping(value="/stt/ivr/callback/list/list") // /stt/ivr/getCallbackList.do
	public ModelAndView getCallbackList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = sttIvrService.getCallbackList(commandMap.getMap());
        mv.addObject("CBList", calls);
    	return mv; 
    }
	@RequestMapping(value="/stt/ub/excel/callback_list")
	public void sttUB_CallBackList_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttIvrService.getCallbackList(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("Start_Dt"));
		excelData.put("edate", commandMap.getMap().get("End_Dt"));

		ExcelView excel = new ExcelView();
		String filename = "콜백리스트_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "callback_list.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}

	@RequestMapping(value="/stt/ivr/callback/list/type")
	public ModelAndView getCallbackType(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> types = sttIvrService.getCallbackType(commandMap.getMap());
		mv.addObject("CB_Types", types);
		return mv;
	}
	
}
