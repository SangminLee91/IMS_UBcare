package com.vdc.ims.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.vdc.ims.common.dao.AbstractDAO;
 
/**
 * @author Mir
 *
 */
@Repository("mntngDAO")
public class MntngDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    @Resource(name="sqlSessionSub")
    private SqlSessionTemplate mssql;


    //모니터링 CPU Data
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getCpuData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getCpuData", map);
    } 
	//모니터링 Memory Data
    @SuppressWarnings("unchecked")
    public Map<String, Object> getMemoryData(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mntng.getMemoryData", map);
    }
	//모니터링 서버 IP 리스트
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSvrIP(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getSvrIP", map);
    } 
	//모니터링 Disk 리스트
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDiskData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getDiskData", map);
    }    
	//모니터링 Nwtwork 리스트
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getNetworkData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getNetworkData", map);
    }    
	//모니터링 프로세스 상태 리스트
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getProcData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getProcData", map);
    }  
    //모니터링 최종및 금일 Summary Data
    @SuppressWarnings("unchecked")
	public List<Map<String, Object>> getSummaryData(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getSummaryData", map);
    }  
    
    //OSCC 실시간 모니터링 : 그룹
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCRealtimeGroup(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCRealtimeGroup", map);
    }
  	//OSCC 실시간 모니터링 : 큐
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCRealtimeQueue(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCRealtimeQueue", map);
    }
    //OSCC 실시간 모니터링 : 큐-grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCRealtimeQueueGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCRealtimeQueueGrant", map);
    }
  	//OSCC 실시간 모니터링 : 사용자
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCRealtimeUser(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCRealtimeUser", map);
    }
    
    //OSCC 실시간 모니터링 : 사용자-grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCRealtimeUserGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCRealtimeUserGrant", map);
    }
    //OSCC 실시간 모니터링 : 콜
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCRealtimeContact(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCRealtimeContact", map);
    }
    //OSCC 실시간 모니터링 : 큐집계
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCCumulativeQueue(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCCumlativeQueue", map);
    }
    //OSCC 실시간 모니터링 : 큐집계 - grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCCumulativeQueueGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCCumlativeQueueGrant", map);
    }
    //OSCC 실시간 모니터링 : Dashboard 대기콜
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardWaitCallStatus(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardWaitCallStatus", map);
    }
    //getOSCCDashBoardAgentStatus
    //OSCC 실시간 모니터링 : Dashboard 상담원현황
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardAgentStatus(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardAgentStatus", map);
    }
    //getOSCCDashBoardCallStatus
    //OSCC 실시간 모니터링 : Dashboard 콜현황
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardCallStatus(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardCallStatus", map);
    }
    //OSCC 실시간 모니터링 : Dashboard 응대율/포기율
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardRstRate(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardRstRate", map);
    }
    //OSCC 실시간 모니터링 : Dashboard 시간대별 콜정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardTimeunit(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardTimeunit", map);
    }
    //OSCC 실시간 모니터링 : Dashboard 대기콜 - grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardWaitCallStatusGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardWaitCallStatusGrant", map);
    }
    //getOSCCDashBoardAgentStatus
    //OSCC 실시간 모니터링 : Dashboard 상담원현황 - grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardAgentStatusGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardAgentStatusGrant", map);
    }
    //getOSCCDashBoardCallStatus
    //OSCC 실시간 모니터링 : Dashboard 콜현황 - grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardCallStatusGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardCallStatusGrant", map);
    }
    //OSCC 실시간 모니터링 : Dashboard 응대율/포기율 - grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardRstRateGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardRstRateGrant", map);
    }
    //OSCC 실시간 모니터링 : Dashboard 시간대별 콜정보 - grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOSCCDashBoardTimeunitGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getOSCCDashBoardTimeunitGrant", map);
    }
    //OSCC 실시간 모니터링 : IVR모니터링
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIVRRealtime(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getIVRRealtime", map);
    }
    //getTrunkStatus
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTrunkStatus(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getTrunkStatus", map);
    }
    //getTrunkStatus
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTrunkIP(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getTrunkIP", map);
    }
    //getTrunkStatus_Timeunit
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTrunkStatus_Timeunit(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getTrunkStatus_Timeunit", map);
    }
    //getDNISStatus
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDNISStatus(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getDNISStatus", map);
    }
    //getDNISStatus - grant
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDNISStatusGrant(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getDNISStatusGrant", map);
    }
    //getSwitch
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSwitch(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getSwitch", map);
    } 
    
    //getSwitchPort
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSwitchPort(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getSwitchPort", map);
    }
    //getSwitchCpu
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSwitchCpu(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getSwitchCpu", map);
    }
    
    //getGateWay
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getGateWay(Map<String, Object> map) throws Exception{
    	return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getGateWay", map);
    }

    //get Callback Count
    @SuppressWarnings("unchecked")
    public Map<String, Object> getCallBack(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(mssql, "mssql.getCallBack", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDomainNum(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getDomainNum", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDomainNumNoSession(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getDomainNumNoSession", map);
    }


    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDeptSame(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mntng.getDeptSame", map);
    }

}
