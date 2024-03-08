package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


public interface MngCtiService {

	List<Map<String, Object>> getAgentEmp(Map<String, Object> map) throws Exception;
	void AgentAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void AgentEdt(Map<String, Object> map, HttpSession session) throws Exception;
	Map<String, Object> AgentDel(Map<String, Object> map, HttpSession session) throws Exception;
	List<Map<String, Object>> AgentKeyList(Map<String, Object> map) throws Exception;

	//그룹
	List<Map<String, Object>> GroupList(Map<String, Object> map) throws Exception;
	void GroupAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void GroupEdt(Map<String, Object> map, HttpSession session) throws Exception;
	void GroupDel(Map<String, Object> map, HttpSession session) throws Exception;
	List<Map<String, Object>> GroupEmp(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> EmpGroup(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> GrantGroupList(Map<String, Object> map, HttpSession session) throws Exception;
	
	//헌트그룹
	//List<List<Object>> HuntList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> HuntListMOH(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> HuntListInitial(Map<String, Object> map) throws Exception;
	//큐타켓
	List<Map<String, Object>> QueueTarget(Map<String, Object> map) throws Exception;


	//콜백 사용자 변경
	List<Map<String, Object>> getMatchDept(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getMatchBranch(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getMatchAgent(Map<String, Object> map) throws Exception;
	void MatchAgentEdt(Map<String, Object> map, HttpSession session) throws Exception;
	List<Map<String, Object>> getMatchBranchCallback(Map<String, Object> map) throws Exception;


	List<Map<String, Object>> getDnisBranchList(Map<String, Object> map) throws Exception;
	void dnisBranchAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void dnisBranchEdt(Map<String, Object> map, HttpSession session) throws Exception;
	void dnisBranchDel(Map<String, Object> map, HttpSession session) throws Exception;

}
