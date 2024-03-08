package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public interface MngIvrService {
	
	//음원 목록
	List<Map<String, Object>> VoiceList(Map<String, Object> map) throws Exception;
	//음원 ServiceID 검사
	List<Map<String, Object>> ServiceIDCheck(Map<String, Object> map) throws Exception;
	//ServiceTTSReg
	void ServiceTTSReg(Map<String, Object> map, HttpSession session, HttpServletRequest request) throws Exception;
	//ServiceFileAdd
	void ServiceFileAdd(Map<String, Object> map, HttpSession session, HttpServletRequest request) throws Exception;
	//ServiceFileDel
	void ServiceFileDel(Map<String, Object> map, HttpSession session) throws Exception;
	//ServiceDescUpdate
	void ServiceDescUpdate(Map<String, Object> map, HttpSession session) throws Exception;
	//ServiceFileUpdate
	void ServiceFileUpdate(Map<String, Object> map, HttpSession session, HttpServletRequest request) throws Exception;

	Map<String, Object> ServiceMaxPrompt(Map<String, Object> map) throws Exception;

	//HolidaySet List
	List<Map<String, Object>> HolidaySetList(Map<String, Object> map, HttpSession session) throws Exception;
	//Holiday List
	List<Map<String, Object>> HolidayList(Map<String, Object> map) throws Exception;
	//HolidaySetAdd
	void HolidaySetAdd(Map<String, Object> map) throws Exception;
	//HolidaySetUpdate
	void HolidaySetUpdate(Map<String, Object> map) throws Exception;
	//HolidaySetDel
	void HolidaySetDel(Map<String, Object> map) throws Exception;
	//HolidayAdd
	void HolidayAdd(Map<String, Object> map) throws Exception;
	//HolidayUpdate
	void HolidayUpdate(Map<String, Object> map) throws Exception;
	//HolidayDel
	void HolidayDel(Map<String, Object> map) throws Exception;
	
	//WorkhourSet List
	List<Map<String, Object>> WorkhourSetList(Map<String, Object> map, HttpSession session) throws Exception;
	//WorkhourSetAdd
	void WorkhourSetAdd(Map<String, Object> map) throws Exception;
	//WorkhouretUpdate
	void WorkhourSetUpdate(Map<String, Object> map) throws Exception;
	//WorkhourSetDel
	void WorkhourSetDel(Map<String, Object> map) throws Exception;
	//Workhour List
	List<Map<String, Object>> WorkhourList(Map<String, Object> map) throws Exception;
	//WorkhourAdd
	void WorkhourAdd(Map<String, Object> map) throws Exception;
	//WorkhourUpdate
	void WorkhourUpdate(Map<String, Object> map) throws Exception;
	//WorkhourDel
	void WorkhourDel(Map<String, Object> map) throws Exception;
	//Notice List
	List<Map<String, Object>> NoticeList(Map<String, Object> map, HttpSession session) throws Exception;
	//NoticeAdd
	void NoticeAdd(Map<String, Object> map) throws Exception;
	//NoticeUpdate
	void NoticeUpdate(Map<String, Object> map) throws Exception;
	//NoticeDel
	void NoticeDel(Map<String, Object> map) throws Exception;
	
	//Route List
	List<Map<String, Object>> RouteList(Map<String, Object> map) throws Exception;
	//RouteAdd
	void RouteAdd(Map<String, Object> map) throws Exception;
	//RouteUpdate
	void RouteUpdate(Map<String, Object> map) throws Exception;
	//RouteDel
	void RouteDel(Map<String, Object> map) throws Exception;
	
	//MenuSet List
	List<Map<String, Object>> MenuSetList(Map<String, Object> map) throws Exception;
	//Menu List
	List<Map<String, Object>> MenuList(Map<String, Object> map) throws Exception;
	//MenuSetAdd
	void MenuSetAdd(Map<String, Object> map) throws Exception;
	//MenuSetUpdate
	void MenuSetUpdate(Map<String, Object> map) throws Exception;
	//MenuSetDel
	void MenuSetDel(Map<String, Object> map) throws Exception;
	//MenuAdd
	void MenuAdd(Map<String, Object> map) throws Exception;
	//MenuUpdate
	void MenuUpdate(Map<String, Object> map) throws Exception;
	//MenuDel
	void MenuDel(Map<String, Object> map) throws Exception;
	
	//Scenario List
	List<Map<String, Object>> ScenarioList(Map<String, Object> map, HttpSession session) throws Exception;
	//ScenarioAdd
	void ScenarioAdd(Map<String, Object> map) throws Exception;
	//ScenarioUpdate
	void ScenarioUpdate(Map<String, Object> map) throws Exception;
	//ScenarioDel
	void ScenarioDel(Map<String, Object> map) throws Exception;
	
	//DNIS List
	List<Map<String, Object>> DNISList(Map<String, Object> map) throws Exception;
	//DNISAdd
	void DNISAdd(Map<String, Object> map) throws Exception;
	//DNISUpdate
	void DNISUpdate(Map<String, Object> map) throws Exception;
	//DNISDel
	void DNISDel(Map<String, Object> map) throws Exception;
	
	//getBlackList
	List<Map<String, Object>> getBlackList(Map<String, Object> map) throws Exception;
	void addBlackList(Map<String, Object> map) throws Exception;
	void delBlackList(Map<String, Object> map) throws Exception;



}
