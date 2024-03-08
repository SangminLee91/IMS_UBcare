package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.vdc.ims.dao.SttRecDAO;
import com.vdc.ims.service.SttRecService;
import org.springframework.stereotype.Service;

 
@Service("sttRecService")
public class SttRecServiceImpl implements SttRecService {

    @Resource(name="sttRecDAO")
    private SttRecDAO sttRecDAO;

    @Override
    public List<Map<String, Object>> getSttRec(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return sttRecDAO.getSttRec(map);
    }
}
