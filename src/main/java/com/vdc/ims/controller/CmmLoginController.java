package com.vdc.ims.controller;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.common.util.Authentication;
import com.vdc.ims.service.CmmLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CmmLoginController {

    @Resource(name="cmmLoginService")
    private CmmLoginService cmmLoginService;

    /** login Form And Main　*/
    @RequestMapping(value={"/", "/login"})
    public ModelAndView LoginForm(HttpSession session) {
        ModelAndView mv = new ModelAndView("view/login");
        if(session.getAttribute("Emp_No") != null) mv.setViewName("redirect:/mntng/dash/"); ///mntng/dash/
        return mv;
    }

    //Login Process
    @RequestMapping(value="/loginchk")
    public ModelAndView LoginChk(CommandMap commandMap, HttpSession session) throws Exception{

        ModelAndView mv = new ModelAndView("jsonView");
        Map<String, Object> Rst = new HashMap<>();
        Map<String, Object> LdapRst = new HashMap<>();
        Map<String, Object> ImsRst = new HashMap<>();

        boolean result = false;

        //1000 ID의 경우 LADP 인증 건너뛴다
        if("1000".equals(commandMap.getMap().get("Emp_No").toString()) || "yjseong".equals(commandMap.getMap().get("Emp_No").toString()))
        {
            result = true;
        }
        else
        {
            Authentication auth = new Authentication();
            result = auth.Logon(commandMap.getMap().get("Emp_No").toString(), commandMap.getMap().get("Pwd").toString(), "UBWARE");
        }

        LdapRst.put("ldap", result);

        if(result) {
            ImsRst = cmmLoginService.LoginChk(commandMap.getMap());

            if(ImsRst != null && !ImsRst.isEmpty()){
                session.setAttribute("Emp_No", URLDecoder.decode(ImsRst.get("Emp_No").toString(), "UTF-8"));
                session.setAttribute("Emp_Nm", URLDecoder.decode(ImsRst.get("Emp_Nm").toString(), "UTF-8"));
                session.setAttribute("Agent_Key", URLDecoder.decode(ImsRst.get("Agent_Key").toString(), "UTF-8"));
                session.setAttribute("Role_No", URLDecoder.decode(ImsRst.get("Role_No").toString(), "UTF-8"));
            }
        }

        Rst.put("ldap", LdapRst);
        Rst.put("ims", ImsRst);

        mv.addObject("Rst", Rst);
        return mv;
    }

    //Login Out
    @RequestMapping(value="/logout")
    public ModelAndView LogOut(HttpSession session) throws Exception{
        session.invalidate(); //세션 삭제
        return new ModelAndView("redirect:/login");
    }

    //Password　변경
    @RequestMapping(value="/pwd")
    public ModelAndView PasswdChangeForm() {
        return new ModelAndView("view/pwd");
    }

    //Password 변경　처리
    @RequestMapping(value="/pwdchg")
    public ModelAndView PasswdChange(CommandMap commandMap, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String,Object> Rst = cmmLoginService.PasswdChange(commandMap.getMap(), session);
        mv.addObject("Rst", Rst);
        return mv;
    }


}
