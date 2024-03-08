package com.vdc.ims.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface SampleService {
    Map<String,Object> SampleGet(Map<String, Object> map) throws Exception;
    Map<String,Object> SampleGet2(Map<String, Object> map) throws Exception;

}
