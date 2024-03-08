package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

public interface SttIvrService {
	List<Map<String, Object>> getServiceStat(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getMenuStat(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getServiceStatbyDNIS(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getCallbackList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getCallbackStat(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getCallbackType(Map<String, Object> map) throws Exception;
}
