package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.vdc.ims.dao.QosDAO;
import com.vdc.ims.service.QosService;
import org.springframework.stereotype.Service;


@Service("qosService")
public class QosServiceImpl implements QosService {

    @Resource(name="qosDAO")
    private QosDAO qosDAO;

    //Subscribers Data
    @Override
    public List<Map<String, Object>> getSubscribers(Map<String, Object> map) throws Exception{
        return qosDAO.getSubscribers(map);
    } 
    //Subscriber r-value data
    @Override
    public List<Map<String, Object>> getSubscribersQOS(Map<String, Object> map) throws Exception{
        return qosDAO.getSubscribersQOS(map);
    }
}
