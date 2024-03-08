package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

public interface SttUBTotalService {
	//총괄 현황
	List<Map<String, Object>> getAll(Map<String, Object> map) throws Exception;

	//총괄현황 본사만
	List<Map<String, Object>> getAllHead(Map<String, Object> map) throws Exception;

	//시간대별 접촉률 - 대리점
	List<Map<String, Object>> getTime(Map<String, Object> map) throws Exception;

	//시간대별 접촉률 - 상담원
	List<Map<String, Object>> getTimeAgent(Map<String, Object> map) throws Exception;

	// 상담원 실적현황
	List<Map<String, Object>> getUBAgentResult(Map<String, Object> map) throws Exception;

	// 큐별 재통화분석
	List<Map<String, Object>> getUBQueRecall(Map<String, Object> map) throws Exception;

	// 큐별 재통화리스트
	List<Map<String, Object>> getUBQueRecallList(Map<String, Object> map) throws Exception;

	// IVR 통계
	List<Map<String, Object>> getUBIvrList(Map<String, Object> map) throws Exception;

	// 통화시간분석
	List<Map<String, Object>> getUBCallTimeList(Map<String, Object> map) throws Exception;



	
}
