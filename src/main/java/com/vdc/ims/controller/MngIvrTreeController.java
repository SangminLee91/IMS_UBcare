package com.vdc.ims.controller;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.MngIvrTreeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MngIvrTreeController {

    @Resource(name="mngIvrTreeService")
    private MngIvrTreeService mngIvrTreeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/mng/ivr/new/")
    public ModelAndView ivrnew() throws Exception{
        ModelAndView mv = new ModelAndView("view/mng/ivr/ivr_new");
        return mv;
    }


    //콜백 관리
    @RequestMapping(value="/mng/ivr/callback/")
    public ModelAndView ivrcallback(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("view/mng/ivr/callback_batch");
        return mv;
    }
    //시나리오 공지
    @RequestMapping(value="/mng/ivr/emergency/")
    public ModelAndView ivremergency(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("view/mng/ivr/scenario_emergency");
        return mv;
    }

    /**
     * 20210623 : Scenario Tree
     *
     * 시나리오관리 new
     */

    //시나리오 하나 가져오기
    @RequestMapping(value="/mng/ivr/getscenarionew")
    public ModelAndView getScenarioNew(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> scenario = mngIvrTreeService.getScenarioNew(commandMap.getMap(),session);
        mv.addObject("Scenario", scenario);

        return mv;
    }
    //시나리오 마지막 입력 데이터 가져오기
    @RequestMapping(value="/mng/ivr/getlastscenarionew")
    public ModelAndView getLastScenarioNew(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> scenario = mngIvrTreeService.getLastScenarioNew(commandMap.getMap(),session);
        mv.addObject("Scenario", scenario);

        return mv;
    }
    @RequestMapping(value="/mng/ivr/scenarionewlistslim")
    public ModelAndView ScenarioNewListSlim(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> scenario = mngIvrTreeService.ScenarioNewListSlim(commandMap.getMap(),session);
        mv.addObject("Scenario", scenario);

        return mv;
    }
    @RequestMapping(value="/mng/ivr/scenarionewlist")
    public ModelAndView ScenarioNewList(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> scenario = mngIvrTreeService.ScenarioNewList(commandMap.getMap(),session);
        mv.addObject("Scenario", scenario);

        return mv;
    }
    //시나리오 추가
    @RequestMapping(value="/mng/ivr/scenarionewadd")
    public ModelAndView ScenarioNewAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioNewAdd(commandMap.getMap());

        return mv;
    }

    @RequestMapping(value="/mng/ivr/scenarionewedit")
    public ModelAndView ScenarioNewUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioNewUpdate(commandMap.getMap());

        return mv;
    }

    //시나리오 - sc_next 수정
    @RequestMapping(value="/mng/ivr/scenarionewnextedit")
    public ModelAndView ScenarioNewNextUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioNewNextUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 -sc_next 없음 수정
    @RequestMapping(value="/mng/ivr/scenarionewnext50edit")
    public ModelAndView ScenarioNewNext50Update(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioNewNext50Update(commandMap.getMap());

        return mv;
    }

    @RequestMapping(value="/mng/ivr/scenarionewdel")
    public ModelAndView ScenarioNewDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioNewDel(commandMap.getMap());

        return mv;
    }

    /**
     * 근무시간시나리오관리
     */
    //근무시간 시나리오 불러오기
    @RequestMapping(value="/mng/ivr/scenarioworkhourlist")
    public ModelAndView ScenarioWorkhourList(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> workhour = mngIvrTreeService.ScenarioWorkhourList(commandMap.getMap());
        mv.addObject("Workhour", workhour);

        return mv;
    }
    //근무시간 시나리오 마지막 입력 데이터 가져오기
    @RequestMapping(value="/mng/ivr/getlastscenarioworkhour")
    public ModelAndView getLastScenarioWorkhour(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> scenario = mngIvrTreeService.getLastScenarioWorkhour(commandMap.getMap());
        mv.addObject("Workhour", scenario);

        return mv;
    }
    //근무시간 시나리오 추가
    @RequestMapping(value="/mng/ivr/scenarioworkhouradd")
    public ModelAndView ScenarioWorkhourAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioWorkhourAdd(commandMap.getMap());

        return mv;
    }
    //근무시간 시나리오 수정
    @RequestMapping(value="/mng/ivr/scenarioworkhouredit")
    public ModelAndView ScenarioWorkhourUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioWorkhourUpdate(commandMap.getMap());

        return mv;
    }
    //근무시간 시나리오 - sc_next 수정
    @RequestMapping(value="/mng/ivr/scenarioworkhournextedit")
    public ModelAndView ScenarioWorkhourNextUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioWorkhourNextUpdate(commandMap.getMap());

        return mv;
    }
    //근무시간 시나리오 -sc_next 없음 수정
    @RequestMapping(value="/mng/ivr/scenarioworkhournext50edit")
    public ModelAndView ScenarioWorkhourNext50Update(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioWorkhourNext50Update(commandMap.getMap());

        return mv;
    }
    //근무시간 시나리오 삭제
    @RequestMapping(value="/mng/ivr/scenarioworkhourdel")
    public ModelAndView ScenarioWorkhourDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioWorkhourDel(commandMap.getMap());

        return mv;
    }

    /**
     * 시나리오 메뉴 관리
     */
    //시나리오 메뉴 불러오기
    @RequestMapping(value="/mng/ivr/getscenariomenu")
    public ModelAndView getScenarioMenu(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> menu = mngIvrTreeService.getScenarioMenu(commandMap.getMap());
        mv.addObject("Menu", menu);

        return mv;
    }
    @RequestMapping(value="/mng/ivr/getlastscenariomenu")
    public ModelAndView getLastScenarioMenu(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> menu = mngIvrTreeService.getLastScenarioMenu(commandMap.getMap());
        mv.addObject("Menu", menu);

        return mv;
    }
    //시나리오메뉴 추가
    @RequestMapping(value="/mng/ivr/scenariomenuadd")
    public ModelAndView ScenarioMenuAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuAdd(commandMap.getMap());

        return mv;
    }
    //시나리오메뉴 수정
    @RequestMapping(value="/mng/ivr/scenariomenuedit")
    public ModelAndView ScenarioMenuUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오메뉴 삭제
    @RequestMapping(value="/mng/ivr/scenariomenudel")
    public ModelAndView ScenarioMenuDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuDel(commandMap.getMap());

        return mv;
    }

    /**
     * 시나리오 서브 메뉴 관리
     */
    //시나리오 서브 메뉴 불러오기
    @RequestMapping(value="/mng/ivr/scenariomenusublist")
    public ModelAndView ScenarioMenuSubList(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> menusub = mngIvrTreeService.ScenarioMenuSubList(commandMap.getMap());
        mv.addObject("Menusub", menusub);

        return mv;
    }

    //시나리오 서브 메뉴 추가
    @RequestMapping(value="/mng/ivr/scenariomenusubadd")
    public ModelAndView ScenarioMenuSubAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuSubAdd(commandMap.getMap());

        return mv;
    }
    //시나리오 서브 메뉴 수정
    @RequestMapping(value="/mng/ivr/scenariomenusubedit")
    public ModelAndView ScenarioMenuSubUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuSubUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 서브 메뉴 - sc_next 수정
    @RequestMapping(value="/mng/ivr/scenariomenusubnextedit")
    public ModelAndView ScenarioMenuSubNextUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuSubNextUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 서브 메뉴 -sc_next 없음 수정
    @RequestMapping(value="/mng/ivr/scenariomenusubnext50edit")
    public ModelAndView ScenarioMenuSubNext50Update(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuSubNext50Update(commandMap.getMap());

        return mv;
    }
    //시나리오 서브 메뉴 삭제
    @RequestMapping(value="/mng/ivr/scenariomenusubdel")
    public ModelAndView ScenarioMenuSubDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuSubDel(commandMap.getMap());

        return mv;
    }

    /**
     * 시나리오 라우트 관리
     */
    //시나리오 라우트 불러오기
    @RequestMapping(value="/mng/ivr/getscenarioroute")
    public ModelAndView getScenarioRoute(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> route = mngIvrTreeService.getScenarioRoute(commandMap.getMap());
        mv.addObject("Route", route);

        return mv;
    }
    //시나리오 라우트 추가
    @RequestMapping(value="/mng/ivr/scenariorouteadd")
    public ModelAndView ScenarioRouteAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioRouteAdd(commandMap.getMap());

        return mv;
    }
    //시나리오 라우트 수정
    @RequestMapping(value="/mng/ivr/scenariorouteedit")
    public ModelAndView ScenarioRouteUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioRouteUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 라우트 삭제
    @RequestMapping(value="/mng/ivr/scenarioroutedel")
    public ModelAndView ScenarioRouteDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioRouteDel(commandMap.getMap());

        return mv;
    }

    /**
     * 시나리오 오버콜 관리
     */
    //시나리오 오버콜 불러오기
    @RequestMapping(value="/mng/ivr/scenarioovercalllist")
    public ModelAndView ScenarioOvercallList(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> overcall = mngIvrTreeService.ScenarioOvercallList(commandMap.getMap());
        mv.addObject("Overcall", overcall);

        return mv;
    }
    @RequestMapping(value="/mng/ivr/getlastscenarioovercall")
    public ModelAndView getLastScenarioOvercall(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> menu = mngIvrTreeService.getLastScenarioOvercall(commandMap.getMap());
        mv.addObject("Overcall", menu);

        return mv;
    }
    //시나리오 오버콜 추가
    @RequestMapping(value="/mng/ivr/scenarioovercalladd")
    public ModelAndView ScenarioOvercallAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioOvercallAdd(commandMap.getMap());

        return mv;
    }
    //시나리오 오버콜 수정
    @RequestMapping(value="/mng/ivr/scenarioovercalledit")
    public ModelAndView ScenarioOvercallUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioOvercallUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 오버콜 - sc_next 수정
    @RequestMapping(value="/mng/ivr/scenarioovercallnextedit")
    public ModelAndView ScenarioOvercallNextUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioOvercallNextUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 오버콜 -sc_next 없음 수정
    @RequestMapping(value="/mng/ivr/scenarioovercallnext50edit")
    public ModelAndView ScenarioOvercallNext50Update(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioOvercallNext50Update(commandMap.getMap());

        return mv;
    }
    //시나리오 오버콜 삭제
    @RequestMapping(value="/mng/ivr/scenarioovercalldel")
    public ModelAndView ScenarioOvercallDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioOvercallDel(commandMap.getMap());

        return mv;
    }


    /**
     * 시나리오 dtmf 관리
     */
    //시나리오 dtmf 불러오기
    @RequestMapping(value="/mng/ivr/getscenariodtmf")
    public ModelAndView getScenarioDtmf(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> dtmf= mngIvrTreeService.getScenarioDtmf(commandMap.getMap());
        mv.addObject("Dtmf", dtmf);

        return mv;
    }
    @RequestMapping(value="/mng/ivr/getlastscenariodtmf")
    public ModelAndView getLastScenarioDtmf(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> dtmf= mngIvrTreeService.getLastScenarioDtmf(commandMap.getMap());
        mv.addObject("Dtmf", dtmf);

        return mv;
    }
    //시나리오 dtmf 추가
    @RequestMapping(value="/mng/ivr/scenariodtmfadd")
    public ModelAndView ScenarioDtmfAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioDtmfAdd(commandMap.getMap());

        return mv;
    }
    //시나리오 dtmf 수정
    @RequestMapping(value="/mng/ivr/scenariodtmfedit")
    public ModelAndView ScenarioDtmfUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioDtmfUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 dtmf - sc_next 수정
    @RequestMapping(value="/mng/ivr/scenariodtmfnextedit")
    public ModelAndView ScenarioDtmfNextUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioDtmfNextUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 dtmf -sc_next 없음 수정
    @RequestMapping(value="/mng/ivr/scenariodtmfnext50edit")
    public ModelAndView ScenarioDtmfNext50Update(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioDtmfNext50Update(commandMap.getMap());

        return mv;
    }
    //시나리오 dtmf 삭제
    @RequestMapping(value="/mng/ivr/scenariodtmfdel")
    public ModelAndView ScenarioDtmfDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioDtmfDel(commandMap.getMap());

        return mv;
    }


    /**
     * 시나리오 callback 관리
     */
    //시나리오 callback 불러오기
    @RequestMapping(value="/mng/ivr/getscenariocallback")
    public ModelAndView getScenarioCallback(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> callback= mngIvrTreeService.getScenarioCallback(commandMap.getMap());
        mv.addObject("Callback", callback);

        return mv;
    }
    @RequestMapping(value="/mng/ivr/getlastscenariocallback")
    public ModelAndView getLastScenarioCallback(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> callback= mngIvrTreeService.getLastScenarioCallback(commandMap.getMap());
        mv.addObject("Callback", callback);

        return mv;
    }
    //시나리오 callback 추가
    @RequestMapping(value="/mng/ivr/scenariocallbackadd")
    public ModelAndView ScenarioCallbackAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioCallbackAdd(commandMap.getMap());

        return mv;
    }
    //시나리오 callback 수정
    @RequestMapping(value="/mng/ivr/scenariocallbackedit")
    public ModelAndView ScenarioCallbackUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioCallbackUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 callback - sc_next 수정
    @RequestMapping(value="/mng/ivr/scenariocallbacknextedit")
    public ModelAndView ScenarioCallbackNextUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioCallbackNextUpdate(commandMap.getMap());

        return mv;
    }
    //시나리오 callback -sc_next 없음 수정
    @RequestMapping(value="/mng/ivr/scenariocallbacknext50edit")
    public ModelAndView ScenarioCallbackNext50Update(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioCallbackNext50Update(commandMap.getMap());

        return mv;
    }
    //시나리오 callback 삭제
    @RequestMapping(value="/mng/ivr/scenariocallbackdel")
    public ModelAndView ScenarioCallbackDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioCallbackDel(commandMap.getMap());

        return mv;
    }


    /**
     * 시나리오 공지 관리
     */
    @RequestMapping(value="/mng/ivr/getscenarionotice")
    public ModelAndView getScenarioNotice(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> notice= mngIvrTreeService.getScenarioNotice(commandMap.getMap());
        mv.addObject("Notice", notice);

        return mv;
    }
    /**
     * 라우트 New 관리
     */
    //라우트 new 리스트
    @RequestMapping(value="/mng/ivr/routenewlist")
    public ModelAndView RouteNewList(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> route = mngIvrTreeService.RouteNewList(commandMap.getMap());
        mv.addObject("Route", route);

        return mv;
    }
    //라우트 new 추가
    @RequestMapping(value="/mng/ivr/routenewadd")
    public ModelAndView RouteNewAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.RouteNewAdd(commandMap.getMap());

        return mv;
    }
    //라우트 new 수정
    @RequestMapping(value="/mng/ivr/routenewedit")
    public ModelAndView RouteNewUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.RouteNewUpdate(commandMap.getMap());

        return mv;
    }

    /**
     * 긴급상황 관리
     */
    //라우트 긴급공지 추가
    @RequestMapping(value="/mng/ivr/routeemergencyset")
    public ModelAndView RouteNewEmergencySet(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.RouteNewEmergencySet(commandMap.getMap());

        return mv;
    }

    //시나리오 긴급공지 추가
    @RequestMapping(value="/mng/ivr/scenarioemergencyset")
    public ModelAndView ScenarioNewEmergencySet(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioNewEmergencySet(commandMap.getMap());

        return mv;
    }

    /**
     * 콜백 배치 관련
     */
    //콜백 전체 리스트
    @RequestMapping(value="/mng/ivr/scenariocallbackllist")
    public ModelAndView ScenarioCallbackList(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> callback = mngIvrTreeService.ScenarioCallbackList(commandMap.getMap());
        mv.addObject("Callback", callback);
        return mv;
    }
    //콜백 배치 업데이트
    @RequestMapping(value="/mng/ivr/scenariocallbackbatch")
    public ModelAndView ScenarioCallbackBatchUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioCallbackBatchUpdate(commandMap.getMap());

        return mv;
    }

    //시나리오 서브 메뉴 slim 추가
    @RequestMapping(value="/mng/ivr/scenariomenusubslimadd")
    public ModelAndView ScenarioMenuSubSlimAdd(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuSubSlimAdd(commandMap.getMap());

        return mv;
    }
    //시나리오 서브 메뉴 slim 수정
    @RequestMapping(value="/mng/ivr/scenariomenusubslimedit")
    public ModelAndView ScenarioMenuSubSlimUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        mngIvrTreeService.ScenarioMenuSubSlimUpdate(commandMap.getMap());

        return mv;
    }

    /**
     * 시나리오트리 구분하여 보기
     */
    @RequestMapping(value="/mng/ivr/scenarionewlistslimbydept")
    public ModelAndView ScenarioNewListSlimByDept(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> scenario = mngIvrTreeService.ScenarioNewListSlimByDept(commandMap.getMap(),session);
        mv.addObject("Scenario", scenario);

        return mv;
    }

}
