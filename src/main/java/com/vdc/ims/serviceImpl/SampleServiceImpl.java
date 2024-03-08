package com.vdc.ims.serviceImpl;

import com.vdc.ims.dao.SampleDao;
import com.vdc.ims.service.SampleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import com.vdc.ims.common.util.MultipartFileUpload;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    @Resource(name="sampleDao")
    private SampleDao sampleDao;


    @Override
    public Map<String, Object> SampleGet(Map<String, Object> map) throws Exception {
        return sampleDao.SampleGet(map);
    }

    @Override
    public Map<String, Object> SampleGet2(Map<String, Object> map) throws Exception {
        return sampleDao.SampleGet2(map);
    }

}
