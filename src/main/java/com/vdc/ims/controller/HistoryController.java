package com.vdc.ims.controller;


import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
public class HistoryController {

	@Resource(name="historyService")
	private HistoryService historyService;

	
	/**
	 * 이력 관리
	*/
	@RequestMapping(value="/hist/")
    public ModelAndView Hist() throws Exception{
    	ModelAndView mv = new ModelAndView("view/cmm/etc/hist");
    	return mv;
    }
	

	//이력관리 목록
	@RequestMapping(value="/hist/list")
    public ModelAndView getHist(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");

    	List<Map<String,Object>> TotCount = historyService.getHistTotCnt(commandMap.getMap());
    	List<Map<String,Object>> SrchCount = historyService.getHistSrchCnt(commandMap.getMap());
    	List<Map<String,Object>> data = historyService.getHistData(commandMap.getMap());
    	
    	
        mv.addObject("draw", commandMap.get("draw"));
    	mv.addObject("recordsTotal", TotCount.get(0).get("TotRowCnt")); //전체 row수
    	mv.addObject("recordsFiltered", SrchCount.get(0).get("SearchRowCnt")); //검색후 rows수
    	mv.addObject("data", data);

    	return mv;
    }

}
