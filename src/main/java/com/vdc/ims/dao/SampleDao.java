package com.vdc.ims.dao;

import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("sampleDao")
public class SampleDao extends AbstractDAO
{
    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

//    @Resource(name="sqlSessionSub")
//    protected SqlSessionTemplate sqlSessionSub;

    @SuppressWarnings("unchecked")
    public Map<String, Object> SampleGet(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "sample.getData", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> SampleGet2(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "sample.getData2", map);
    }

}
