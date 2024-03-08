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
@Repository("sttRecDAO")
public class SttRecDAO extends AbstractDAO{

    @Resource(name="sqlSessionSub")
    private SqlSessionTemplate Mssql;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSttRec(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(Mssql, "sttRec.getSttRec", map);
    }
    
}
