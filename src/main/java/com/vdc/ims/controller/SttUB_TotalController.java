package com.vdc.ims.controller;


import com.vdc.ims.common.resolver.CommandMap;
import com.vdc.ims.common.util.DateUtil;
import com.vdc.ims.common.util.ExcelView;
import com.vdc.ims.service.SttUBTotalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SttUB_TotalController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="sttUBTotalService")
	private SttUBTotalService sttUBTotalService;

	/**
	 * 총괄 현황 대리점 포함
	*/
	//총괄 현황 대리점 포함 view
	@RequestMapping(value="/stt/ub/total/")
    public ModelAndView sttUB_Total() throws Exception{
    	ModelAndView mv = new ModelAndView("view/stt/ub/all");
    	return mv;
    }

	//총괄 현황 대리점 포함 리스트
	@RequestMapping(value="/stt/ub/total/data")
    public ModelAndView sttUB_TotalData(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getAll(commandMap.getMap());
	    mv.addObject("Stt", Stt);
		return mv;
    }

	//총괄 현황 대리점 포함 엑셀
	@RequestMapping(value="/stt/ub/excel/total")
	public void sttUB_TotalExcel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<String, Object>();

		List<Map<String,Object>> data = sttUBTotalService.getAll(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "총괄현황_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "totalStats.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}


	/**
	 * 총괄 현황 본사만
	 */
	//총괄 현황 본사만 view
	@RequestMapping(value="/stt/ub/total/head/")
	public ModelAndView sttUB_Total_Head_() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/all_head");
		return mv;
	}

	//총괄 현황 본사만 리스트
	@RequestMapping(value="/stt/ub/total/head/data")
	public ModelAndView sttUB_Total_Head_Data(CommandMap commandMap) throws Exception{

		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getAllHead(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}

	//총괄 현황 본사만 엑셀
	@RequestMapping(value="/stt/ub/excel/total_head")
	public void sttUB_Total_Head_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getAllHead(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "통합센터 총괄 현황2_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "totalHeadStats.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}


	/**
	 * 시간대별 접촉율
	 */
	@RequestMapping(value="/stt/ub/time/")
	public ModelAndView sttUB_time() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/time_contact");
		return mv;
	}

	@RequestMapping(value="/stt/ub/time/data")
	public ModelAndView sttUB_Time_Data(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getTime(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}

	@RequestMapping(value="/stt/ub/excel/time")
	public void sttUB_Time_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getTime(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "시간대별접촉율_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "time_contact.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}


	/**
	 * 시간대별 접촉율 - 상담원
	 */
	@RequestMapping(value="/stt/ub/time/agent/")
	public ModelAndView sttUB_time_Agent() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/time_contact_agent");
		return mv;
	}

	@RequestMapping(value="/stt/ub/time/agent/data")
	public ModelAndView sttUB_Time_Sgent_Data(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getTimeAgent(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}

	@RequestMapping(value="/stt/ub/excel/time_agent")
	public void sttUB_Time_Agent_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getTimeAgent(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "시간대별접촉율(상담원)_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "time_contact_agent.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}

	/**
	 * 상담원 실적현황
	 */
	@RequestMapping(value="/stt/ub/agent/result/")
	public ModelAndView sttUB_Agent_Result() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/agent_result");
		return mv;
	}
	@RequestMapping(value="/stt/ub/agent/result/data")
	public ModelAndView sttUB_Agent_Result_Data(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getUBAgentResult(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}

	@RequestMapping(value="/stt/ub/excel/agent_result")
	public void sttUB_Agent_Result_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getUBAgentResult(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "상담원실적현황_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "agent_result.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}


	/**
	 * 큐별 재통화분석
	 */
	@RequestMapping(value="/stt/ub/recall/que/")
	public ModelAndView sttUB_QueRecall() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/recall");
		return mv;
	}
	@RequestMapping(value="/stt/ub/recall/que/data")
	public ModelAndView sttUB_QueRecall_Data(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getUBQueRecall(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}
	@RequestMapping(value="/stt/ub/excel/recall_que")
	public void sttUB_QueRecall_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getUBQueRecall(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "큐별재통화분석_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "recall_que.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}

	/**
	 * 큐별 재통화리스트
	 */
	@RequestMapping(value="/stt/ub/recall/")
	public ModelAndView sttUB_QueRecallList() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/recall_list");
		return mv;
	}
	@RequestMapping(value="/stt/ub/recall/data")
	public ModelAndView sttUB_QueRecallList_Data(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getUBQueRecallList(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}
	@RequestMapping(value="/stt/ub/excel/recall")
	public void sttUB_QueRecallList_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getUBQueRecallList(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "큐별재통화리스트_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "recall_que_list.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}


	/**
	 * IVR통계
	 */
	@RequestMapping(value="/stt/ub/ivr/")
	public ModelAndView sttUB_Ivr() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/ivr_list");
		return mv;
	}
	@RequestMapping(value="/stt/ub/ivr/data")
	public ModelAndView sttUB_Ivr_Data(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getUBIvrList(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}
	@RequestMapping(value="/stt/ub/excel/ivr")
	public void sttUB_Ivr_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getUBIvrList(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "IVR통계_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "ivr_list.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}


	/**
	 * 통화시간분석
	 */
	@RequestMapping(value="/stt/ub/call/time/")
	public ModelAndView sttUB_Calltime() throws Exception{
		ModelAndView mv = new ModelAndView("view/stt/ub/calltime");
		return mv;
	}
	@RequestMapping(value="/stt/ub/calltime/data")
	public ModelAndView sttUB_Calltime_Data(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>> Stt = sttUBTotalService.getUBCallTimeList(commandMap.getMap());
		mv.addObject("Stt", Stt);
		return mv;
	}
	@RequestMapping(value="/stt/ub/excel/calltime")
	public void sttUB_Calltime_Excel(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Map<String, Object> excelData = new HashMap<>();

		List<Map<String,Object>> data = sttUBTotalService.getUBCallTimeList(commandMap.getMap());
		excelData.put("data", data);
		excelData.put("sdate", commandMap.getMap().get("sDate"));
		excelData.put("edate", commandMap.getMap().get("eDate"));

		ExcelView excel = new ExcelView();
		String filename = "통화시간분석_"+ DateUtil.getToday("yyyyMMddhhmmss");
		String templateFile = "calltime.xlsx";
		excel.download(request, response, excelData, filename, templateFile);
	}

}
