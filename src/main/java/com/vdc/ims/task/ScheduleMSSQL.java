package com.vdc.ims.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ScheduleMSSQL {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name="mssqlDao")
    private ScheduleMSSQLDAO mssqlDao;


    @Scheduled(fixedDelay = 1000 * 60 * 1) // 1000 * 10
    public void MssqlSync() throws Exception {

        //tblCTI_Callback
        List<Map<String,Object>> getCallBackData = mssqlDao.getCallBackData();
        if (!getCallBackData.isEmpty()) {
            Map<String, Object> Data = new HashMap<String, Object>();
            Data.put("list", getCallBackData);

            mssqlDao.setCallBackData(Data); // Maria DB Insert
            mssqlDao.setSyncYnUpdate(Data); //SyncYn
        }

        //콜백처리 업데이트
        List<Map<String,Object>> getProcCallback = mssqlDao.getProcessCallback();
        if (!getProcCallback.isEmpty()) {
            Map<String, Object> ProcData = new HashMap<String, Object>();
            ProcData.put("list", getProcCallback);

            mssqlDao.setProcCallback(ProcData); // Maria DB Update
        }

    }
}
