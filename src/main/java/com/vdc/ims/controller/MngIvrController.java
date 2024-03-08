package com.vdc.ims.controller;


import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.common.util.SftpUtil;
import com.vdc.ims.common.util.StringUtil;
import com.vdc.ims.common.util.TTS;
import com.vdc.ims.service.MngIvrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MngIvrController {

	@Resource(name="mngIvrService")
	private MngIvrService mngIvrService;

	@Resource(name="tts")
	private TTS tts;

	@Resource(name="sftp")
	private SftpUtil sftp;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());




	/**
	 * IVR 음원 관리
	*/
	//음원 관리 view
	@RequestMapping(value="/mng/ivr/voice/") // /mng/ivr/voice.do
    public ModelAndView ivrVoice(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/voice");
    	return mv;
    }
	//음원 목록
	@RequestMapping(value="/mng/ivr/voice/list") // /mng/ivr/voicelist.do
    public ModelAndView VoiceList(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Voice = mngIvrService.VoiceList(commandMap.getMap());
	    mv.addObject("data", Voice);
		return mv;
	}

	//음원 미리듣기
	@RequestMapping(value="/mng/ivr/tts/preview/play")
	public ModelAndView tts_previewplay(CommandMap commandMap, HttpServletRequest request) throws Exception{

		Map<String, Object> rtn = tts.MakeTts_File(commandMap.getMap().get("text").toString());
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("rst", rtn);
		return mv;

	}

	//음원등록
	@RequestMapping(value="/mng/ivr/voice/add")
	public ModelAndView VoiceAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		Map<String, Object> rst = new HashMap<String, Object>();

		// Max SC_PROMPT 생성
		Map<String, Object> data = mngIvrService.ServiceMaxPrompt(commandMap.getMap());
		String new_sc_prompt = data.get("SC_PROMPT").toString();

		Map<String, Object> rtn = tts.MakeTts_File(new_sc_prompt, commandMap.getMap().get("svcInfo").toString());

		if ((Boolean) rtn.get("success"))
		{

			//음원이 정상적으로 생성되면
			if ((Boolean) rtn.get("filewrite"))
			{
				//IVR SFTP로 전송
				String uuid_filename = rtn.get("uuid_filename").toString();

				String tts_tempdir = sftp.SftpUp_Main(uuid_filename);
				sftp.SftpUp_Sub(uuid_filename);

				//저장
				// commandMap.getMap().put("FILE_NAME", new_sc_prompt+".wav");
				commandMap.getMap().put("SC_PROMPT", new_sc_prompt);
				commandMap.getMap().put("ORIGINAL_FILE_NAME", uuid_filename);
				mngIvrService.ServiceFileAdd(commandMap.getMap(), session, request);

				//temp 파일 삭제
//				File file = new File(tts_tempdir+uuid_filename);
//				if( file.exists() ) file.delete();
			}

			rst.put("rst", 1);
			rst.put("tts", rtn);
		}
		else
		{
			rst.put("rst", -1);
			rst.put("tts", rtn);
		}

		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("rst", rst);
		return mv;
	}












	//음원 ServiceID 검사
/*	@RequestMapping(value="/mng/ivr/serviceidcheck.do")
    public ModelAndView ServiceIDCheck(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String, Object>> svcID = mngIvrService.ServiceIDCheck(commandMap.getMap());
	    mv.addObject("SvcID", svcID);
		return mv;
	}*/

	//tts test



/*
	//TTS 음원 생성
	@RequestMapping(value="/mng/ivr/svcttscreate.do")
    public ModelAndView  ServiceTTSCreate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	int nReturn=0;
    	String path = this.getClass().getClassLoader().getResource("").getPath();
    	String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		fullPath = pathArr[0];
		
    	libttsapi ttsapi=new libttsapi();
    	
        try {
//	        	nReturn = ttsapi.ttsRequestBuffer("192.168.102.49", 7000, (String)commandMap.getMap().get("ttsText"), 14, libttsapi.FORMAT_WAV, libttsapi.TRUE, libttsapi.TRUE);
        	nReturn = ttsapi.ttsRequestBuffer(this.SRV_IP, this.SRV_PORT, (String)commandMap.getMap().get("ttsText"), this.TONE, libttsapi.FORMAT_WAV, libttsapi.TRUE, libttsapi.TRUE);
        } 
        catch (IOException e) {
        	nReturn = -9;   
    	}           
        if (nReturn == libttsapi.TTS_RESULT_SUCCESS) {
//	        	System.out.println("RequestBuffer Success (length=" +  ttsapi.nVoiceLength + ")!!!");
        	if(session.getAttribute("Emp_No")!=null) {
        		Util.writeByteToFile(fullPath+File.separatorChar +session.getAttribute("Emp_No")+".wav", ttsapi.szVoiceData, ttsapi.nVoiceLength);
        		mv.addObject("tmpFile", session.getAttribute("Emp_No")+".wav");
        		mv.addObject("tmpReturn", 1);
        		mv.addObject("nReturn", nReturn);
        	}
        	else {
        		mv.addObject("tmpFile", "Emp_No is null");
        		mv.addObject("tmpReturn", 0);
        		mv.addObject("nReturn", nReturn);
        	}
        	 
        } 
        else {  
        	mv.addObject("tmpFile", "na");
    		mv.addObject("tmpReturn", 0);
    		mv.addObject("nReturn", nReturn);
    	}
    	
    	CommandMapPrt.PrintKeyValue(log, commandMap);
    	return mv;
    }
*/	
	//TTS 음원 등록
	@RequestMapping(value="/mng/ivr/svcttsreg.do")
    public ModelAndView  ServiceTTSReg(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ServiceTTSReg(commandMap.getMap(), session, request);
		//DB저장해야 할것
		//description
		//filename
		mv.addObject("nReturn",1);
    	return mv;
    }
	
	//서비스 음원 파일 등록
	@RequestMapping(value="/mng/ivr/svc/file/add") // /mng/ivr/svcfileadd.do
    public ModelAndView ServiceFileAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ServiceFileAdd(commandMap.getMap(), session, request);
    	return mv;
    }
	
	//서비스 음원 파일 삭제
	@RequestMapping(value="/mng/ivr/svc/file/del") // /mng/ivr/svcfiledel.do
    public ModelAndView ServiceFileDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ServiceFileDel(commandMap.getMap(), session);
    	return mv;
    }
	
	//서비스 음원 설명 수정
	@RequestMapping(value="/mng/ivr/svc/desc/update") // /mng/ivr/svcdescupdate.do
    public ModelAndView ServiceDescUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ServiceDescUpdate(commandMap.getMap(), session);
    	return mv;
    }
	
	//서비스 음원 파일 및 설명 수정
	@RequestMapping(value="/mng/ivr/svc/file/update") // /mng/ivr/svcfileupdate.do
    public ModelAndView ServiceFileUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ServiceFileUpdate(commandMap.getMap(), session,request);
    	return mv;
    }
	/**
	 * 공휴일관리
	 */
	//공휴일 관리 view
	@RequestMapping(value="/mng/ivr/holiday/") // /mng/ivr/holiday.do
    public ModelAndView ivrHoliday(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/holiday");
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/holiday/set/list") // /mng/ivr/holidaysetlist.do
    public ModelAndView HolidaySetList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> hdset = mngIvrService.HolidaySetList(commandMap.getMap(),session);
	    mv.addObject("HDSet", hdset);
		return mv;
	}
	
	@RequestMapping(value="/mng/ivr/holiday/list") // /mng/ivr/holidaylist.do
    public ModelAndView HolidayList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> hd = mngIvrService.HolidayList(commandMap.getMap());
	    mv.addObject("HD", hd);
		return mv;
	}
	
	//공휴일 그룹 추가
	@RequestMapping(value="/mng/ivr/holiday/set/add") // /mng/ivr/holidaysetadd.do
    public ModelAndView HolidaySetAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.HolidaySetAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/holiday/set/edit") // /mng/ivr/holidaysetedit.do
    public ModelAndView HolidaySetUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.HolidaySetUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/holiday/set/del") // /mng/ivr/holidaysetdel.do
    public ModelAndView HolidaySetDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.HolidaySetDel(commandMap.getMap());
    	return mv;
    }
	
	//공휴일 그룹에 공휴일 추가
	@RequestMapping(value="/mng/ivr/holiday/add") // /mng/ivr/holidayadd.do
    public ModelAndView HolidayAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.HolidayAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/holiday/edit") // /mng/ivr/holidayedit.do
    public ModelAndView HolidayUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.HolidayUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/holiday/del") // /mng/ivr/holidaydel.do
    public ModelAndView HolidayDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.HolidayDel(commandMap.getMap());
    	return mv;
    }
	
	/**
	 * 근무시간관리
	 */
	//근무시간 관리 view
	@RequestMapping(value="/mng/ivr/workhour/") // /mng/ivr/workhour.do
    public ModelAndView ivrWorkhour(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/workhour");
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/workhour/set/list") // /mng/ivr/workhoursetlist.do
    public ModelAndView WorkhourSetList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> whset = mngIvrService.WorkhourSetList(commandMap.getMap(),session);
	    mv.addObject("WHSet", whset);
		return mv;
	}
	
	//근무시간 그룹 추가
	@RequestMapping(value="/mng/ivr/workhour/set/add") // /mng/ivr/workhoursetadd.do
    public ModelAndView WorkhourSetAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.WorkhourSetAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/workhour/set/edit") // /mng/ivr/workhoursetedit.do
    public ModelAndView WorkhourSetUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.WorkhourSetUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/workhour/set/del") // /mng/ivr/workhoursetdel.do
    public ModelAndView WorkhourSetDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.WorkhourSetDel(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/workhour/list") // /mng/ivr/workhourlist.do
    public ModelAndView WorkhourList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> wh = mngIvrService.WorkhourList(commandMap.getMap());
	    mv.addObject("WH", wh);
		return mv;
	}
	//근무시간 추가
	@RequestMapping(value="/mng/ivr/workhour/add") // /mng/ivr/workhouradd.do
    public ModelAndView WorkhourAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.WorkhourAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/workhour/edit") // /mng/ivr/workhouredit.do
    public ModelAndView WorkhourUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.WorkhourUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/workhour/del") // /mng/ivr/workhourdel.do
    public ModelAndView WorkhourDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.WorkhourDel(commandMap.getMap());
    	return mv;
    }
	
	/**
	 * 공지사항관리
	 */
	//공지사항 관리 view
	@RequestMapping(value="/mng/ivr/notice/")
    public ModelAndView ivrNotice(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/notice");
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/notice/list") // /mng/ivr/noticelist.do
    public ModelAndView NoticeList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> notice = mngIvrService.NoticeList(commandMap.getMap(),session);
	    mv.addObject("Notice", notice);
		return mv;
	}
	//근무시간 추가
	@RequestMapping(value="/mng/ivr/notice/add") // /mng/ivr/noticeadd.do
    public ModelAndView NoticeAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.NoticeAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/notice/edit") // /mng/ivr/noticeedit.do
    public ModelAndView NoticeUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.NoticeUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/notice/del") // /mng/ivr/noticedel.do
    public ModelAndView NoticeDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.NoticeDel(commandMap.getMap());
    	return mv;
    }
	
	/**
	 * 라우트 관리
	 */
	//라우트 관리 view
	@RequestMapping(value="/mng/ivr/route/")
    public ModelAndView ivrRoute(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/route");
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/route/list") // /mng/ivr/routelist.do
    public ModelAndView RouteList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> route = mngIvrService.RouteList(commandMap.getMap());
	    mv.addObject("Route", route);
		return mv;
	}
	//라우트 추가
	@RequestMapping(value="/mng/ivr/route/add") // /mng/ivr/routeadd.do
    public ModelAndView RouteAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.RouteAdd(commandMap.getMap());
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/route/edit") // /mng/ivr/routeedit.do
    public ModelAndView RouteUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.RouteUpdate(commandMap.getMap());
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/route/del") // /mng/ivr/routedel.do
    public ModelAndView RouteDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.RouteDel(commandMap.getMap());
    	return mv;
    }
	
	/**
	 * 메뉴관리
	 */
	//메뉴 관리 view
	@RequestMapping(value="/mng/ivr/menu/")
    public ModelAndView ivrMenu(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/menu");
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/menu/set/list") // /mng/ivr/menusetlist.do
    public ModelAndView MenuSetList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> scset = mngIvrService.MenuSetList(commandMap.getMap());
	    mv.addObject("SCSet", scset);
		return mv;
	}
	
	@RequestMapping(value="/mng/ivr/menu/list") // /mng/ivr/menulist.do
    public ModelAndView MenuList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> sc = mngIvrService.MenuList(commandMap.getMap());
	    mv.addObject("SC", sc);
		return mv;
	}
	
	//메뉴 그룹 추가
	@RequestMapping(value="/mng/ivr/menu/set/add") // /mng/ivr/menusetadd.do
    public ModelAndView MenuSetAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.MenuSetAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/menu/set/edit") // /mng/ivr/menusetedit.do
    public ModelAndView MenuSetUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.MenuSetUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/menusetdel.do")
    public ModelAndView MenuSetDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.MenuSetDel(commandMap.getMap());
    	return mv;
    }
	
	//메뉴 그룹에 메뉴 추가
	@RequestMapping(value="/mng/ivr/menu/add") // /mng/ivr/menuadd.do
    public ModelAndView MenuAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.MenuAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/menu/edit") // /mng/ivr/menuedit.do
    public ModelAndView MenuUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.MenuUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/menu/del") // /mng/ivr/menudel.do
    public ModelAndView MenuDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.MenuDel(commandMap.getMap());
    	return mv;
    }
	
	/**
	 * 시나리오관리
	 */
	//시나리오 관리 view
	@RequestMapping(value="/mng/ivr/scenario/")
    public ModelAndView ivrScenario(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/scenario");
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/scenario/list") // /mng/ivr/scenariolist.do
    public ModelAndView ScenarioList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> scenario = mngIvrService.ScenarioList(commandMap.getMap(),session);
	    mv.addObject("Scenario", scenario);
		return mv;
	}
	//시나리오 추가
	@RequestMapping(value="/mng/ivr/scenario/add") // /mng/ivr/scenarioadd.do
    public ModelAndView ScenarioAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ScenarioAdd(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/scenario/edit") // /mng/ivr/scenarioedit.do
    public ModelAndView ScenarioUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ScenarioUpdate(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/mng/ivr/scenario/del") // /mng/ivr/scenariodel.do
    public ModelAndView ScenarioDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.ScenarioDel(commandMap.getMap());
    	return mv;
    }

	/**
	 * dnis 관리
	 */
	//dnis 관리 view
	@RequestMapping(value="/mng/ivr/dnis/") // /mng/ivr/dnis_sc.do
    public ModelAndView ivrDNIS(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/dnis");
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/dnis/list") // /mng/ivr/dnislist.do
    public ModelAndView DNISList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> dnis = mngIvrService.DNISList(commandMap.getMap());
	    mv.addObject("DNIS", dnis);
		return mv;
	}
	//dnis 추가
	@RequestMapping(value="/mng/ivr/dnis/add") // /mng/ivr/dnisadd.do
    public ModelAndView DNISAdd(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.DNISAdd(commandMap.getMap());
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/dnis/edit") // /mng/ivr/dnisedit.do
    public ModelAndView DNISUpdate(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.DNISUpdate(commandMap.getMap());
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/dnis/del") // /mng/ivr/dnisdel.do
    public ModelAndView DNISDel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.DNISDel(commandMap.getMap());
    	return mv;
    }
	
	/*
	 * 블랙리스트 관리
	 * */
	@RequestMapping(value="/mng/ivr/black/") // /mng/ivr/black.do
    public ModelAndView pageBlack(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("view/mng/ivr/black");
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/black/list") // /mng/ivr/blacklist.do
    public ModelAndView getBlackList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> black = mngIvrService.getBlackList(commandMap.getMap());
	    mv.addObject("Black", black);
		return mv;
	}
	@RequestMapping(value="/mng/ivr/black/add") // /mng/ivr/blackadd.do
    public ModelAndView addBlackList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.addBlackList(commandMap.getMap());
    	return mv;
    }
	@RequestMapping(value="/mng/ivr/black/del") // /mng/ivr/blackdel.do
    public ModelAndView delBlackList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mngIvrService.delBlackList(commandMap.getMap());
    	return mv;
    }

}
