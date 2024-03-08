package com.vdc.ims.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.SttCtiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SttCtiController {

	@Resource(name="sttCtiService")
	private SttCtiService sttCtiService;

	/**
	 * 큐 요약
	*/
	@RequestMapping(value="/stt/cti/que/")
    public ModelAndView sttQue(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/que");
    	return mv;
    }
	
	/**
	 * 큐 응대호 프로파일
	*/
	@RequestMapping(value="/stt/cti/que/answer/") // /stt/cti/que/answer.do
    public ModelAndView sttQueAnswer(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/que_answer");
    	return mv;
    }
	
	/**
	 * 큐 포기호 프로파일
	*/
	@RequestMapping(value="/stt/cti/que/abandon/") // /stt/cti/que_abandon.do
    public ModelAndView sttQueAbandon(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/que_abandon");
    	return mv;
    }
	
	/**
	 * 큐 데이타
	*/
	@RequestMapping(value="/stt/cti/que/stat") // /stt/cti/getQueue.do
    public ModelAndView sttQueueStatsData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Queue = sttCtiService.getQueueStatsData(commandMap.getMap());
	    mv.addObject("Stt", Queue);
		return mv;
    }

	
	/**
	 * 상담원 요약
	*/
	@RequestMapping(value="/stt/cti/agent/")
    public ModelAndView sttAgent(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/agent");
    	return mv;
    }
	//상담원요약 통계 data
	@RequestMapping(value="/stt/cti/agent/list") // /stt/cti/getAgent.do
    public ModelAndView sttAgentData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Agent = sttCtiService.getAgentData(commandMap.getMap());
	    mv.addObject("Stt", Agent);
		return mv;
    }
	
	/**
	 * 상담원 행동 기록
	*/
	@RequestMapping(value="/stt/cti/agent/hist/") // /stt/cti/agent_hist.do
    public ModelAndView sttAgentHist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/agent_hist");
    	return mv;
    }
	@RequestMapping(value="/stt/cti/agent/hist/stat") // /stt/cti/getAgentHist.do
    public ModelAndView sttAgentHistData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Agent = sttCtiService.getAgentHistData(commandMap.getMap());
	    mv.addObject("Stt", Agent);
		return mv;
    }
	/**
	 * 상담원 실적
	*/
	@RequestMapping(value="/stt/cti/agent/result/") // /stt/cti/agent_result.do
    public ModelAndView sttAgentResult(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/agent_result");
    	return mv;
    }
	@RequestMapping(value="/stt/cti/agent/result/stat") // /stt/cti/getAgentResult.do
    public ModelAndView sttAgentResultData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Agent = sttCtiService.getAgentResultData(commandMap.getMap());
	    mv.addObject("Stt", Agent);
		return mv;
    }
	
	/**
	 * 상담원 콜 분석
	*/
	@RequestMapping(value="/stt/cti/agent/call/") // /stt/cti/agent_call.do
    public ModelAndView sttAgentCall(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/agent_call");
    	return mv;
    }
	@RequestMapping(value="/stt/cti/agent/call/stat") // /stt/cti/getAgentCall.do
    public ModelAndView sttAgentCallData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Agent = sttCtiService.getAgentCallData(commandMap.getMap());
	    mv.addObject("Stt", Agent);
		return mv;
    }
	
	/**
	 * 상담원 상태
	*/
	@RequestMapping(value="/stt/cti/agent/status/") // /stt/cti/agent_status.do
    public ModelAndView sttAgentStatus(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/agent_status");
    	return mv;
    }
	@RequestMapping(value="/stt/cti/agent/status/stat") // /stt/cti/getAgentStatus.do
    public ModelAndView sttAgentStatusData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Agent = sttCtiService.getAgentStatusData(commandMap.getMap());
	    mv.addObject("Stt", Agent);
		return mv;
    }
	
	/*
	 * 상담원 큐별 콜처리
	 * */
	@RequestMapping(value="/stt/cti/agent/que/") // /stt/cti/agent_que.do
    public ModelAndView sttAgentQue(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/cti/agent_que");
    	return mv;
    }
	@RequestMapping(value="/stt/cti/agent/que/stat") // /stt/cti/getAgentQue.do
    public ModelAndView sttAgentQueData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Agent = sttCtiService.sttAgentQueData(commandMap.getMap());
	    mv.addObject("Stt", Agent);
		return mv;
    }
}
