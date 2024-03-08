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
import com.vdc.ims.service.SttTotalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SttTotalController {

	@Resource(name="sttTotalService")
	private SttTotalService sttTotalService;

	/**
	 * 수신통계
	*/
	//수신통계 view
	@RequestMapping(value="/stt/total/incall/") // /stt/total/incall.do
    public ModelAndView sttInCall(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/total/incall");
    	return mv;
    }
	//수신통계 리스트
	@RequestMapping(value="/stt/total/incall/stats") // /stt/total/incallstats.do
    public ModelAndView getInCallStat(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttTotalService.getInCallStat(commandMap.getMap());
	    mv.addObject("Stt", Stt);
		return mv;
    }
	
	/**
	 * 수신 상세리스트
	*/
	//수신 상세리스트 view
	@RequestMapping(value="/stt/total/incall/list/") // /stt/total/incalllist.do
    public ModelAndView sttInCallList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/total/incall_list");
    	return mv;
    }
	//수신 상세리스트
	@RequestMapping(value="/stt/total/incall/dtl") // /stt/total/incalldtl.do
    public ModelAndView getInCallDtl(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttTotalService.getInCallDtl(commandMap.getMap());
		Map<String,Object> Cnt = sttTotalService.getInCallDtlCnt(commandMap.getMap());
		
        mv.addObject("draw", commandMap.get("draw"));
    	mv.addObject("recordsTotal", Cnt.get("TotRowCnt")); //전체 row수
    	mv.addObject("recordsFiltered", Cnt.get("TotRowCnt")); //검색후 rows수
	    mv.addObject("data", Stt);
		return mv;
    }
	
	/**
	 * 포기호통계
	*/ 
	//포기호통계 view
	@RequestMapping(value="/stt/total/abandon/") // /stt/total/abandon.do
    public ModelAndView sttAbandon(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/total/abandon");
    	return mv;
    }
	//포기호통계 
	@RequestMapping(value="/stt/total/abandon/stats") // /stt/total/abandonstats.do
    public ModelAndView getAbandonStat(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttTotalService.getAbandonStat(commandMap.getMap());
	    mv.addObject("Stt", Stt);
		return mv;
    }
	@RequestMapping(value="/stt/ub/excel/abandon_dtl")
	public void getAbandon_Dtl_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttTotalService.getAbandonStat(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("Start_Dt"));
		excelData.put("edate", commandMap.getMap().get("End_Dt"));

		ExcelView excel = new ExcelView();
		String filename = "포기호상세현황_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "abandon_dtl.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}
	
	/**
	 * 포기호 상세리스트
	*/
	//포기호 상세리스트 view
	@RequestMapping(value="/stt/total/abandon/list/") // /stt/total/abandonlist.do
    public ModelAndView sttAbandonList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/total/abandon_list");
    	return mv;
    }
	//포기호 상세리스트
	@RequestMapping(value="/stt/total/abandon/dtl") // /stt/total/abandondtl.do
    public ModelAndView getAbandonDtl(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttTotalService.getAbandonDtl(commandMap.getMap());
		Map<String,Object> Cnt = sttTotalService.getAbandonDtlCnt(commandMap.getMap());
		
        mv.addObject("draw", commandMap.get("draw"));
    	mv.addObject("recordsTotal", Cnt.get("TotRowCnt")); //전체 row수
    	mv.addObject("recordsFiltered", Cnt.get("TotRowCnt")); //검색후 rows수
	    mv.addObject("data", Stt);
		return mv;
    }
	@RequestMapping(value="/stt/ub/excel/abandon_list")
	public void getAbandon_List_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttTotalService.getAbandonDtlExcel(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("Start_Dt"));
		excelData.put("edate", commandMap.getMap().get("End_Dt"));

		ExcelView excel = new ExcelView();
		String filename = "포기호리스트_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "abandon_list.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}


	/**
	 * 발신통계
	*/
	//발신통계 view
	@RequestMapping(value="/stt/total/outcall/") // /stt/total/outcall.do
    public ModelAndView sttOutCall(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/total/outcall");
    	return mv;
    }
	//발신통계 
	@RequestMapping(value="/stt/total/outcall/stats") // /stt/total/outcallstats.do
    public ModelAndView getOutCallStat(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttTotalService.getOutCallStat(commandMap.getMap());
	    mv.addObject("Stt", Stt);
		return mv;
    }
	
	/**
	 * 발신 상세리스트
	*/
	//발신 상세리스트 view
	@RequestMapping(value="/stt/total/outcall/list/") // /stt/total/outcalllist.do
    public ModelAndView sttOutCallList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/total/outcall_list");
    	return mv;
    }
	//발신 상세리스트
	@RequestMapping(value="/stt/total/outcall/dtl") // /stt/total/outcalldtl.do
    public ModelAndView getOutCallDtl(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttTotalService.getOutCallDtl(commandMap.getMap());
		Map<String,Object> Cnt = sttTotalService.getOutCallDtlCnt(commandMap.getMap());
		
        mv.addObject("draw", commandMap.get("draw"));
    	mv.addObject("recordsTotal", Cnt.get("TotRowCnt")); //전체 row수
    	mv.addObject("recordsFiltered", Cnt.get("TotRowCnt")); //검색후 rows수
	    mv.addObject("data", Stt);
		return mv;
    }
	
	
}
