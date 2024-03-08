package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.vdc.ims.dao.SttCtiDAO;
import com.vdc.ims.service.SttCtiService;
import org.springframework.stereotype.Service;

 
@Service("sttCtiService")
public class SttCtiServiceImpl implements SttCtiService {

    @Resource(name="sttCtiDAO")
    private SttCtiDAO sttCtiDAO;

    @Override
    public List<Map<String, Object>> getAgentData(Map<String, Object> map) throws Exception {
        return sttCtiDAO.getAgentData(map);
    }
    
    @Override
    public List<Map<String, Object>> getAgentHistData(Map<String, Object> map) throws Exception {
        return sttCtiDAO.getAgentHistData(map);
    } 
    @Override
    public List<Map<String, Object>> getAgentResultData(Map<String, Object> map) throws Exception {
        return sttCtiDAO.getAgentResultData(map);
    } 
    @Override
    public List<Map<String, Object>> getAgentCallData(Map<String, Object> map) throws Exception {
        return sttCtiDAO.getAgentCallData(map);
    } 
    @Override
    public List<Map<String, Object>> getAgentStatusData(Map<String, Object> map) throws Exception {
        return sttCtiDAO.getAgentStatusData(map);
    } 

    @Override
    public List<Map<String, Object>> getQueueStatsData(Map<String, Object> map) throws Exception {
        return sttCtiDAO.getQueueStatsData(map);
    } 

    @Override
    public List<Map<String, Object>> sttAgentQueData(Map<String, Object> map) throws Exception {
        return sttCtiDAO.sttAgentQueData(map);
    }    
}
