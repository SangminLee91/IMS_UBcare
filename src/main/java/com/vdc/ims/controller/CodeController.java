package com.vdc.ims.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.CodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CodeController {

	@Resource(name="codeService")
	private CodeService codeService;

	/**
	 * 공통 코드 관리
	 */
	@RequestMapping(value="/code/cmm/")
	public ModelAndView CodeMng() throws Exception{
		ModelAndView mv = new ModelAndView("view/cmm/mng/code/code");
		return mv;
	}

	@RequestMapping(value="/code/cmm/list")
	public ModelAndView CmmCodeList(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> CmmCode = codeService.CmmCodeList(commandMap.getMap());
		mv.addObject("Code", CmmCode);
		return mv;
	}

	@RequestMapping(value="/code/cmm/add")
	public ModelAndView CmmCodeAdd(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CmmCodeAdd(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/cmm/edit")
	public ModelAndView CmmCodeEdt(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CmmCodeEdt(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/cmm/del")
	public ModelAndView CmmCodeDel(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CmmCodeDel(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/cmm/dtl/list")
	public ModelAndView CmmCodeDtlList(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		List<Map<String, Object>> CmmCode = new ArrayList<Map<String, Object>>();

		if(!commandMap.getMap().isEmpty())
		{
			CmmCode = codeService.CmmCodeDtlList(commandMap.getMap());
		}

		mv.addObject("Code", CmmCode);
		return mv;
	}

	@RequestMapping(value="/code/cmm/dtl/add")
	public ModelAndView CmmCodeDtlAdd(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CmmCodeDtlAdd(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/cmm/dtl/edit")
	public ModelAndView CmmCodeDtlEdt(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CmmCodeDtlEdt(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/cmm/dtl/del")
	public ModelAndView CmmCodeDtlDel(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CmmCodeDtlDel(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/queue/")
	public ModelAndView CodeQueue(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/cmm/mng/code/queue");
		return mv;
	}

	@RequestMapping(value="/code/que/list")
	public ModelAndView CodeQueueList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Que = codeService.CodeQueueList(commandMap.getMap(), session);
		mv.addObject("Code", Que);
		return mv;
	}

	@RequestMapping(value="/code/que/add")
	public ModelAndView CodeQueueAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CodeQueueAdd(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/que/edit")
	public ModelAndView CodeQueueEdt(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CodeQueueEdt(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/que/del")
	public ModelAndView CodeQueueDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CodeQueueDel(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/called/")
	public ModelAndView CodeCalledNumber(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/cmm/mng/code/called");
		return mv;
	}

	@RequestMapping(value="/code/called/list")
	public ModelAndView CodeCalledNumberList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Called = codeService.CodeCalledNumberList(commandMap.getMap(), session);
		mv.addObject("Code", Called);
		return mv;
	}

	@RequestMapping(value="/code/called/add")
	public ModelAndView CodeCalledNumberAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CodeCalledNumberAdd(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/called/edit")
	public ModelAndView CodeCalledNumberEdt(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CodeCalledNumberEdt(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/code/called/del")
	public ModelAndView CodeCalledNumberDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.CodeCalledNumberDel(commandMap.getMap(), session);
		return mv;
	}


	@RequestMapping(value="/code/ifx/groups/list")
	public ModelAndView VirtualGroupsList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Groups = codeService.VirtualGroupsList(commandMap.getMap(), session);
		mv.addObject("Groups", Groups);
		return mv;
	}


	@RequestMapping(value="/code/ifx/teams/list")
	public ModelAndView TeamsList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Teams = codeService.TeamsList(commandMap.getMap(), session);
		mv.addObject("Teams", Teams);
		return mv;
	}


	@RequestMapping(value="/code/ifx/calltype/list")
	public ModelAndView CallTypeList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> CallType = codeService.CallTypeList(commandMap.getMap(), session);
		mv.addObject("CallType", CallType);
		return mv;
	}


	@RequestMapping(value="/code/ifx/monitoredresources/list")
	public ModelAndView MonitoredresourcesList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Monitoredresources = codeService.MonitoredresourcesList(commandMap.getMap(), session);
		mv.addObject("Monitoredresources", Monitoredresources);
		return mv;
	}

	/*
	부서 관리
	* */
	//부서 등록
	@RequestMapping(value="/code/dept/add")
	public ModelAndView DeptAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.DeptAdd(commandMap.getMap(), session);
		return mv;
	}
	//부서 수정
	@RequestMapping(value="/code/dept/edit")
	public ModelAndView DeptEdt(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.DeptEdt(commandMap.getMap(), session);
		return mv;
	}
	//부서 삭제
	@RequestMapping(value="/code/dept/del")
	public ModelAndView DeptDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		codeService.DeptDel(commandMap.getMap(), session);
		return mv;
	}
	//부서명 가져오기
	@RequestMapping(value="/code/dept/deptnm") ///api/code/deptnm.do
	public ModelAndView DeptName(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> Dept = codeService.DeptName(commandMap.getMap());
		mv.addObject("Dept", Dept);
		return mv;
	}
}
