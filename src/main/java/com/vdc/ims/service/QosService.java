package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

public interface QosService {
	//Subscribers Data
	List<Map<String, Object>> getSubscribers(Map<String, Object> map) throws Exception;
	//Subscriber r-value data
	List<Map<String, Object>> getSubscribersQOS(Map<String, Object> map) throws Exception;	
}
