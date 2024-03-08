package com.vdc.ims.task;


import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("mssqlDao")
public class ScheduleMSSQLDAO extends AbstractDAO {

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate maria;

    @Resource(name="sqlSessionSub")
    private SqlSessionTemplate mssql;


    public List<Map<String, Object>> getCallBackData() throws Exception{
        return (List<Map<String, Object>>)selectList(mssql, "mssql.GET_tblCTI_Callback");
    }

    public void setCallBackData(Map<String,Object> map) throws Exception{
        insert(maria, "mssql.SET_tblCTI_Callback", map);
    }

    public void setSyncYnUpdate(Map<String,Object> map) throws Exception{
        update(mssql, "mssql.SET_SyncYn_CallBack", map);
    }

    public List<Map<String, Object>> getProcessCallback() throws Exception{
        return (List<Map<String, Object>>)selectList(mssql, "mssql.GET_Process_Callback");
    }

    public void setProcCallback(Map<String,Object> map) throws Exception{
        update(maria, "mssql.SET_Process_Callback", map);
    }



}
