package com.vdc.ims.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.MngCtiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controller
 * @author Mir
 *
 */
@Controller
public class MngCtiController {

	@Resource(name="mngCtiService")
	private MngCtiService mngCtiService;

	/**
	 * CTI 관리
	*/
	//상담원 관리
	@RequestMapping(value="/mng/cti/agent/")
    public ModelAndView ctiAgent() throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/cti/agent");
    	return mv;
    }

	//상담원 사원 목록
	@RequestMapping(value="/mng/cti/agent/list")
	public ModelAndView getAgentEmp(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Emp = mngCtiService.getAgentEmp(commandMap.getMap());
		mv.addObject("Emp", Emp);
		return mv;
	}

	//상담원 등록
	@RequestMapping(value="/mng/cti/agent/add")
    public ModelAndView AgentAdd(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngCtiService.AgentAdd(commandMap.getMap(), session);
    	return mv;
    }
	
	//상담원 수정
	@RequestMapping(value="/mng/cti/agent/edit")
    public ModelAndView AgentEdt(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngCtiService.AgentEdt(commandMap.getMap(), session);
    	return mv;
    }
	//상담원 삭제 
	@RequestMapping(value="/mng/cti/agent/del")
    public ModelAndView AgentDel(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
	    Map<String,Object> Rst = mngCtiService.AgentDel(commandMap.getMap(), session);
	    mv.addObject("Rst", Rst);
    	return mv;
    }

	//사용가능 Agent_Key 
	@RequestMapping(value="/mng/cti/agent/key/list")
    public ModelAndView AgentKeyList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> AgentKey = mngCtiService.AgentKeyList(commandMap.getMap());
	    mv.addObject("AgentKey", AgentKey);
		return mv;
    }
	
	//부서 관리 view
	@RequestMapping(value="/mng/cti/dept/")
    public ModelAndView ctiDept() throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/cti/dept");
    	return mv;
    }

	//그룹 관리 view
	@RequestMapping(value="/mng/cti/group/")
    public ModelAndView ctiGroup() throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/cti/group");
    	return mv;
    }
	
	//그룹 목록
	@RequestMapping(value="/mng/cti/group/list") // /mng/cti/grouplist.do
    public ModelAndView GroupList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Group = mngCtiService.GroupList(commandMap.getMap());
	    mv.addObject("Group", Group);
		return mv;
    }
	//그룹 등록
	@RequestMapping(value="/mng/cti/group/add")
    public ModelAndView GroupAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngCtiService.GroupAdd(commandMap.getMap(), session);
    	return mv;
    }	
	//그룹 수정
	@RequestMapping(value="/mng/cti/groupedt.do")
    public ModelAndView GroupEdt(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngCtiService.GroupEdt(commandMap.getMap(), session);
    	return mv;
    }
	//그룹 삭제
	@RequestMapping(value="/mng/cti/group/del")
    public ModelAndView GroupDel(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngCtiService.GroupDel(commandMap.getMap(), session);
    	return mv;
    }

	//권한에 따른 그룹 목록
	@RequestMapping(value="/mng/cti/group/grant/list") // /mng/cti/grantgrouplist.do
    public ModelAndView GrantGroupList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Group = mngCtiService.GrantGroupList(commandMap.getMap(),session);
	    mv.addObject("Group", Group);
		return mv;
    }

	/*
	//그룹내 상담원 목록
	@RequestMapping(value="/mng/cti/groupemp.do")
    public ModelAndView GroupEmp(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Emp = mngCtiService.GroupEmp(commandMap.getMap());
	    mv.addObject("Emp", Emp);
		return mv;
    }
    */
	//상담원이 속한 그룹 목록
	@RequestMapping(value="/mng/cti/empgroup.do")
    public ModelAndView EmpGroup(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Group = mngCtiService.EmpGroup(commandMap.getMap());
	    mv.addObject("Group", Group);
		return mv;
    }
	
	//헌트 그룹
	@RequestMapping(value="/mng/cti/hunt/")
    public ModelAndView Hunt(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/cti/hunt_group");
    	return mv;
    }
	
	
	//MOH, Initial 헌트그룹 목록
	@RequestMapping(value="/mng/cti/hunt/list")
    public ModelAndView HuntList(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");

    	List<Map<String,Object>> MOH = mngCtiService.HuntListMOH(commandMap.getMap());
    	List<Map<String,Object>> Initial = mngCtiService.HuntListInitial(commandMap.getMap());
    	
	    mv.addObject("MOH", MOH);
	    mv.addObject("Initial", Initial);
		return mv;
    }
	
	//큐 타켓
	@RequestMapping(value="/mng/cti/queue/target/")
    public ModelAndView QueueTarget(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/cti/queuetarget");
    	return mv;
    }
	//큐타켓 목록
	@RequestMapping(value="/mng/cti/queue/target/list")
    public ModelAndView QueueTargetList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Que = mngCtiService.QueueTarget(commandMap.getMap());
	    mv.addObject("Que", Que);
		return mv;
    }


    //콜백 사용자변경
	@RequestMapping(value="/mng/cti/callback_user/")
	public ModelAndView CallbackUser(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/mng/cti/callback_user");
		return mv;
	}
	@RequestMapping(value="/mng/cti/callback_user/dept")
	public ModelAndView CallbackUserDept(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Dept = mngCtiService.getMatchDept(commandMap.getMap());
		mv.addObject("Dept", Dept);
		return mv;
	}
	@RequestMapping(value="/mng/cti/callback_user/branch")
	public ModelAndView CallbackUserBranch(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Branch = mngCtiService.getMatchBranch(commandMap.getMap());
		mv.addObject("Branch", Branch);
		return mv;
	}
	@RequestMapping(value="/mng/cti/callback_user/agent")
	public ModelAndView CallbackUserAgent(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Agent = mngCtiService.getMatchAgent(commandMap.getMap());
		mv.addObject("Agent", Agent);
		return mv;
	}
	@RequestMapping(value="/mng/cti/callback_user/set")
	public ModelAndView CallbackUserAgentSet(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		mngCtiService.MatchAgentEdt(commandMap.getMap(), session);
		return mv;
	}
	@RequestMapping(value="/mng/cti/callback_user/callback/cnt")
	public ModelAndView getMatchBranchCallback(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Cnt = mngCtiService.getMatchBranchCallback(commandMap.getMap());
		mv.addObject("callback", Cnt);
		return mv;
	}

	@RequestMapping(value="/mng/cti/dnis_branch")
	public ModelAndView dnisBranch(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/mng/cti/dnis_branch");
		return mv;
	}

	@RequestMapping(value="/mng/cti/dnis_branch/list")
	public ModelAndView getDnisBranchList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> list = mngCtiService.getDnisBranchList(commandMap.getMap());
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value="/mng/cti/dnis_branch/add")
	public ModelAndView dnisBranchAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		mngCtiService.dnisBranchAdd(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/mng/cti/dnis_branch/edt")
	public ModelAndView dnisBranchEdt(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		mngCtiService.dnisBranchEdt(commandMap.getMap(), session);
		return mv;
	}

	@RequestMapping(value="/mng/cti/dnis_branch/del")
	public ModelAndView dnisBranchDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		mngCtiService.dnisBranchDel(commandMap.getMap(), session);
		return mv;
	}

}
