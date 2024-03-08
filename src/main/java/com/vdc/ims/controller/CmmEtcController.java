package com.vdc.ims.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.CodeService;
import com.vdc.ims.service.CmmEtcService;
import com.vdc.ims.service.MntngService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CmmEtcController {

	@Resource(name="cmmEtcService")
	private CmmEtcService cmmEtcService;

	@Resource(name="codeService")
	private CodeService codeService;

	@Resource(name="mntngService")
	private MntngService mntngService;

	/**
	 * Blank page
	 */
	//Page View
	@RequestMapping(value="/blank")
	public ModelAndView Blank(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/blank");
		return mv;
	}

	/**
	 * 메인
	*/
	//Page View
	@RequestMapping(value={"/main", "/main/"})
    public ModelAndView Main(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/main");
		mv.setViewName("redirect:/mntng/dash/");

    	return mv;
    }
	/**
	 * 메인 대쉬보드
	*/
	@RequestMapping(value="/main/dash") // /maindash.do
    public ModelAndView MainDash(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> DashCur = cmmEtcService.MainDash(commandMap.getMap(), session);
    	List<Map<String,Object>> DashAgent = mntngService.getOSCCDashBoardAgentStatusGrant(commandMap.getMap(),session);

        mv.addObject("DashCur", DashCur);
        mv.addObject("DashAgent", DashAgent);
    	return mv;
    }
	/**
	 * 메인 대쉬보드 이전데이타
	*/
	@RequestMapping(value="/main/dash/prev") // /maindashprev.do
    public ModelAndView MainDashPrev(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Prev = cmmEtcService.MainDashPrev(commandMap.getMap(), session);

        mv.addObject("Prev", Prev);
    	return mv;
    }


	/**
	 * 메뉴
	*/
	//메뉴
	@RequestMapping(value="/api/cmm/getMenu.do")
    public ModelAndView getMenu(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Menu = cmmEtcService.getMenu(commandMap.getMap(), session);
        mv.addObject("Menu", Menu);
    	return mv;
    }


	/**
	 * 서버 모니터링 관리
	*/
	@RequestMapping(value="/cmm/mng/system/system.do")
    public ModelAndView System(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/cmm/mng/system/system");
    	return mv;
    }
	//시스템 모니터링 관리
	@RequestMapping(value="/api/mng/system/getSvr")
    public ModelAndView getSvr(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> Svr = cmmEtcService.getSvr(commandMap.getMap());
    	mv.addObject("Svr", Svr);
    	return mv;
    }
	//시스템 모니터링 저장
	@RequestMapping(value="/api/mng/system/addSvr")
    public ModelAndView addSvr(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	cmmEtcService.addSvr(commandMap.getMap(), session);
    	return mv;
    }
	//시스템 모니터링 수정
	@RequestMapping(value="/api/mng/system/EdtSvr")
    public ModelAndView EdtSvr(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	cmmEtcService.edtSvr(commandMap.getMap(), session);
    	return mv;
    }
	//시스템 모니터링 삭제
	@RequestMapping(value="/api/mng/system/DelSvr")
    public ModelAndView DelSvr(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	cmmEtcService.delSvr(commandMap.getMap(), session);
    	return mv;
    }

	/**
	 * 서버 모니터링 프로세스
	*/
	//시스템 모니터링 관리
	@RequestMapping(value="/api/mng/system/getProc")
    public ModelAndView getProc(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> Proc = cmmEtcService.getProc(commandMap.getMap());
    	mv.addObject("Proc", Proc);
    	return mv;
    }
	//시스템 프로세스 저장
	@RequestMapping(value="/api/mng/system/AddProc")
    public ModelAndView AddProc(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	cmmEtcService.addProc(commandMap.getMap(), session);
    	return mv;
    }
	//시스템 프로세스 수정
	@RequestMapping(value="/api/mng/system/EdtProc")
    public ModelAndView EdtProc(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	cmmEtcService.edtProc(commandMap.getMap(), session);
    	return mv;
    }
	//시스템 프로세스 삭제
	@RequestMapping(value="/api/mng/system/DelProc")
    public ModelAndView DelProc(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	cmmEtcService.delProc(commandMap.getMap(), session);
    	return mv;
    }


	/**
	 * 녹취 청취 이력 관리
	*/
	@RequestMapping(value="/cmm/hist/rec/listen/") // /cmm/hist/rec_listen_hist.do
    public ModelAndView RecListenHist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/cmm/etc/rec_listen_hist");
    	return mv;
    }
	@RequestMapping(value="/cmm/hist/rec/listen/list")  // /api/hist/getlistenhist.do
    public ModelAndView getListenHist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");

    	/*
    	List<List<Object>> datas = cmmEtcService.getListenHist(commandMap.getMap());
    	List<Map<String,Object>> TotCount = getDataset( datas , 0 ); //전체 row수
    	List<Map<String,Object>> data = getDataset( datas , 1 ); //Data
    	*/

    	List<Map<String,Object>> TotCount = cmmEtcService.getListenHistTotCnt(commandMap.getMap());
    	List<Map<String,Object>> data = cmmEtcService.getListenHistData(commandMap.getMap());


        mv.addObject("draw", commandMap.get("draw"));
    	mv.addObject("recordsTotal", TotCount.get(0).get("TotRowCnt")); //전체 row수
    	mv.addObject("recordsFiltered", TotCount.get(0).get("TotRowCnt")); //검색후 rows수
    	mv.addObject("data", data);

    	return mv;
    }


	/**
	 * 녹취 다운 이력 관리
	*/
	@RequestMapping(value="/cmm/hist/rec/down/") // /cmm/hist/rec_down_hist.do
    public ModelAndView RecDownHist(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/cmm/etc/rec_down_hist");
    	return mv;
    }
	@RequestMapping(value="/api/hist/rec/down/list") // /api/hist/getdownhist.do
    public ModelAndView getDownHist(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");

    	List<Map<String,Object>> data = cmmEtcService.getDownHist(commandMap.getMap());
    	Map<String,Object> TotCount = cmmEtcService.getDownHistCnt(commandMap.getMap());

        mv.addObject("draw", commandMap.get("draw"));
    	mv.addObject("recordsTotal", TotCount.get("TotRowCnt")); //전체 row수
    	mv.addObject("recordsFiltered", TotCount.get("TotRowCnt")); //검색후 rows수
    	mv.addObject("data", data);

    	return mv;
    }


	/**
	 * 계정변경 이력
	 */
	@RequestMapping(value="/cmm/hist/rec/change/")
	public ModelAndView AccountChange(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/cmm/etc/account_change_hist");
		return mv;
	}
	@RequestMapping(value="/cmm/hist/rec/change/list")
	public ModelAndView getAccountChange(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		List<Map<String,Object>> data = cmmEtcService.getAccountChange(commandMap.getMap());
		Map<String,Object> TotCount = cmmEtcService.getAccountChangeCnt(commandMap.getMap());

		mv.addObject("draw", commandMap.get("draw"));
		mv.addObject("recordsTotal", TotCount.get("TotRowCnt")); //전체 row수
		mv.addObject("recordsFiltered", TotCount.get("TotRowCnt")); //검색후 rows수
		mv.addObject("data", data);

		return mv;
	}

	/**
	 * 로그인 이력
	 */

	@RequestMapping(value="/cmm/hist/rec/loginhist/")
	public ModelAndView LoginHist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/cmm/etc/login_hist");
		return mv;
	}
	@RequestMapping(value="/cmm/hist/rec/loginhist/list")
	public ModelAndView getLogin(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		List<Map<String,Object>> data = cmmEtcService.getLoginHist(commandMap.getMap());
		Map<String,Object> TotCount = cmmEtcService.getLoginHistCnt(commandMap.getMap());


		mv.addObject("draw", commandMap.get("draw"));
		mv.addObject("recordsTotal", TotCount.get("TotRowCnt")); //전체 row수
		mv.addObject("recordsFiltered", TotCount.get("TotRowCnt")); //검색후 rows수
		mv.addObject("data", data);

		return mv;
	}

	/**
	 * 로그인 이력(건수)
	 */

	@RequestMapping(value="/cmm/hist/rec/loginhisttot/")
	public ModelAndView LoginHistCount(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("view/cmm/etc/login_hist_total");
		return mv;
	}
	@RequestMapping(value="/cmm/hist/rec/loginhisttot/list")
	public ModelAndView getLoginCount(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		List<Map<String,Object>> data = cmmEtcService.getLoginHistTotal(commandMap.getMap());
		Map<String,Object> TotCount = cmmEtcService.getLoginHistTotalCnt(commandMap.getMap());

		mv.addObject("draw", commandMap.get("draw"));
		mv.addObject("recordsTotal", TotCount.get("TotRowCnt")); //전체 row수
		mv.addObject("recordsFiltered", TotCount.get("TotRowCnt")); //검색후 rows수
		mv.addObject("data", data);

		return mv;
	}

	/**
	 * 녹취 조회 관리
	*/
	@RequestMapping(value="/mng/rec/") // /mng/rec/record.do
    public ModelAndView RecordList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/rec/record");
    	return mv;
    }
	@RequestMapping(value="/mng/rec/list")  // /api/rec/getrecord.do
    public ModelAndView getRecord(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");

    	List<Map<String,Object>> data = cmmEtcService.getRecord(commandMap.getMap(), session);
    	Map<String,Object> TotCount = cmmEtcService.getRecordCnt(commandMap.getMap(), session);

        mv.addObject("draw", commandMap.get("draw"));
    	mv.addObject("recordsTotal", TotCount.get("TotRowCnt")); //전체 row수
    	mv.addObject("recordsFiltered", TotCount.get("TotRowCnt")); //검색후 rows수
    	mv.addObject("data", data);

    	return mv;
    }

	// get Dnis info
	@RequestMapping(value="/cmm/dnis/list")
	public ModelAndView getDnisList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> dnis = cmmEtcService.getDnisList(commandMap.getMap());
		mv.addObject("dnis", dnis);
		return mv;
	}

	// get Dept info
	@RequestMapping(value="/cmm/dept/list")
	public ModelAndView getDeptList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> dept = cmmEtcService.getDeptList(commandMap.getMap());
		mv.addObject("dept", dept);
		return mv;
	}

	// get Div info
	@RequestMapping(value="/cmm/div/list")
	public ModelAndView getDivList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> div = cmmEtcService.getDivList(commandMap.getMap());
		mv.addObject("div", div);
		return mv;
	}

}
