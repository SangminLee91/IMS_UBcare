package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

public interface SttTotalService {
	//수신
	List<Map<String, Object>> getInCallStat(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getInCallDtl(Map<String, Object> map) throws Exception;
	Map<String, Object> getInCallDtlCnt(Map<String, Object> map) throws Exception;

	//포기
	List<Map<String, Object>> getAbandonStat(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getAbandonDtl(Map<String, Object> map) throws Exception;
	Map<String, Object> getAbandonDtlCnt(Map<String, Object> map) throws Exception;

	//유비케어용 포기호 엑셀 다운로드
	List<Map<String, Object>> getAbandonDtlExcel(Map<String, Object> map) throws Exception;


	//발신
	List<Map<String, Object>> getOutCallStat(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getOutCallDtl(Map<String, Object> map) throws Exception;
	Map<String, Object> getOutCallDtlCnt(Map<String, Object> map) throws Exception;
	
}
