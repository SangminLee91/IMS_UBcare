package com.vdc.ims.service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface HistoryService {

	List<Map<String, Object>> getHistTotCnt(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getHistSrchCnt(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getHistData(Map<String, Object> map) throws Exception;

	void addHist(Map<String, Object> map) throws Exception;

}
