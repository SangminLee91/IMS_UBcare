package com.vdc.ims.serviceImpl;

import com.vdc.ims.dao.SttUBTotalDAO;
import com.vdc.ims.service.SttUBTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("sttUBTotalService")
public class SttUBTotalServiceImpl implements SttUBTotalService {

    @Resource(name="sttUBTotalDAO")
    private SttUBTotalDAO sttUBTotalDAO;

    //총괄 현황
    @Override
    public List<Map<String, Object>> getAll(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getAll(map);
    }

    //총괄 현황 본사만
    @Override
    public List<Map<String, Object>> getAllHead(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getAllHead(map);
    }

    //시간대별 접촉률 - 대리점
    @Override
    public List<Map<String, Object>> getTime(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getTime(map);
    }

    //시간대별 접촉률 - 상담원
    @Override
    public List<Map<String, Object>> getTimeAgent(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getTimeAgent(map);
    }

    //상담원 실적 현황
    @Override
    public List<Map<String, Object>> getUBAgentResult(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getUBAgentResult(map);
    }

    // 큐별 재통화분석
    @Override
    public List<Map<String, Object>> getUBQueRecall(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getUBQueRecall(map);
    }

    // 큐별 재통화리스트
    @Override
    public List<Map<String, Object>> getUBQueRecallList(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getUBQueRecallList(map);
    }

    // IVR 통계
    @Override
    public List<Map<String, Object>> getUBIvrList(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getUBIvrList(map);
    }

    // 통화시간분석
    @Override
    public List<Map<String, Object>> getUBCallTimeList(Map<String, Object> map) throws Exception {
        return sttUBTotalDAO.getUBCallTimeList(map);
    }

}
