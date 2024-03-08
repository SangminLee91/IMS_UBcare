package com.vdc.ims.controller;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.resolver.CommandMap;

import com.vdc.ims.service.MntngService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;


@Controller
public class MntngController {

	@Resource(name="mntngService")
	private MntngService mntngService;

	//@Autowired
	@Resource(name="httpClient")
    private CloseableHttpClient httpClient;

	/**
	 *통합 대시보드
	*/
	@RequestMapping(value="/mntng/dash/")
    public ModelAndView MntDash() {
    	return new ModelAndView("view/mntng/dash");
    }

	/**
	 *비로그인 통합 대시보드
	 */
	@RequestMapping(value="/mntng/dash/no/")
	public ModelAndView NoLogin_MntDash(CommandMap commandMap, HttpSession session) throws Exception {
		//세션값 강제 넣어준다.
		session.setAttribute("Emp_No", URLDecoder.decode(commandMap.getMap().get("id").toString(), "UTF-8"));
		return new ModelAndView("view/mntng/dash_nologin");
	}
	@RequestMapping(value="/mntng/dash/curdept")
	public ModelAndView getDeptSame(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Cur_Dept = mntngService.getDeptSame(commandMap.getMap(), session);
		mv.addObject("Cur_Dept", Cur_Dept);
		return mv;
	}



	/**
	 *실시간 트렁크 모니터링
	*/
	@RequestMapping(value="/mntng/trunk/")
    public ModelAndView MntTrunk() {
    	return new ModelAndView("view/mntng/trunk");
    }
	
	/**
	 *실시간 IVR 모니터링
	 *
	*/
	@RequestMapping(value="/mntng/ivr/")
    public ModelAndView MntIvr() {
    	return new ModelAndView("view/mntng/ivr");
    }
	
	/**
	 *DNIS별 모니터링 
	 *
	*/
	@RequestMapping(value="/mntng/dnis/")
    public ModelAndView MntDnis() {
    	return new ModelAndView("view/mntng/dnis");
    }

	
	/**
	 *큐별 모니터링
	 *
	*/
	@RequestMapping(value="/mntng/que/")
    public ModelAndView MntQue() {
    	return new ModelAndView("view/mntng/que");
    }
	
	/**
	 *상담사별 모니터링 
	 *
	*/
	@RequestMapping(value="/mntng/agent/")
    public ModelAndView MntAgent() {
		return new ModelAndView("view/mntng/agent");
    }
	
	/**
	 *대기콜 모니터링
	 *
	*/
	@RequestMapping(value="/mntng/standby/")
    public ModelAndView MntStandby() {
    	return new ModelAndView("view/mntng/standby");
    }
	
	/**
	 *시스템 모니터링
	*/
	//시스템 모니터링 view
	@RequestMapping(value="/mntng/system/")
    public ModelAndView MntSystem() throws Exception{
    	return new ModelAndView("view/mntng/system");
    }
	//모니터링 서버 IP 리스트
	@RequestMapping(value="/mntng/system/svrip") // /api/mntng/svrip.do
    public ModelAndView getSvrIP(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> SvrIP = mntngService.getSvrIP(commandMap.getMap());
        mv.addObject("SvrIP", SvrIP);
    	return mv; 
    }	
	
	//모니터링 CPU Data
	@RequestMapping(value="/mntng/system/cpu") // /api/mntng/CpuData.do
    public ModelAndView getCpuData(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Cpu = mntngService.getCpuData(commandMap.getMap());
        mv.addObject("Cpu", Cpu);
    	return mv; 
    }
	//모니터링 Memory Data
	@RequestMapping(value="/mntng/system/memory") // /api/mntng/MemoryData.do
    public ModelAndView getMemoryData(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> Mem = mntngService.getMemoryData(commandMap.getMap());
        mv.addObject("Mem", Mem);
    	return mv; 
    }
	//모니터링 Disk Data
	@RequestMapping(value="/mntng/system/disk") // /api/mntng/DiskData.do
    public ModelAndView getDiskData(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Disk = mntngService.getDiskData(commandMap.getMap());
        mv.addObject("Disk", Disk);
    	return mv; 
    }
	//모니터링 네트워크 Data
	@RequestMapping(value="/api/mntng/NetworkData.do")
    public ModelAndView getNetworkData(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Net = mntngService.getNetworkData(commandMap.getMap());
        mv.addObject("Net", Net);
    	return mv; 
    }
	//프로세스 상태 Data
	@RequestMapping(value="/mntng/system/process") // /api/mntng/ProcData.do
    public ModelAndView getProcData(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Proc = mntngService.getProcData(commandMap.getMap());
        mv.addObject("Proc", Proc);
    	return mv; 
    }
	//모니터링 최종및 금일 Summary Data
	@RequestMapping(value="/mntng/system/summry") // /api/mntng/SummryData.do
    public ModelAndView getSummaryData(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> Summry = mntngService.getSummaryData(commandMap.getMap());
        mv.addObject("Summry", Summry);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : 그룹
	@RequestMapping(value="/api/mntng/OSCCRealtimeGroup.do")
	public ModelAndView getOSCCRealtimeGroup(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> rtg = mntngService.getOSCCRealtimeGroup(commandMap.getMap());
        mv.addObject("RTGroup", rtg);
    	return mv; 
    }
  	//OSCC 실시간 모니터링 : 큐
	@RequestMapping(value="/api/mntng/OSCCRealtimeQueue.do")
	public ModelAndView getOSCCRealtimeQueue(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> rtq = mntngService.getOSCCRealtimeQueue(commandMap.getMap());
        mv.addObject("RTQueue", rtq);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : 큐 - grant
	@RequestMapping(value="/mntng/realtime/queuegrant") // /api/mntng/OSCCRealtimeQueueGrant.do
	public ModelAndView getOSCCRealtimeQueueGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> rtq = mntngService.getOSCCRealtimeQueueGrant(commandMap.getMap(),session);
        mv.addObject("RTQueue", rtq);
    	return mv; 
    }
  	//OSCC 실시간 모니터링 : 사용자
	@RequestMapping(value="/api/mntng/OSCCRealtimeUser.do")
	public ModelAndView getOSCCRealtimeUser(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> rtu = mntngService.getOSCCRealtimeUser(commandMap.getMap());
        mv.addObject("RTUser", rtu);
    	return mv; 
    }
  	//OSCC 실시간 모니터링 : 사용자 - grant
	@RequestMapping(value="/mntng/agent/status") // /api/mntng/OSCCRealtimeUserGrant.do
	public ModelAndView getOSCCRealtimeUserGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> rtu = mntngService.getOSCCRealtimeUserGrant(commandMap.getMap(),session);
        mv.addObject("RTUser", rtu);
    	return mv; 
    }
  	//OSCC 실시간 모니터링 : 콜
	@RequestMapping(value="/api/mntng/OSCCRealtimeContact.do")
	public ModelAndView getOSCCRealtimeContact(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> rtc = mntngService.getOSCCRealtimeContact(commandMap.getMap());
        mv.addObject("RTContact", rtc);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : 큐집계
	@RequestMapping(value="/api/mntng/OSCCCumulativeQueue.do")
	public ModelAndView getOSCCCumulativeQueue(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> cuq = mntngService.getOSCCCumulativeQueue(commandMap.getMap());
        mv.addObject("CUQueue", cuq);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : 큐집계 - grant
	@RequestMapping(value="/mntng/que/status") // /api/mntng/OSCCCumulativeQueueGrant.do
	public ModelAndView getOSCCCumulativeQueueGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> cuq = mntngService.getOSCCCumulativeQueueGrant(commandMap.getMap(),session);
        mv.addObject("CUQueue", cuq);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 대기콜
	@RequestMapping(value="/api/mntng/OSCCDashBoardWaitCallStatus.do")
	public ModelAndView getOSCCDashBoardWaitCallStatus(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> wcs = mntngService.getOSCCDashBoardWaitCallStatus(commandMap.getMap());
        mv.addObject("DashWaitCall", wcs);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 상담원현황
	@RequestMapping(value="/api/mntng/OSCCDashBoardAgentStatus.do")
	public ModelAndView getOSCCDashBoardAgentStatus(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> ags = mntngService.getOSCCDashBoardAgentStatus(commandMap.getMap());
        mv.addObject("DashAgent", ags);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 콜현황
	@RequestMapping(value="/api/mntng/OSCCDashBoardCallStatus.do")
	public ModelAndView getOSCCDashBoardCallStatus(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getOSCCDashBoardCallStatus(commandMap.getMap());
        mv.addObject("DashCall", calls);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 응대율/포기율
	@RequestMapping(value="/api/mntng/OSCCDashBoardRstRate.do")
	public ModelAndView getOSCCDashBoardRstRate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getOSCCDashBoardRstRate(commandMap.getMap());
        mv.addObject("DashRate", calls);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 시간대별 콜정보
	@RequestMapping(value="/api/mntng/OSCCDashBoardTimeunit.do")
	public ModelAndView getOSCCDashBoardTimeunit(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getOSCCDashBoardTimeunit(commandMap.getMap());
        mv.addObject("DashTime", calls);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 대기콜 - grant
	@RequestMapping(value="/mntng/dash/call/wait") // /api/mntng/OSCCDashBoardWaitCallStatusGrant.do
	public ModelAndView getOSCCDashBoardWaitCallStatusGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> wcs = mntngService.getOSCCDashBoardWaitCallStatusGrant(commandMap.getMap(),session);
        mv.addObject("DashWaitCall", wcs);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 상담원현황 - grant
	@RequestMapping(value="/mntng/dash/agent/status") // /api/mntng/OSCCDashBoardAgentStatusGrant.do
	public ModelAndView getOSCCDashBoardAgentStatusGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> ags = mntngService.getOSCCDashBoardAgentStatusGrant(commandMap.getMap(),session);
        mv.addObject("DashAgent", ags);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 콜현황 - grant
	@RequestMapping(value="/mntng/dash/call/status") // /api/mntng/OSCCDashBoardCallStatusGrant.do
	public ModelAndView getOSCCDashBoardCallStatusGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getOSCCDashBoardCallStatusGrant(commandMap.getMap(),session);
        mv.addObject("DashCall", calls);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 응대율/포기율 - grant
	@RequestMapping(value="/mntng/dash/call/rstrate") // /api/mntng/OSCCDashBoardRstRateGrant.do
	public ModelAndView getOSCCDashBoardRstRateGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getOSCCDashBoardRstRateGrant(commandMap.getMap(),session);
        mv.addObject("DashRate", calls);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : Dashboard 시간대별 콜정보 - grant
	@RequestMapping(value="/mntng/dash/call/time") // /api/mntng/OSCCDashBoardTimeunitGrant.do
	public ModelAndView getOSCCDashBoardTimeunitGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getOSCCDashBoardTimeunitGrant(commandMap.getMap(),session);

		List<Map<String,Object>> branch_cd =  mntngService.getDomainNum(commandMap.getMap(), session);
		Map<String, Object> branch = new HashMap<String, Object>();
		branch.put("list", branch_cd);

		Map<String, Object> callback = new HashMap<String, Object>();

		if (!branch_cd.isEmpty()) {
			callback = mntngService.getCallBack(branch, session);
		}
		else
		{
			callback.put("Cnt",0);
		}

        mv.addObject("DashTime", calls);
		mv.addObject("callback", callback);
    	return mv; 
    }
	//OSCC 실시간 모니터링 : IVR 모니터링
	@RequestMapping(value="/mntng/ivr/status") //IVRRealtime.do
	public ModelAndView getIVRRealtime(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getIVRRealtime(commandMap.getMap());
        mv.addObject("IVRReal", calls);
    	return mv; 
    }
	
	//Trunk
	@RequestMapping(value="/mntng/trunk/status")  // /api/mntng/TrunkStatus.do
	public ModelAndView getTrunkStatus(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getTrunkStatus(commandMap.getMap());
        mv.addObject("TrunkStatus", calls);
    	return mv; 
    }
	@RequestMapping(value="/mntng/trunk/ip") // /api/mntng/TrunkIP.do
	public ModelAndView getTrunkIP(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getTrunkIP(commandMap.getMap());
        mv.addObject("TrunkIP", calls);
    	return mv; 
    }
	@RequestMapping(value="/mntng/trunk/timeunit") // /api/mntng/TrunkStatus_Timeunit.do
	public ModelAndView getTrunkStatus_Timeunit(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getTrunkStatus_Timeunit(commandMap.getMap());
        mv.addObject("TrunkStatusTU", calls);
    	return mv; 
    }


	//Trunk realtime httpclient
	@RequestMapping(value="/mntng/trunk/sysinfo") // /mntng/TrunkSysinfo.do
	public ModelAndView getTrunkSysinfo(CommandMap commandMap) throws Exception{
    	Gson gson=new Gson();
    	Type type = new TypeToken<Map<String, Object>>(){}.getType();
    	HttpGet get = new HttpGet();
		String response;
		CloseableHttpResponse httpResponse;

		URI uri = new URI("https://"+commandMap.get("trunkip")+"/core/chieon_sysinfo.php");
		get.setURI(uri);

		httpResponse = this.httpClient.execute(get);
		response = EntityUtils.toString(httpResponse.getEntity());

		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("TrunkSysinfo", gson.fromJson(response, type));
    	return mv; 
    }
	
	@RequestMapping(value="/mntng/trunk/channelinfo") // /api/mntng/TrunkChannelinfo.do
	public ModelAndView getTrunkChannelinfo(CommandMap commandMap) throws Exception{
    	Gson gson=new Gson();
    	Type type = new TypeToken<Map<String, Object>>(){}.getType();
    	HttpGet get=new HttpGet();
		String response;
		CloseableHttpResponse httpResponse;

		URI uri = new  URI("https://"+commandMap.get("trunkip")+"/core/chieon_summary.php");
		get.setURI(uri);
		httpResponse = this.httpClient.execute(get);
		response = EntityUtils.toString(httpResponse.getEntity());

		ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("TrunkChannelinfo", gson.fromJson(response, type));
    	return mv; 
    }
	@RequestMapping(value="/mntng/trunk/channeldetail") // /api/mntng/TrunkChanneldetail.do
	public ModelAndView getTrunkChanneldetail(CommandMap commandMap) throws Exception{
    	Gson gson=new Gson();
    	Type type = new TypeToken<Map<String, Object>>(){}.getType();
    	HttpGet get = new HttpGet();
		String response;
		CloseableHttpResponse httpResponse;

		URI uri = new URI("https://"+commandMap.get("trunkip")+"/core/chieon.php");
		get.setURI(uri);
		httpResponse = this.httpClient.execute(get);
		response = EntityUtils.toString(httpResponse.getEntity());

		ModelAndView mv = new ModelAndView("jsonView");
		try {
			mv.addObject("TrunkChanneldetail", gson.fromJson(response, type));
		}
		catch(JsonSyntaxException e) {
			mv.addObject("TrunkChanneldetail",null);
		}
    	return mv; 
    }


	//DNIS
	@RequestMapping(value="/api/mntng/DNISStatus.do")
	public ModelAndView getDNISStatus(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getDNISStatus(commandMap.getMap());
        mv.addObject("DNISStatus", calls);
    	return mv; 
    }
	//DNIS - grant
	@RequestMapping(value="/mntng/dnis/status") // /api/mntng/DNISStatusGrant.do
	public ModelAndView getDNISStatusGrant(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> calls = mntngService.getDNISStatusGrant(commandMap.getMap(),session);
        mv.addObject("DNISStatus", calls);
    	return mv; 
    }
	
	//네트워크 스위치 모니터링
	@RequestMapping(value="/mntng/networksw.do")
    public ModelAndView MntNetworkSw() throws Exception{
    	return new ModelAndView("view/mntng/networksw");
    }	
	//네트워크 스위치 IP
	@RequestMapping(value="/mntng/getSwitch.do")
    public ModelAndView MntNetworkSwIP(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> IP = mntngService.getSwitch(commandMap.getMap(),session);
        mv.addObject("IP", IP);
    	return mv; 
    }	
	//네트워크 스위치 포트정보
	@RequestMapping(value="/mntng/getSwitchPort.do")
    public ModelAndView MntNetworkSwPort(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> Port = mntngService.getSwitchPort(commandMap.getMap(),session);
        mv.addObject("Port", Port);
    	return mv; 
    }
	//네트워크 스위치 CPU 
	@RequestMapping(value="/mntng/getSwitchCpu.do")
    public ModelAndView MntNetworkSwCpu(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> Cpu = mntngService.getSwitchCpu(commandMap.getMap(),session);
        mv.addObject("Cpu", Cpu);
    	return mv; 
    }
	//아날로그 게이트웨이 정보
	@RequestMapping(value="/mntng/getGateWay.do")
    public ModelAndView MntGateWay(CommandMap commandMap, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> IP =  mntngService.getGateWay(commandMap.getMap(), session);
        mv.addObject("IP", IP);
    	return mv; 
    }

    //콜백 Count
	@RequestMapping(value="/mntng/getCallbackCnt")
	public ModelAndView getCallBack(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> CALLBACK =  mntngService.getCallBack(commandMap.getMap(), session);
		mv.addObject("data", CALLBACK);
		return mv;
	}
	//



}
