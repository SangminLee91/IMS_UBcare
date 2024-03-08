package com.vdc.ims.controller;

import com.vdc.ims.service.AuthService;
import com.vdc.ims.service.CodeService;
import org.springframework.stereotype.Controller;
import com.vdc.ims.common.resolver.CommandMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AuthController {

    @Resource(name="authService")
    private AuthService authService;


    /**
     * 서비스관리
     */
    //권한관리-서비스관리
    @RequestMapping(value="/auth/service/")
    public ModelAndView RoleService(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("view/cmm/mng/auth/service");
        return mv;
    }
    //서비스 리스트
    @RequestMapping(value="/auth/service/list")
    public ModelAndView SvcList(CommandMap commandMap, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Svc = authService.SvcList(commandMap.getMap());
        mv.addObject("data", Svc);
        return mv;
    }
    //서비스 등록
    @RequestMapping(value="/auth/service/add")
    public ModelAndView SvcAdd(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        authService.SvcAdd(commandMap.getMap(), session);
        return mv;
    }
    //서비스 수정
    @RequestMapping(value="/auth/service/edit")
    public ModelAndView SvcEdt(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        authService.SvcEdt(commandMap.getMap(), session);
        return mv;
    }
    //서비스 삭제
    @RequestMapping(value="/auth/service/del")
    public ModelAndView SvcDel(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> Svc = authService.SvcDel(commandMap.getMap());
        mv.addObject("Svc", Svc);
        return mv;
    }

    /**
     * 기본Role 관리
     */
    //Role
    @RequestMapping(value="/auth/role/onlyrole")
    public ModelAndView OnlyRole(CommandMap commandMap, HttpSession session ) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Role = authService.Role(commandMap.getMap(), session);

        mv.addObject("Role", Role);
        return mv;
    }

    //권한관리-기본권한 설정
    @RequestMapping(value="/auth/role/")
    public ModelAndView Role() throws Exception{
        ModelAndView mv = new ModelAndView("view/cmm/mng/auth/role");
        return mv;
    }
    @RequestMapping(value="/auth/role/service")
    public ModelAndView RoleService(CommandMap commandMap, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String, Object>> RoleSvc = new ArrayList<>();
        if (commandMap.getMap().containsKey("Role_No")) {
            RoleSvc = authService.RoleAndService(commandMap.getMap());
        }
        mv.addObject("RoleSvc", RoleSvc);
        return mv;
    }


    //등록
    @RequestMapping(value="/auth/role/add")
    public ModelAndView RoleAdd(CommandMap commandMap, HttpSession session) throws Exception{
        authService.RoleAdd(commandMap.getMap(), session);
        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }
    //수정
    @RequestMapping(value="/auth/role/edit")
    public ModelAndView RoleEdt(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Object result = authService.RoleEdt(commandMap.getMap(), session);
        mv.addObject("result", result);
        return mv;
    }
    //삭제
    @RequestMapping(value="/auth/role/del")
    public ModelAndView RoleDel(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        authService.RoleDel(commandMap.getMap(), session);
        return mv;
    }

    //Role에 서비스 추가
    @RequestMapping(value="/auth/role/svcadd")
    public ModelAndView RoleSvcAdd(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> Svc = authService.RoleSvcAdd(commandMap.getMap());
        mv.addObject("Svc", Svc);
        return mv;

    }


    /**
     * 개인권한 관리
     */
    //권한관리-개인권한 설정 view
    @RequestMapping(value="/auth/role/person/")
    public ModelAndView PersonRole(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("view/cmm/mng/auth/person_role");
        return mv;
    }
    //개인별 개인 권한 가져오기
    @RequestMapping(value="/auth/role/person/list")
    public ModelAndView getPersonRole(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");

        List<Map<String,Object>> Svc = authService.getPersonSvc(commandMap.getMap());
        List<Map<String,Object>> Dept = authService.getPersonDept(commandMap.getMap());
        List<Map<String,Object>> Que = authService.getPersonQue(commandMap.getMap());
        List<Map<String,Object>> Called = authService.getPersonCalled(commandMap.getMap());
        List<Map<String,Object>> Branch = authService.getPersonBranch(commandMap.getMap());

        mv.addObject("Svc", Svc);
        mv.addObject("Dept", Dept);
        mv.addObject("Que", Que);
        mv.addObject("Called", Called);
        mv.addObject("Branch", Branch);

        return mv;
}
    //개인 권한 서비스 추가
    @RequestMapping(value="/auth/role/person/add")
    public ModelAndView PersonRoleAdd(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> Svc = authService.PersonRoleAdd(commandMap.getMap());
        mv.addObject("Svc", Svc);
        return mv;
    }

    //개인권한내 부서, QUEUE, CalledNumber 조회 권한
    @RequestMapping(value="/auth/role/grant")
    public ModelAndView GrantAdd(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        authService.GrantAdd(commandMap.getMap(), session);
        return mv;
    }
}
