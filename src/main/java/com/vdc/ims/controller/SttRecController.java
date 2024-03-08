package com.vdc.ims.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.SttRecService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SttRecController {

	@Resource(name="sttRecService")
	private SttRecService sttRecService;

	/**
	 * 녹취 통계
	*/
	@RequestMapping(value="/stt/rec/") // /stt/rec/rec.do
    public ModelAndView sttRec(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/rec/rec");
    	return mv;
    }

	@RequestMapping(value="/stt/rec/list") // /stt/rec/sttrec.do
    public ModelAndView getSttRec(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttRecService.getSttRec(commandMap.getMap(), session);
	    mv.addObject("Stt", Stt);
		return mv;
	}
	//서비
}
