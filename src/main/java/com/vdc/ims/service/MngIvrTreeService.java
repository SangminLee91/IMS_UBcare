package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface MngIvrTreeService {

    /*
     * 20210623 for scenario tree
     */
    //Scenario new get
    Map<String, Object> getScenarioNew(Map<String, Object> map, HttpSession session) throws Exception;
    //Scenario new get last
    Map<String, Object> getLastScenarioNew(Map<String, Object> map, HttpSession session) throws Exception;
    //Scenario new List
    List<Map<String, Object>> ScenarioNewList(Map<String, Object> map, HttpSession session) throws Exception;
    //Scenario new List slim
    List<Map<String, Object>> ScenarioNewListSlim(Map<String, Object> map, HttpSession session) throws Exception;
    //ScenarioAdd new
    void ScenarioNewAdd(Map<String, Object> map) throws Exception;
    //ScenarioUpdate new
    void ScenarioNewUpdate(Map<String, Object> map) throws Exception;
    //Scenario next update
    void ScenarioNewNextUpdate(Map<String, Object> map) throws Exception;
    //Scenario next50 update
    void ScenarioNewNext50Update(Map<String, Object> map) throws Exception;
    //ScenarioDel new
    void ScenarioNewDel(Map<String, Object> map) throws Exception;

    //ScenarioWorkhour list
    List<Map<String, Object>> ScenarioWorkhourList(Map<String, Object> map) throws Exception;
    //ScenarioWorkhour last get
    Map<String, Object> getLastScenarioWorkhour(Map<String, Object> map) throws Exception;
    //ScenarioWorkhour add
    void ScenarioWorkhourAdd(Map<String, Object> map) throws Exception;
    //ScenarioWorkhour update
    void ScenarioWorkhourUpdate(Map<String, Object> map) throws Exception;
    //ScenarioWorkhour next update
    void ScenarioWorkhourNextUpdate(Map<String, Object> map) throws Exception;
    //ScenarioWorkhour next50 update
    void ScenarioWorkhourNext50Update(Map<String, Object> map) throws Exception;
    //ScenarioWorkhour del
    void ScenarioWorkhourDel(Map<String, Object> map) throws Exception;

    //ScenarioMenu get
    Map<String, Object> getScenarioMenu(Map<String, Object> map) throws Exception;
    Map<String, Object> getLastScenarioMenu(Map<String, Object> map) throws Exception;
    //ScenarioMenu add
    void ScenarioMenuAdd(Map<String, Object> map) throws Exception;
    //ScenarioMenu update
    void ScenarioMenuUpdate(Map<String, Object> map) throws Exception;
    //ScenarioMenu del
    void ScenarioMenuDel(Map<String, Object> map) throws Exception;

    //ScenarioMenuSub list
    List<Map<String, Object>> ScenarioMenuSubList(Map<String, Object> map) throws Exception;
    //ScenarioMenuSub add
    void ScenarioMenuSubAdd(Map<String, Object> map) throws Exception;
    //ScenarioMenuSub update
    void ScenarioMenuSubUpdate(Map<String, Object> map) throws Exception;
    //ScenarioMenuSub next update
    void ScenarioMenuSubNextUpdate(Map<String, Object> map) throws Exception;
    //ScenarioMenuSub next50 update
    void ScenarioMenuSubNext50Update(Map<String, Object> map) throws Exception;
    //ScenarioMenuSub del
    void ScenarioMenuSubDel(Map<String, Object> map) throws Exception;

    //ScenarioRoute get
    Map<String, Object> getScenarioRoute(Map<String, Object> map) throws Exception;
    //ScenarioRoute add
    void ScenarioRouteAdd(Map<String, Object> map) throws Exception;
    //ScenarioRoute update
    void ScenarioRouteUpdate(Map<String, Object> map) throws Exception;
    //ScenarioRoute del
    void ScenarioRouteDel(Map<String, Object> map) throws Exception;

    //ScenarioOvercall list
    List<Map<String, Object>> ScenarioOvercallList(Map<String, Object> map) throws Exception;
    Map<String, Object> getLastScenarioOvercall(Map<String, Object> map) throws Exception;
    //ScenarioOvercall add
    void ScenarioOvercallAdd(Map<String, Object> map) throws Exception;
    //ScenarioOvercall update
    void ScenarioOvercallUpdate(Map<String, Object> map) throws Exception;
    //ScenarioOvercall next update
    void ScenarioOvercallNextUpdate(Map<String, Object> map) throws Exception;
    //ScenarioOvercall next50 update
    void ScenarioOvercallNext50Update(Map<String, Object> map) throws Exception;
    //ScenarioOvercall del
    void ScenarioOvercallDel(Map<String, Object> map) throws Exception;

    //ScenarioDtmf get
    Map<String, Object> getScenarioDtmf(Map<String, Object> map) throws Exception;
    Map<String, Object> getLastScenarioDtmf(Map<String, Object> map) throws Exception;
    //ScenarioDtmf add
    void ScenarioDtmfAdd(Map<String, Object> map) throws Exception;
    //ScenarioDtmf update
    void ScenarioDtmfUpdate(Map<String, Object> map) throws Exception;
    //ScenarioDtmf next update
    void ScenarioDtmfNextUpdate(Map<String, Object> map) throws Exception;
    //ScenarioDtmf next50 update
    void ScenarioDtmfNext50Update(Map<String, Object> map) throws Exception;
    //ScenarioDtmf del
    void ScenarioDtmfDel(Map<String, Object> map) throws Exception;

    //ScenarioCallback get
    Map<String, Object> getScenarioCallback(Map<String, Object> map) throws Exception;
    Map<String, Object> getLastScenarioCallback(Map<String, Object> map) throws Exception;
    //ScenarioCallback add
    void ScenarioCallbackAdd(Map<String, Object> map) throws Exception;
    //ScenarioCallback update
    void ScenarioCallbackUpdate(Map<String, Object> map) throws Exception;
    //ScenarioCallback next update
    void ScenarioCallbackNextUpdate(Map<String, Object> map) throws Exception;
    //ScenarioCallback next50 update
    void ScenarioCallbackNext50Update(Map<String, Object> map) throws Exception;
    //ScenarioCallback del
    void ScenarioCallbackDel(Map<String, Object> map) throws Exception;

    //ScenarioNotice get
    Map<String, Object> getScenarioNotice(Map<String, Object> map) throws Exception;

    //Route New List
    List<Map<String, Object>> RouteNewList(Map<String, Object> map) throws Exception;
    //RouteNewAdd
    void RouteNewAdd(Map<String, Object> map) throws Exception;
    //RouteNewUpdate
    void RouteNewUpdate(Map<String, Object> map) throws Exception;

    //Route new Emergency
    void RouteNewEmergencySet(Map<String, Object> map) throws Exception;

    //Scenario new Emergency
    void ScenarioNewEmergencySet(Map<String, Object> map) throws Exception;

    //Scenario Callback batch list
    List<Map<String, Object>> ScenarioCallbackList(Map<String, Object> map) throws Exception;

    //Scenario Callback batch update
    void ScenarioCallbackBatchUpdate(Map<String, Object> map) throws Exception;

    //ScenarioMenuSub Slim add
    void ScenarioMenuSubSlimAdd(Map<String, Object> map) throws Exception;
    //ScenarioMenuSub Slim update
    void ScenarioMenuSubSlimUpdate(Map<String, Object> map) throws Exception;

    //Scenario new List slim by dept
    List<Map<String, Object>> ScenarioNewListSlimByDept(Map<String, Object> map, HttpSession session) throws Exception;

}
