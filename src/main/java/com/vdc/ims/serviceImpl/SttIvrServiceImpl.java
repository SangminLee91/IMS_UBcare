package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.vdc.ims.dao.SttIvrDAO;
import com.vdc.ims.service.SttIvrService;
import org.springframework.stereotype.Service;

 
@Service("sttIvrService")
public class SttIvrServiceImpl implements SttIvrService {

    @Resource(name="sttIvrDAO")
    private SttIvrDAO sttIvrDAO;

    @Override
    public List<Map<String, Object>> getServiceStat(Map<String, Object> map) throws Exception {
        return sttIvrDAO.getServiceStat(map);
    }
    
    @Override
    public List<Map<String, Object>> getMenuStat(Map<String, Object> map) throws Exception {
        return sttIvrDAO.getMenuStat(map);
    }
    
    @Override
    public List<Map<String, Object>> getServiceStatbyDNIS(Map<String, Object> map) throws Exception {
        return sttIvrDAO.getServiceStatbyDNIS(map);
    }
    
    @Override
    public List<Map<String, Object>> getCallbackList(Map<String, Object> map) throws Exception {
        return sttIvrDAO.getCallbackList(map);
    }
    
    @Override
    public List<Map<String, Object>> getCallbackStat(Map<String, Object> map) throws Exception {
        return sttIvrDAO.getCallbackStat(map);
    }

    @Override
    public List<Map<String, Object>> getCallbackType(Map<String, Object> map) throws Exception {
        return sttIvrDAO.getCallbackType(map);
    }
}
