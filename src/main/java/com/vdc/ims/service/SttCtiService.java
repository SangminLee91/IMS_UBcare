package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

public interface SttCtiService {
	List<Map<String, Object>> getAgentData(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getAgentHistData(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getAgentResultData(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getAgentCallData(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getAgentStatusData(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getQueueStatsData(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> sttAgentQueData(Map<String, Object> map) throws Exception;
	
}
