package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.vdc.ims.dao.SttTotalDAO;
import com.vdc.ims.service.SttTotalService;
import org.springframework.stereotype.Service;

 
@Service("sttTotalService")
public class SttTotalServiceImpl implements SttTotalService {

    @Resource(name="sttTotalDAO")
    private SttTotalDAO sttTotalDAO;

    //수신
    @Override
    public List<Map<String, Object>> getInCallStat(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getInCallStat(map);
    }
    @Override
    public List<Map<String, Object>> getInCallDtl(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getInCallDtl(map);
    }
    @Override
    public Map<String, Object> getInCallDtlCnt(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getInCallDtlCnt(map);
    }
    
    //포기
    @Override
    public List<Map<String, Object>> getAbandonStat(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getAbandonStat(map);
    }
    @Override
    public List<Map<String, Object>> getAbandonDtl(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getAbandonDtl(map);
    } 
    @Override
    public Map<String, Object> getAbandonDtlCnt(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getAbandonDtlCnt(map);
    }

    //유비케어용 포기호 엑셀 다운로드
    @Override
    public List<Map<String, Object>> getAbandonDtlExcel(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getAbandonDtlExcel(map);
    }

    
    //발신
    @Override
    public List<Map<String, Object>> getOutCallStat(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getOutCallStat(map);
    }
    @Override
    public List<Map<String, Object>> getOutCallDtl(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getOutCallDtl(map);
    } 
    @Override
    public Map<String, Object> getOutCallDtlCnt(Map<String, Object> map) throws Exception {
        return sttTotalDAO.getOutCallDtlCnt(map);
    } 
    
}
