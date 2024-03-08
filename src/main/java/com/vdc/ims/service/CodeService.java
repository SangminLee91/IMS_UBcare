package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface CodeService {

	//공통코드
	List<Map<String, Object>> CmmCodeList(Map<String, Object> map) throws Exception;
	void CmmCodeAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void CmmCodeEdt(Map<String, Object> map, HttpSession session) throws Exception;
	void CmmCodeDel(Map<String, Object> map, HttpSession session) throws Exception;
	
	//공통코드 상세
	List<Map<String, Object>> CmmCodeDtlList(Map<String, Object> map) throws Exception;
	void CmmCodeDtlAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void CmmCodeDtlEdt(Map<String, Object> map, HttpSession session) throws Exception;
	void CmmCodeDtlDel(Map<String, Object> map, HttpSession session) throws Exception;

	//부서
	void DeptAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void DeptEdt(Map<String, Object> map, HttpSession session) throws Exception;
	void DeptDel(Map<String, Object> map, HttpSession session) throws Exception;
	Map<String, Object> DeptName(Map<String, Object> map) throws Exception;
	
	
	//Queue Code 
	List<Map<String, Object>> CodeQueueList(Map<String, Object> map, HttpSession session) throws Exception;
	void CodeQueueAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void CodeQueueEdt(Map<String, Object> map, HttpSession session) throws Exception;
	void CodeQueueDel(Map<String, Object> map, HttpSession session) throws Exception;
	
	//CalledNumber Code 
	List<Map<String, Object>> CodeCalledNumberList(Map<String, Object> map, HttpSession session) throws Exception;
	void CodeCalledNumberAdd(Map<String, Object> map, HttpSession session) throws Exception;
	void CodeCalledNumberEdt(Map<String, Object> map, HttpSession session) throws Exception;
	void CodeCalledNumberDel(Map<String, Object> map, HttpSession session) throws Exception;
	
 	//IMS_IFX VirtualGroups
	List<Map<String, Object>> VirtualGroupsList(Map<String, Object> map, HttpSession session) throws Exception;
	
	//IMS_IFX Teams
    List<Map<String, Object>> TeamsList(Map<String, Object> map, HttpSession session) throws Exception;
    
	//IMS_IFX CallType
    List<Map<String, Object>> CallTypeList(Map<String, Object> map, HttpSession session) throws Exception;
    
	//IMS_IFX Monitoredresources
    List<Map<String, Object>> MonitoredresourcesList(Map<String, Object> map, HttpSession session) throws Exception;   
    
}
