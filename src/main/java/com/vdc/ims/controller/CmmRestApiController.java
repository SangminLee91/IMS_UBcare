package com.vdc.ims.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.CmmRestApiService;

import com.vdc.ims.service.MntngService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@CrossOrigin("*")
@Controller
public class CmmRestApiController {

	@Resource(name="cmmRestApiService")
	private CmmRestApiService cmmRestApiService;

	@Resource(name="mntngService")
	private MntngService mntngService;

	//전체 사원 목록
	@RequestMapping(value="/cmm/ajax/total/emp/list")
    public ModelAndView getTotalEmp(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Emp = cmmRestApiService.getTotalEmp(commandMap.getMap());
	    mv.addObject("Emp", Emp);
		return mv;
    }

	//전체 부서 목록
	@RequestMapping(value="/cmm/ajax/total/dept/list")
    public ModelAndView getTotalDept(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Dept = cmmRestApiService.getTotalDept(commandMap.getMap());
	    mv.addObject("Dept", Dept);
		return mv;
	}

	//권한에 따른 사원 목록
	@RequestMapping(value="/cmm/ajax/emp/list") // /cmm/api/emp.do
    public ModelAndView getEmp(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Emp = cmmRestApiService.getEmp(commandMap.getMap(), session);
	    mv.addObject("Emp", Emp);
		return mv;
    }
	//권한에 따른 부서 목록
	@RequestMapping(value="/cmm/ajax/dept/list") // /cmm/api/dept.do
    public ModelAndView getDept(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Dept = cmmRestApiService.getDept(commandMap.getMap(), session);
	    mv.addObject("Dept", Dept);
		return mv;
	}

	//권한에 따른 유저그룹
	@RequestMapping(value = "/cmm/ajax/usergroup/list")
	public ModelAndView getUserGroup(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> userGroup = cmmRestApiService.getUserGroup(commandMap.getMap(), session);
		mv.addObject("userGroup", userGroup);
		return mv;
	}

	//권한에 따른 Que
	@RequestMapping(value="/cmm/ajax/grantque") // /cmm/api/grantque.do
    public ModelAndView getGrantQue(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Que = cmmRestApiService.getGrantQue(commandMap.getMap(), session);
	    mv.addObject("Code", Que);
		return mv;
	}

	//권한에 따른 CalledNumber
	@RequestMapping(value="/cmm/ajax/grantcalled") // /cmm/api/grantcalled.do
    public ModelAndView getGrantCalled(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Called = cmmRestApiService.getGrantCalled(commandMap.getMap(), session);
	    mv.addObject("Code", Called);
		return mv;
	}

	//권한에 따른 브랜치 코드 _콜백에서만 사용
	@RequestMapping(value="/cmm/ajax/grantbranch")
	public ModelAndView getBranch(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Branch = cmmRestApiService.getGrantBranch(commandMap.getMap(), session);
		mv.addObject("Code", Branch);
		return mv;
	}



	//상담원 어플리케이션 계정 정보 동기화
	@RequestMapping(value="/cmm/api/appsync.do") // /api/code/ifxMonitoredresources.do
    public ModelAndView getAppSyncEmp(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Emp = cmmRestApiService.getAppSyncEmp(commandMap.getMap(), session);
	    mv.addObject("Emp", Emp);
		return mv;
	}

	//약국서비스팀 사용할 대기콜
	@RequestMapping(value="/cmm/api/call/data/")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	public Map<String,Object> getApiWaitCall(CommandMap commandMap, HttpSession session) throws Exception{
		Map<String,Object> callDate = cmmRestApiService.getApiWaitCall(commandMap.getMap());
		List<Map<String,Object>> branch_cd =  mntngService.getDomainNumNoSession(commandMap.getMap());
		Map<String, Object> branch = new HashMap<>();
		branch.put("list", branch_cd);

		Map<String, Object> callbackData = new HashMap<String, Object>();

		if (!branch_cd.isEmpty()) {
			callbackData = mntngService.getCallBack(branch);
		}
		else
		{
			callbackData.put("Cnt",0);
		}

		Map<String, Object> rtnData = new HashMap<String, Object>();
		rtnData.put("calls", callDate);
		rtnData.put("callback", callbackData);

		return rtnData;
	}

	//콜백구분 코드 _콜백에서만 사용
	@RequestMapping(value="/cmm/ajax/getCallBack")
	public ModelAndView getCallBack(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> callBack = cmmRestApiService.getCallBack(commandMap.getMap(), session);
		mv.addObject("CallBack", callBack);
		return mv;
	}

	//의사랑 서비스 자동접수
	@RequestMapping(value="/mng/ivr/service/request")
	public ModelAndView requestService(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> result = cmmRestApiService.requestService(commandMap.getMap());
		mv.addObject("data", result.get(0));
		return mv;
	}

	//input Dnis output dept
	@RequestMapping(value="/cmm/api/getDeptFromDnis")
	public ModelAndView getDeptFromDnis(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> result = cmmRestApiService.getDeptFromDnis(commandMap.getMap());
		mv.addObject("data", result.get(0));
		return mv;
	}

}
