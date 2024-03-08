package com.vdc.ims.serviceImpl;

import java.io.File;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.common.util.MultipartFileUpload;
import com.vdc.ims.common.util.StringUtil;
import com.vdc.ims.dao.MngIvrDAO;
import com.vdc.ims.service.MngIvrService;
import org.springframework.stereotype.Service;

 
@Service("mngIvrService")
public class MngIvrServiceImpl implements MngIvrService {

    @Resource(name="mngIvrDAO")
    private MngIvrDAO mngIvrDAO;
    
    @Resource(name="file")
    private MultipartFileUpload fileUtils;

    //음원 목록
    @Override
    public List<Map<String, Object>> VoiceList(Map<String, Object> map) throws Exception {
        return mngIvrDAO.VoiceList(map);
    }
    //음원 ServiceID 검사
    @Override
    public List<Map<String, Object>> ServiceIDCheck(Map<String, Object> map) throws Exception {
        return mngIvrDAO.ServiceIDCheck(map);
    }

    //ServiceFileReg
    @Override
    public void ServiceTTSReg(Map<String, Object> map, HttpSession session, HttpServletRequest request) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	
    	String path = this.getClass().getClassLoader().getResource("").getPath();
    	String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		fullPath = pathArr[0];
		String destFileName= StringUtil.getRandomString()+".wav";
		String srcFileName=fullPath+File.separatorChar +session.getAttribute("Emp_No")+".wav";
//		log.info("ServiceTTSReg src : "+srcFileName);
//		log.info("ServiceTTSReg dest : ftp->"+destFileName);
		//fileUtils.ttsFileUpload(srcFileName, destFileName);

		//여기서 DB저장
		map.put("ORIGINAL_FILE_NAME", destFileName);
    	
    	mngIvrDAO.ServiceTTSReg(map);
    }
    //ServiceFileAdd
    @Override
    public void ServiceFileAdd(Map<String, Object> map, HttpSession session, HttpServletRequest request) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        String FilePath="";
    	//mngIvrDAO.ServiceFileAdd(fileUtils.parseInsertFileInfo(FilePath, map, request));
        mngIvrDAO.ServiceFileAdd(map);
    }
    //ServiceFileDel
    @Override
    public void ServiceFileDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	mngIvrDAO.ServiceFileDel(map);
    }
    //ServiceDescUpdate
    @Override
    public void ServiceDescUpdate(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	mngIvrDAO.ServiceDescUpdate(map);
    }
    //ServiceFileUpdate
    @Override
    public void ServiceFileUpdate(Map<String, Object> map, HttpSession session, HttpServletRequest request) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	String FilePath="";
    	mngIvrDAO.ServiceFileUpdate(fileUtils.parseInsertFileInfo(FilePath, map, request));
    }

    @Override
    public Map<String, Object> ServiceMaxPrompt(Map<String, Object> map) throws Exception {
        return mngIvrDAO.ServiceMaxPrompt(map);
    }


    //HolidaySetList
    @Override
    public List<Map<String, Object>> HolidaySetList(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mngIvrDAO.HolidaySetList(map);
    }
    
    //HolidayList
    @Override
  	public List<Map<String, Object>> HolidayList(Map<String, Object> map) throws Exception{
  		return mngIvrDAO.HolidayList(map);
  	}
    //HolidaySetAdd
    @Override
    public void HolidaySetAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.HolidaySetAdd(map);
    }
    //HolidaySetUpdate
    @Override
    public void HolidaySetUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.HolidaySetUpdate(map);
    }
    //HolidaySetDel
    @Override
    public void HolidaySetDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.HolidaySetDel(map);
    }
    
    //HolidayAdd
    @Override
    public void HolidayAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.HolidayAdd(map);
    }
    //HolidayUpdate
    @Override
    public void HolidayUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.HolidayUpdate(map);
    }
    //HolidayDel
    @Override
    public void HolidayDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.HolidayDel(map);
    }
    
    //WorkhourSetList
    @Override
    public List<Map<String, Object>> WorkhourSetList(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mngIvrDAO.WorkhourSetList(map);
    }
    
    //WorkhourList
    @Override
    public List<Map<String, Object>> WorkhourList(Map<String, Object> map) throws Exception{
    	return mngIvrDAO.WorkhourList(map);
    }
    
    //WorkhourSetAdd
    @Override
    public void WorkhourSetAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.WorkhourSetAdd(map);
    }
    //WorkhourSetUpdate
    @Override
    public void WorkhourSetUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.WorkhourSetUpdate(map);
    }
    //WorkhourSetDel
    @Override
    public void WorkhourSetDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.WorkhourSetDel(map);
    }
    
    //WorkhourAdd
    @Override
    public void WorkhourAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.WorkhourAdd(map);
    }
    //WorkhourUpdate
    @Override
    public void WorkhourUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.WorkhourUpdate(map);
    }
    //WorkhourDel
    @Override
    public void WorkhourDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.WorkhourDel(map);
    }
    
    //NoticeList
    @Override
    public List<Map<String, Object>> NoticeList(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mngIvrDAO.NoticeList(map);
    }
    //NoticeAdd
    @Override
    public void NoticeAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.NoticeAdd(map);
    }
    //NoticeUpdate
    @Override
    public void NoticeUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.NoticeUpdate(map);
    }
    //NoticeDel
    @Override
    public void NoticeDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.NoticeDel(map);
    }
    
    //RouteList - 라우트는 권한에 따른 Select가 필요없다. 이유는 다른부서로 라우팅이 되어야 할 일도 있다.
    @Override
    public List<Map<String, Object>> RouteList(Map<String, Object> map) throws Exception{
    	return mngIvrDAO.RouteList(map);
    }
    //RouteAdd
    @Override
    public void RouteAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.RouteAdd(map);
    }
    //RouteUpdate
    @Override
    public void RouteUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.RouteUpdate(map);
    }
    //RouteDel
    @Override
    public void RouteDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.RouteDel(map);
    }
    
    //MenuSetList - 메뉴는 권한에 따른 Select가 다른부서의 메뉴로 가야 할수도?
    @Override
    public List<Map<String, Object>> MenuSetList(Map<String, Object> map) throws Exception{
    	return mngIvrDAO.MenuSetList(map);
    }
    
    //MenuList
    @Override
  	public List<Map<String, Object>> MenuList(Map<String, Object> map) throws Exception{
  		return mngIvrDAO.MenuList(map);
  	}
    //MenuSetAdd
    @Override
    public void MenuSetAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.MenuSetAdd(map);
    }
    //MenuSetUpdate
    @Override
    public void MenuSetUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.MenuSetUpdate(map);
    }
    //MenuSetDel
    @Override
    public void MenuSetDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.MenuSetDel(map);
    }
    
    //MenuAdd
    @Override
    public void MenuAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.MenuAdd(map);
    }
    //MenuUpdate
    @Override
    public void MenuUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.MenuUpdate(map);
    }
    //MenuDel
    @Override
    public void MenuDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.MenuDel(map);
    }
    
    //ScenarioList
    @Override
    public List<Map<String, Object>> ScenarioList(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mngIvrDAO.ScenarioList(map);
    }
    //ScenarioAdd
    @Override
    public void ScenarioAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.ScenarioAdd(map);
    }
    //ScenarioUpdate
    @Override
    public void ScenarioUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.ScenarioUpdate(map);
    }
    //ScenarioDel
    @Override
    public void ScenarioDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.ScenarioDel(map);
    }
    
    //DNISList - DNIS는 권한에 따른 Select가 필요없다. 이유는 다른 DNIS로 라우팅이 되어야 할 일도 있다.
    @Override
    public List<Map<String, Object>> DNISList(Map<String, Object> map) throws Exception{
    	return mngIvrDAO.DNISList(map);
    }
    //DNISAdd
    @Override
    public void DNISAdd(Map<String, Object> map) throws Exception {
    	mngIvrDAO.DNISAdd(map);
    }
    //DNISUpdate
    @Override
    public void DNISUpdate(Map<String, Object> map) throws Exception {
    	mngIvrDAO.DNISUpdate(map);
    }
    //DNISDel
    @Override
    public void DNISDel(Map<String, Object> map) throws Exception {
    	mngIvrDAO.DNISDel(map);
    }
    
    //getBlackList
    @Override
    public List<Map<String, Object>> getBlackList(Map<String, Object> map) throws Exception{
    	return mngIvrDAO.getBlackList(map);
    }
    @Override
    public void addBlackList(Map<String, Object> map) throws Exception {
    	mngIvrDAO.addBlackList(map);
    }
    @Override
    public void delBlackList(Map<String, Object> map) throws Exception {
    	mngIvrDAO.delBlackList(map);
    }


}
