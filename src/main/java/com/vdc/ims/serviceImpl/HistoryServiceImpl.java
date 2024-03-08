package com.vdc.ims.serviceImpl;

import com.vdc.ims.dao.HistoryDAO;
import com.vdc.ims.service.HistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Service("historyService")
public class HistoryServiceImpl implements HistoryService {

    @Resource(name="historyDAO")
    private HistoryDAO historyDAO;


    @Override
    public List<Map<String, Object>> getHistTotCnt(Map<String, Object> map) throws Exception {
        return historyDAO.getHistTotCnt(map);
    }
    @Override
    public List<Map<String, Object>> getHistSrchCnt(Map<String, Object> map) throws Exception {
        return historyDAO.getHistSrchCnt(map);
    }
    @Override
    public List<Map<String, Object>> getHistData(Map<String, Object> map) throws Exception {
        return historyDAO.getHistData(map);
    }
    
    public void addHist(Map<String, Object> map) throws Exception {
        historyDAO.addHist(map);
    }

}
