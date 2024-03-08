package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.vdc.ims.dao.MntngDAO;
import com.vdc.ims.service.MntngService;
import org.springframework.stereotype.Service;


@Service("mntngService")
public class MntngServiceImpl implements MntngService {

    @Resource(name="mntngDAO")
    private MntngDAO mntngDAO;

    //모니터링 CPU Data
    @Override
    public List<Map<String, Object>> getCpuData(Map<String, Object> map) throws Exception {
        return mntngDAO.getCpuData(map);
    }
    //모니터링 Memory Data
    @Override
    public Map<String, Object> getMemoryData(Map<String, Object> map) throws Exception {
        return mntngDAO.getMemoryData(map);
    }
    //모니터링 서버 IP 리스트
    @Override
    public List<Map<String, Object>> getSvrIP(Map<String, Object> map) throws Exception {
        return mntngDAO.getSvrIP(map);
    } 
    //모니터링 Disk 리스트
    @Override
    public List<Map<String, Object>> getDiskData(Map<String, Object> map) throws Exception {
        return mntngDAO.getDiskData(map);
    } 
    //모니터링 Network 리스트
    @Override
    public List<Map<String, Object>> getNetworkData(Map<String, Object> map) throws Exception {
        return mntngDAO.getNetworkData(map);
    } 
    //모니터링 프로세스 상태 리스트
    @Override
    public List<Map<String, Object>> getProcData(Map<String, Object> map) throws Exception {
        return mntngDAO.getProcData(map);
    } 
 	//모니터링 최종및 금일 Summary Data
    @Override
    public List<Map<String, Object>> getSummaryData(Map<String, Object> map) throws Exception {
        return mntngDAO.getSummaryData(map);
    } 
    //OSCC 실시간 모니터링 : 그룹
    @Override
    public List<Map<String, Object>> getOSCCRealtimeGroup(Map<String, Object> map) throws Exception{
    	return mntngDAO.getOSCCRealtimeGroup(map);
    }
  	//OSCC 실시간 모니터링 : 큐
    @Override
    public List<Map<String, Object>> getOSCCRealtimeQueue(Map<String, Object> map) throws Exception{
    	return mntngDAO.getOSCCRealtimeQueue(map);
    }
    //OSCC 실시간 모니터링 : 큐 - grant
    @Override
    public List<Map<String, Object>> getOSCCRealtimeQueueGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mntngDAO.getOSCCRealtimeQueueGrant(map);
    }
  	//OSCC 실시간 모니터링 : 사용자
    @Override
    public List<Map<String, Object>> getOSCCRealtimeUser(Map<String, Object> map) throws Exception{
    	return mntngDAO.getOSCCRealtimeUser(map);
    }
    
    //OSCC 실시간 모니터링 : 사용자 - grant
    @Override
    public List<Map<String, Object>> getOSCCRealtimeUserGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mntngDAO.getOSCCRealtimeUserGrant(map);
    }
    
    //OSCC 실시간 모니터링 : 콜
    @Override
    public List<Map<String, Object>> getOSCCRealtimeContact(Map<String, Object> map) throws Exception{
    	return mntngDAO.getOSCCRealtimeContact(map);
    }
    //OSCC 실시간 모니터링 : 큐집계
    @Override
    public List<Map<String, Object>> getOSCCCumulativeQueue(Map<String, Object> map) throws Exception{
    	return mntngDAO.getOSCCCumulativeQueue(map);
    }
    //OSCC 실시간 모니터링 : 큐집계 - grant
    @Override
    public List<Map<String, Object>> getOSCCCumulativeQueueGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mntngDAO.getOSCCCumulativeQueueGrant(map);
    }
    //OSCC 실시간 모니터링 : Dashboard 대기콜
    @Override
    public List<Map<String, Object>> getOSCCDashBoardWaitCallStatus(Map<String, Object> map) throws Exception{
  		return mntngDAO.getOSCCDashBoardWaitCallStatus(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 상담원현황
    @Override
    public List<Map<String, Object>> getOSCCDashBoardAgentStatus(Map<String, Object> map) throws Exception{
  		return mntngDAO.getOSCCDashBoardAgentStatus(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 콜현황
    @Override
    public List<Map<String, Object>> getOSCCDashBoardCallStatus(Map<String, Object> map) throws Exception{
  		return mntngDAO.getOSCCDashBoardCallStatus(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 응대율/포기율
    @Override
    public List<Map<String, Object>> getOSCCDashBoardRstRate(Map<String, Object> map) throws Exception{
  		return mntngDAO.getOSCCDashBoardRstRate(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 시간대별 콜정보
    @Override
    public List<Map<String, Object>> getOSCCDashBoardTimeunit(Map<String, Object> map) throws Exception{
  		return mntngDAO.getOSCCDashBoardTimeunit(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 대기콜 Grant
    @Override
    public List<Map<String, Object>> getOSCCDashBoardWaitCallStatusGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getOSCCDashBoardWaitCallStatusGrant(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 상담원현황 Grant
    @Override
    public List<Map<String, Object>> getOSCCDashBoardAgentStatusGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getOSCCDashBoardAgentStatusGrant(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 콜현황 Grant
    @Override
    public List<Map<String, Object>> getOSCCDashBoardCallStatusGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getOSCCDashBoardCallStatusGrant(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 응대율/포기율 Grant
    @Override
    public List<Map<String, Object>> getOSCCDashBoardRstRateGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getOSCCDashBoardRstRateGrant(map);
  	}
    //OSCC 실시간 모니터링 : Dashboard 시간대별 콜정보 Grant
    @Override
    public List<Map<String, Object>> getOSCCDashBoardTimeunitGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getOSCCDashBoardTimeunitGrant(map);
  	}
    //OSCC 실시간 모니터링 : IVR 모니터링
    @Override
    public List<Map<String, Object>> getIVRRealtime(Map<String, Object> map) throws Exception{
  		return mntngDAO.getIVRRealtime(map);
  	}
    //Trunk
    @Override
    public List<Map<String, Object>> getTrunkStatus(Map<String, Object> map) throws Exception{
  		return mntngDAO.getTrunkStatus(map);
  	}
    @Override
    public List<Map<String, Object>> getTrunkIP(Map<String, Object> map) throws Exception{
  		return mntngDAO.getTrunkIP(map);
  	}
    @Override
    public List<Map<String, Object>> getTrunkStatus_Timeunit(Map<String, Object> map) throws Exception{
  		return mntngDAO.getTrunkStatus_Timeunit(map);
  	}
    //DNIS
    @Override
    public List<Map<String, Object>> getDNISStatus(Map<String, Object> map) throws Exception{
  		return mntngDAO.getDNISStatus(map);
  	}
    //DNIS - grant
    @Override
    public List<Map<String, Object>> getDNISStatusGrant(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getDNISStatusGrant(map);
  	}
    //getSwitch
    @Override
    public List<Map<String, Object>> getSwitch(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getSwitch(map);
  	}
    //getSwitchPort
    @Override
    public List<Map<String, Object>> getSwitchPort(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getSwitchPort(map);
  	}
    //getSwitchCpu
    @Override
    public List<Map<String, Object>> getSwitchCpu(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getSwitchCpu(map);
  	}
    //getGateWay
    @Override
    public List<Map<String, Object>> getGateWay(Map<String, Object> map, HttpSession session) throws Exception{
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
  		return mntngDAO.getGateWay(map);
  	}

    //getCallBack Count
    @Override
    public Map<String, Object> getCallBack(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mntngDAO.getCallBack(map);
    }
    //getCallBack Count
    @Override
    public Map<String, Object> getCallBack(Map<String, Object> map) throws Exception{
        return mntngDAO.getCallBack(map);
    }
    @Override
    public List<Map<String, Object>> getDomainNum(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mntngDAO.getDomainNum(map);
    }
    @Override
    public List<Map<String, Object>> getDomainNumNoSession(Map<String, Object> map) throws Exception{
        return mntngDAO.getDomainNumNoSession(map);
    }

    @Override
    public List<Map<String, Object>> getDeptSame(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return mntngDAO.getDeptSame(map);
    }


}
