package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.vdc.ims.dao.CmmEtcDAO;
import com.vdc.ims.service.CmmEtcService;
import org.springframework.stereotype.Service;


@Service("cmmEtcService")
public class CmmEtcServiceImpl implements CmmEtcService {

    @Resource(name="cmmEtcDAO")
    private CmmEtcDAO cmmEtcDAO;


    //메인 대쉬보드
    @Override
    public List<Map<String, Object>> MainDash(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return cmmEtcDAO.MainDash(map);
    }
    //메인 대쉬보드
    @Override
    public List<Map<String, Object>> MainDashPrev(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return cmmEtcDAO.MainDashPrev(map);
    }




    //메뉴
    @Override
    public List<Map<String, Object>> getMenu(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return cmmEtcDAO.getMenu(map);
    }

	/**
	 * 서버 모니터링 관리
	*/
    @Override
    public List<Map<String, Object>> getSvr(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getSvr(map);
    }
    public void addSvr(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	cmmEtcDAO.addSvr(map);
    }
    public void edtSvr(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	cmmEtcDAO.edtSvr(map);
    }
    public void delSvr(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	cmmEtcDAO.delSvr(map);
    }
	/**
	 * 서버 모니터링 프로세스 등록
	*/
    @Override
    public List<Map<String, Object>> getProc(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getProc(map);
    }
    public void addProc(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	cmmEtcDAO.addProc(map);
    }
    public void edtProc(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	cmmEtcDAO.edtProc(map);
    }
    public void delProc(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	cmmEtcDAO.delProc(map);
    }


    /**
     * 녹취 청취 이력
     * */
    /*
    @Override
    public List<List<Object>> getListenHist(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getListenHist(map);
    }
    */
    @Override
    public List<Map<String, Object>> getListenHistTotCnt(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getListenHistTotCnt(map);
    }
    @Override
    public List<Map<String, Object>> getListenHistData(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getListenHistData(map);
    }




    /**
     * 녹취 다운로드 이력
     * */
    @Override
    public Map<String, Object> getDownHistCnt(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getDownHistCnt(map);
    }
    @Override
    public List<Map<String, Object>> getDownHist(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getDownHist(map);
    }
    /**
     * 계정변경 이력
     */
    @Override
    public Map<String, Object> getAccountChangeCnt(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getAccountChangeCnt(map);
    }
    @Override
    public List<Map<String, Object>> getAccountChange(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getAccountChange(map);
    }

    /**
     * 로그인 이력
     */
    @Override
    public Map<String, Object> getLoginHistCnt(Map<String, Object> map) throws Exception{
        return cmmEtcDAO.getLoginHistCnt(map);
    }
    @Override
    public List<Map<String, Object>> getLoginHist(Map<String, Object> map) throws Exception{
        return cmmEtcDAO.getLoginHist(map);
    }


    /**
     * 로그인 이력(건수)
     */
    @Override
    public Map<String, Object> getLoginHistTotalCnt(Map<String, Object> map) throws Exception{
        return cmmEtcDAO.getLoginHistTotalCnt(map);
    }
    @Override
    public List<Map<String, Object>> getLoginHistTotal(Map<String, Object> map) throws Exception{
        return cmmEtcDAO.getLoginHistTotal(map);
    }


    /**
     * 녹취 조회
     * */
    @Override
    public Map<String, Object> getRecordCnt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return cmmEtcDAO.getRecordCnt(map);
    }
    @Override
    public List<Map<String, Object>> getRecord(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return cmmEtcDAO.getRecord(map);
    }

	/*
	 * 총괄 현황 엑셀 다운로드
	 * */
    @Override
    public List<Map<String, Object>> ExcelStt(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.ExcelStt(map);
    }
    @Override
    public List<Map<String, Object>> ExcelYearStt(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.ExcelYearStt(map);
    }
    @Override
    public List<Map<String, Object>> ExcelYearTotalStt(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.ExcelYearTotalStt(map);
    }

	/*
	 * 개인 현황 엑셀 다운로드
	 * */
    @Override
    public Map<String, Object> WeekDay(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.WeekDay(map);
    }
    @Override
    public List<Map<String, Object>> Week(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.Week(map);
    }

    @Override
    public List<Map<String, Object>> getDnisList(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getDnisList(map);
    }

    @Override
    public List<Map<String, Object>> getDeptList(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getDeptList(map);
    }

    @Override
    public List<Map<String, Object>> getDivList(Map<String, Object> map) throws Exception {
        return cmmEtcDAO.getDivList(map);
    }
}
