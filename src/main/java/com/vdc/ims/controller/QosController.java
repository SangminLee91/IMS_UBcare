package com.vdc.ims.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.QosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controller
 * @author Mir
 *
 */
@Controller
public class QosController {

	@Resource(name="qosService")
	private QosService qosService;
	
	/**
	 *통합 대시보드
	*/
	@RequestMapping(value="/qos/QOSSubscriber.do")
    public ModelAndView QOSSubscriber(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("/qos/qos_phone");
    	return mv;
    }	
	
	/**
	 * 전화번호 리스트
	*/
	@RequestMapping(value="/qos/subscribers.do")
    public ModelAndView getSubscribers(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");//new ModelAndView("/qos/subscribers");
    	List<Map<String,Object>> ags = qosService.getSubscribers(commandMap.getMap());
        mv.addObject("Subscribers", ags);
    	return mv; 
    }	
	/**
	 * 통화품질검색
	*/
	@RequestMapping(value="/qos/subscribersQOS.do")
    public ModelAndView getSubscribersQOS(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");//new ModelAndView("/qos/subscribersQOS");
    	List<Map<String,Object>> ags = qosService.getSubscribersQOS(commandMap.getMap());
        mv.addObject("SubscribersQOS", ags);
    	return mv;
    }
}
