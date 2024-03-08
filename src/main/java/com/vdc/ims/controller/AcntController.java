package com.vdc.ims.controller;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.AcntService;
import com.vdc.ims.service.CodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AcntController {

    @Resource(name="codeService")
    private CodeService codeService;

    @Resource(name="acntService")
    private AcntService acntService;



    //전체 사원 목록
    @RequestMapping(value="/acnt/emp/total/list")
    public ModelAndView getTotalEmp(CommandMap commandMap, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String,Object>> Emp = acntService.getTotalEmp(commandMap.getMap());
        mv.addObject("Emp", Emp);
        return mv;
    }



}
