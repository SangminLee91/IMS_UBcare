package com.vdc.ims.controller;

import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class SampleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name="sampleService")
    private SampleService sampleService;

//
//    @RequestMapping("/login")
//    public ModelAndView login(CommandMap commandMap) {
//        ModelAndView mv = new ModelAndView("login");
//        mv.addObject("param",commandMap.getMap());
//        return mv;
//    }

    @RequestMapping("/sample")
    public ModelAndView sample(CommandMap commandMap) {

        ModelAndView mv = new ModelAndView("sample");
        mv.addObject("param",commandMap.getMap());
        return mv;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/getData")
    public ModelAndView getData(CommandMap commandMap) throws Exception {
        Map<String,Object> Map = sampleService.SampleGet(commandMap.getMap());
        Map<String,Object> Map2 = sampleService.SampleGet2(commandMap.getMap());
        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("data",Map);
        mv.addObject("data2",Map2);
        return mv;
    }


    //Password　변경
 /*   @RequestMapping(value="/main")
    public ModelAndView Main() {
        return new ModelAndView("view/main");
    }
*/


/*
    ModelAndView mv = new ModelAndView("jsonView");
    List<Map<String, Object>> data = new ArrayList<>();

        if(commandMap.getMap().containsKey("Room_Sys_No")) {
        data = roomService.getRoomExtnData(commandMap.getMap());
    }

        mv.addObject("data",data);
        return mv;
*/
}
