package com.vdc.ims.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.vdc.ims.common.dao.AbstractDAO;

@Repository("codeDAO")
public class CodeDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    //공통코드
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> CmmCodeList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.CmmCodeList", map);
    }
    public void CmmCodeAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "code.CmmCodeAdd", map);
    }
    public void CmmCodeEdt(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CmmCodeEdt", map);
    }
    public void CmmCodeDel(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CmmCodeDel", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> CmmCodeDtlList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.CmmCodeDtlList", map);
    }
    public void CmmCodeDtlAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "code.CmmCodeDtlAdd", map);
    }
    public void CmmCodeDtlEdt(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CmmCodeDtlEdt", map);
    }
    public void CmmCodeDtlDel(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CmmCodeDtlDel", map);
    }

    //부서
    public void DeptAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "code.CodeDept_I", map);
    }
    public void DeptEdt(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CodeDept_U", map);
    }
    public void DeptDel(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CodeDept_D", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> DeptName(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "code.DeptName_S", map);
    }




    //Queue Code
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> CodeQueueList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.CodeQue_S", map);
    }
    public void CodeQueueAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "code.CodeQue_I", map);
    }
    public void CodeQueueEdt(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CodeQue_U", map);
    }
    public void CodeQueueDel(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CodeQue_D", map);
    }

    //CalledNumber Code
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> CodeCalledNumberList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.CodeCalledNumber_S", map);
    }
    public void CodeCalledNumberAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "code.CodeCalledNumber_I", map);
    }
    public void CodeCalledNumberEdt(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CodeCalledNumber_U", map);
    }
    public void CodeCalledNumberDel(Map<String, Object> map) throws Exception{
        update(sqlSession, "code.CodeCalledNumber_D", map);
    }

    //IMS_IFX VirtualGroups
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> VirtualGroupsList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.VirtualGroupsList", map);
    }

    //IMS_IFX Teams
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> TeamsList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.TeamsList", map);
    }

    //IMS_IFX Queue Calltype
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> CallTypeList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.CallTypeList", map);
    }

    //IMS_IFX Monitoredresources
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> MonitoredresourcesList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "code.MonitoredresourcesList", map);
    }


}
