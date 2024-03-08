package com.vdc.ims.common.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.vdc.ims.common.util.StringUtil;
import com.vdc.ims.dao.HistoryDAO;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class })
        ,@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })
})
public class MybatisInterceptor implements Interceptor {

    @Autowired
    HistoryDAO historyDAO;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
/*
    Object[] args = invocation.getArgs();
    MappedStatement ms = (MappedStatement) args[0];
    Object param = (Object) args[1];
    BoundSql boundSql = ms.getBoundSql(param);
    String query_id = ms.getId();
*/

    Object[] args = invocation.getArgs();
    MappedStatement ms = (MappedStatement) args[0];
    Object param = (Object) args[1];
    BoundSql boundSql = ms.getBoundSql(param);
    String Procedure_Nm = boundSql.getSql().toString().replace("CALL ", "").replace("?", "").replace(",", "").replace(" ", "").replace("(", "").replace(")", "").replace("'", "").replace("NULLIF", "");
    String CUD = Procedure_Nm.substring(Procedure_Nm.length()-2, Procedure_Nm.length());

        if(!ms.getId().toString().equals("hist.addHist") && !ms.getId().toString().equals("smstask.LastSmsSendDt_u"))
        {
            //이력저장
            if (CUD.lastIndexOf("_I") >= 0 || CUD.lastIndexOf("_U") >= 0 || CUD.lastIndexOf("_D") >= 0)
            {
                Map<String, Object> Map = new HashMap<String, Object>();
                Map.put("Procedure_Nm", Procedure_Nm);
                Map.put("Emp_No", StringUtil.getSession().toString());
                Map.put("Parameter", param.toString());

                //historyDAO.addHist(Map);
            }
        }

//    if ( query_id.contains(query_id)) {
//        System.out.println("====================================");
//        System.out.println("1:" + invocation.getMethod().getName());
//        System.out.println("====================================");
//        System.out.println("2:" + ms.getId());
//        System.out.println("====================================");
//        System.out.println("3:" + boundSql.getSql());
//        System.out.println("====================================");
//        System.out.println("4:" + param);
//        System.out.println("====================================");
//        System.out.println("5:" + ms.getId());
//    }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
