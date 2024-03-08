package com.vdc.ims.dao;

import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("authDAO")
public class AuthDAO extends AbstractDAO {
    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;


    /**
     * 권한 체크
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> AuthCheck(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "auth.AuthCheck", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> SvcList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.SvcList", map);
    }
    public void SvcAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "auth.SvcAdd", map);
    }
    public void SvcEdt(Map<String, Object> map) throws Exception{
        insert(sqlSession, "auth.SvcEdt", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> SvcDel(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "auth.SvcDel", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> RoleSvc(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.RoleSvc", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> Role(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.Role", map);
    }
    public void RoleAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "auth.RoleAdd", map);
    }
    public Object RoleEdt(Map<String, Object> map) throws Exception{
        return update(sqlSession, "auth.RoleEdt", map);
    }
    public void RoleDel(Map<String, Object> map) throws Exception{
        update(sqlSession, "auth.RoleDel", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> RoleSvcAdd(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "auth.RoleSvcAdd", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> RoleAndService(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.RoleAndService", map);
    }


    /*
     * 개인권한 서비스
     * */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getPersonSvc(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.PersonSvc", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getPersonDept(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.PersonDept", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getPersonQue(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.PersonQue", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getPersonCalled(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.PersonCalled", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getPersonBranch(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "auth.PersonBranch", map);
    }



    //개인 권한 서비스 추가및 삭제
    @SuppressWarnings("unchecked")
    public Map<String, Object> PersonRoleAdd(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "auth.PersonRoleAdd", map);
    }
    public void GrantAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "auth.RoleGrant", map);
    }

}
