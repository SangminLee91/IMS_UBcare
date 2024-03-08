package com.vdc.ims.dao;

import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("cmmLoginDAO")
public class CmmLoginDAO extends AbstractDAO {

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    @SuppressWarnings("unchecked")
    public Map<String, Object> LoginChk(Map<String, Object> map) {
        return (Map<String, Object>) selectOne(sqlSession, "login.LoginChk", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> PasswdChange(Map<String, Object> map) {
        return (Map<String, Object>) selectOne(sqlSession, "login.PasswdChange", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMenu(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "cmmEtc.getMenu", map);
    }

}
