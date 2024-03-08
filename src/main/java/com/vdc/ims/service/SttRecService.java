package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface SttRecService {
	List<Map<String, Object>> getSttRec(Map<String, Object> map, HttpSession session) throws Exception;
	
}
