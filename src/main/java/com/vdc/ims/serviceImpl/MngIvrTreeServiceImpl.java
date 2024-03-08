package com.vdc.ims.serviceImpl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vdc.ims.dao.MngIvrTreeDAO;
import com.vdc.ims.service.MngIvrTreeService;
import org.springframework.stereotype.Service;

@Service("mngIvrTreeService")
public class MngIvrTreeServiceImpl implements MngIvrTreeService {

    @Resource(name="mngIvrTreeDAO")
    private MngIvrTreeDAO mngIvrTreeDAO;

    /*
     * 20210623 for scenario tree
     */
    //Scenario New get
    public Map<String, Object> getScenarioNew(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mngIvrTreeDAO.getScenarioNew(map);
    }
    //Scenario New get last
    public Map<String, Object> getLastScenarioNew(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mngIvrTreeDAO.getLastScenarioNew(map);
    }
    //ScenarioList new
    public List<Map<String, Object>> ScenarioNewList(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mngIvrTreeDAO.ScenarioNewList(map);
    }
    //ScenarioList new
    public List<Map<String, Object>> ScenarioNewListSlim(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mngIvrTreeDAO.ScenarioNewListSlim(map);
    }
    //ScenarioAdd new
    public void ScenarioNewAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioNewAdd(map);
    }
    //ScenarioUpdate new
    public void ScenarioNewUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioNewUpdate(map);
    }
    //Scenario next update
    public void ScenarioNewNextUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioNewNextUpdate(map);
    }
    //Scenario next50 update
    public void ScenarioNewNext50Update(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioNewNext50Update(map);
    }
    //ScenarioDel new
    public void ScenarioNewDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioNewDel(map);
    }

    //ScenarioWorkhour
    public List<Map<String, Object>> ScenarioWorkhourList(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.ScenarioWorkhourList(map);
    }
    public Map<String, Object> getLastScenarioWorkhour(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getLastScenarioWorkhour(map);
    }
    //ScenarioWorkhour add
    public void ScenarioWorkhourAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioWorkhourAdd(map);
    }
    //ScenarioWorkhour update
    public void ScenarioWorkhourUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioWorkhourUpdate(map);
    }
    //ScenarioWorkhour next update
    public void ScenarioWorkhourNextUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioWorkhourNextUpdate(map);
    }
    //ScenarioWorkhour next50 update
    public void ScenarioWorkhourNext50Update(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioWorkhourNext50Update(map);
    }
    //ScenarioWorkhour del
    public void ScenarioWorkhourDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioWorkhourDel(map);
    }

    //ScenarioMenu get
    public Map<String, Object> getScenarioMenu(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getScenarioMenu(map);
    }
    public Map<String, Object> getLastScenarioMenu(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getLastScenarioMenu(map);
    }
    //ScenarioMenu add
    public void ScenarioMenuAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuAdd(map);
    }
    //ScenarioMenu update
    public void ScenarioMenuUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuUpdate(map);
    }
    //ScenarioMenu del
    public void ScenarioMenuDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuDel(map);
    }


    //ScenarioMenuSub
    public List<Map<String, Object>> ScenarioMenuSubList(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.ScenarioMenuSubList(map);
    }
    //ScenarioMenuSub add
    public void ScenarioMenuSubAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuSubAdd(map);
    }
    //ScenarioMenuSub update
    public void ScenarioMenuSubUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuSubUpdate(map);
    }
    //ScenarioMenuSub next update
    public void ScenarioMenuSubNextUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuSubNextUpdate(map);
    }
    //ScenarioMenuSub next50 update
    public void ScenarioMenuSubNext50Update(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuSubNext50Update(map);
    }
    //ScenarioMenuSub del
    public void ScenarioMenuSubDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuSubDel(map);
    }

    //ScenarioRoute get
    public Map<String, Object> getScenarioRoute(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getScenarioRoute(map);
    }
    //ScenarioRoute add
    public void ScenarioRouteAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioRouteAdd(map);
    }
    //ScenarioRoute update
    public void ScenarioRouteUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioRouteUpdate(map);
    }
    //ScenarioRoute del
    public void ScenarioRouteDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioRouteDel(map);
    }


    //ScenarioOvercall
    public List<Map<String, Object>> ScenarioOvercallList(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.ScenarioOvercallList(map);
    }
    public Map<String, Object> getLastScenarioOvercall(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getLastScenarioOvercall(map);
    }
    //ScenarioOvercall add
    public void ScenarioOvercallAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioOvercallAdd(map);
    }
    //ScenarioOvercall update
    public void ScenarioOvercallUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioOvercallUpdate(map);
    }
    //ScenarioOvercall next update
    public void ScenarioOvercallNextUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioOvercallNextUpdate(map);
    }
    //ScenarioOvercall next50 update
    public void ScenarioOvercallNext50Update(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioOvercallNext50Update(map);
    }
    //ScenarioOvercall del
    public void ScenarioOvercallDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioOvercallDel(map);
    }

    //ScenarioDtmf get
    public Map<String, Object> getScenarioDtmf(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getScenarioDtmf(map);
    }
    public Map<String, Object> getLastScenarioDtmf(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getLastScenarioDtmf(map);
    }
    //ScenarioDtmf add
    public void ScenarioDtmfAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioDtmfAdd(map);
    }
    //ScenarioDtmf update
    public void ScenarioDtmfUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioDtmfUpdate(map);
    }
    //ScenarioDtmf next update
    public void ScenarioDtmfNextUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioDtmfNextUpdate(map);
    }
    //ScenarioDtmf next50 update
    public void ScenarioDtmfNext50Update(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioDtmfNext50Update(map);
    }
    //ScenarioDtmf del
    public void ScenarioDtmfDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioDtmfDel(map);
    }


    //ScenarioCallback get
    public Map<String, Object> getScenarioCallback(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getScenarioCallback(map);
    }
    public Map<String, Object> getLastScenarioCallback(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getLastScenarioCallback(map);
    }
    //ScenarioCallback add
    public void ScenarioCallbackAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioCallbackAdd(map);
    }
    //ScenarioCallback update
    public void ScenarioCallbackUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioCallbackUpdate(map);
    }
    //ScenarioCallback next update
    public void ScenarioCallbackNextUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioCallbackNextUpdate(map);
    }
    //ScenarioCallback next50 update
    public void ScenarioCallbackNext50Update(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioCallbackNext50Update(map);
    }
    //ScenarioCallback del
    public void ScenarioCallbackDel(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioCallbackDel(map);
    }

    //ScenarioNotice get
    public Map<String, Object> getScenarioNotice(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.getScenarioNotice(map);
    }

    //RouteNewList - 라우트는 권한에 따른 Select가 필요없다. 이유는 다른부서로 라우팅이 되어야 할 일도 있다.
    public List<Map<String, Object>> RouteNewList(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.RouteNewList(map);
    }
    //RouteNewAdd
    public void RouteNewAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.RouteNewAdd(map);
    }
    //RouteNewUpdate
    public void RouteNewUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.RouteNewUpdate(map);
    }

    //RouteNewAdd
    public void RouteNewEmergencySet(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.RouteEmergencySet(map);
    }
    //RouteNewAdd
    public void ScenarioNewEmergencySet(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioEmergencySet(map);
    }

    //Scenario Callback batch list
    public List<Map<String, Object>> ScenarioCallbackList(Map<String, Object> map) throws Exception{
        return mngIvrTreeDAO.CallbackList(map);
    }
    //Scenario Callback batch update
    public void ScenarioCallbackBatchUpdate(Map<String, Object> map) throws Exception{
        mngIvrTreeDAO.CallbackBatchUpdate(map);
    }
    //ScenarioMenuSub Slim add
    public void ScenarioMenuSubSlimAdd(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuSubSlimAdd(map);
    }
    //ScenarioMenuSub Slim update
    public void ScenarioMenuSubSlimUpdate(Map<String, Object> map) throws Exception {
        mngIvrTreeDAO.ScenarioMenuSubSlimUpdate(map);
    }

    //ScenarioList new load by Dept
    public List<Map<String, Object>> ScenarioNewListSlimByDept(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mngIvrTreeDAO.ScenarioNewListSlimByDept(map);
    }

}
