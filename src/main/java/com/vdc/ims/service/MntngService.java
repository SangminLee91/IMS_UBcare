package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface MntngService {
	//모니터링 CPU Data
	List<Map<String, Object>> getCpuData(Map<String, Object> map) throws Exception;
	//모니터링 Memory Data
	Map<String, Object> getMemoryData(Map<String, Object> map) throws Exception;	
	//모니터링 서버 IP 리스트
	List<Map<String, Object>> getSvrIP(Map<String, Object> map) throws Exception;
	//모니터링 Disk 리스트
	List<Map<String, Object>> getDiskData(Map<String, Object> map) throws Exception;
	//모니터링 Network 리스트
	List<Map<String, Object>> getNetworkData(Map<String, Object> map) throws Exception;	
	//모니터링 프로세스 상태 리스트
	List<Map<String, Object>> getProcData(Map<String, Object> map) throws Exception;	
	//모니터링 최종및 금일 Summary Data
	List<Map<String, Object>> getSummaryData(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : 그룹
	List<Map<String, Object>> getOSCCRealtimeGroup(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : 큐
	List<Map<String, Object>> getOSCCRealtimeQueue(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : 큐 - grant
	List<Map<String, Object>> getOSCCRealtimeQueueGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//OSCC 실시간 모니터링 : 사용자
	List<Map<String, Object>> getOSCCRealtimeUser(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : 사용자 - grant
	List<Map<String, Object>> getOSCCRealtimeUserGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//OSCC 실시간 모니터링 : 콜
	List<Map<String, Object>> getOSCCRealtimeContact(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : 큐집계
	List<Map<String, Object>> getOSCCCumulativeQueue(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : 큐집계 - grant
	List<Map<String, Object>> getOSCCCumulativeQueueGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 대기콜
	List<Map<String, Object>> getOSCCDashBoardWaitCallStatus(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 상담원현황
	List<Map<String, Object>> getOSCCDashBoardAgentStatus(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 콜현황
	List<Map<String, Object>> getOSCCDashBoardCallStatus(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 응대율/포기율
	List<Map<String, Object>> getOSCCDashBoardRstRate(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 히스토리
	List<Map<String, Object>> getOSCCDashBoardTimeunit(Map<String, Object> map) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 대기콜 grant
	List<Map<String, Object>> getOSCCDashBoardWaitCallStatusGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 상담원현황 grant
	List<Map<String, Object>> getOSCCDashBoardAgentStatusGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 콜현황 grant
	List<Map<String, Object>> getOSCCDashBoardCallStatusGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 응대율/포기율 grant
	List<Map<String, Object>> getOSCCDashBoardRstRateGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//OSCC 실시간 모니터링 : Dashboard 히스토리 grant
	List<Map<String, Object>> getOSCCDashBoardTimeunitGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//IVR Realtime monitoring
	List<Map<String, Object>> getIVRRealtime(Map<String, Object> map) throws Exception;
	//Trunk
	List<Map<String, Object>> getTrunkStatus(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getTrunkIP(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getTrunkStatus_Timeunit(Map<String, Object> map) throws Exception;
	//DNIS
	List<Map<String, Object>> getDNISStatus(Map<String, Object> map) throws Exception;
	//DNIS - grant
	List<Map<String, Object>> getDNISStatusGrant(Map<String, Object> map, HttpSession session) throws Exception;
	//getSwitch
	List<Map<String, Object>> getSwitch(Map<String, Object> map, HttpSession session) throws Exception;
	
	//getSwitchPort
	List<Map<String, Object>> getSwitchPort(Map<String, Object> map, HttpSession session) throws Exception;
	//getSwitchCpu
	List<Map<String, Object>> getSwitchCpu(Map<String, Object> map, HttpSession session) throws Exception;
	//getGateWay
	List<Map<String, Object>> getGateWay(Map<String, Object> map, HttpSession session) throws Exception;

	//getCallBack Count
	Map<String, Object> getCallBack(Map<String, Object> map, HttpSession session) throws Exception;
	//getCallBack Count
	Map<String, Object> getCallBack(Map<String, Object> map) throws Exception;


	//getDomain Num (branch cd)
	List<Map<String, Object>> getDomainNum(Map<String, Object> map, HttpSession session) throws Exception;

	//getDomain Num (branch cd) call 관련 API (약국서비스팀)
	List<Map<String, Object>> getDomainNumNoSession(Map<String, Object> map) throws Exception;


	List<Map<String, Object>> getDeptSame(Map<String, Object> map, HttpSession session) throws Exception;


}
