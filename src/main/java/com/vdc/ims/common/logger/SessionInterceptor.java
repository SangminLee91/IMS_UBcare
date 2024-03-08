package com.vdc.ims.common.logger;

import com.vdc.ims.common.util.StringUtil;
import com.vdc.ims.dao.AuthDAO;
import com.vdc.ims.dao.CmmLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    CmmLoginDAO cmmLoginDAO;

    @Autowired
    AuthDAO authDAO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (!hasSessionInfo(session)) {
            //로그인 페이지 이동
            if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
                response.sendError(901, "Login session fail!!");
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
            return false;
        }

        //메뉴 권한 확인
        if (!"XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
            Map<String, Object> AuthMap = new HashMap<>();
            AuthMap.put("url", request.getRequestURI());
            AuthMap.put("emp_no", session.getAttribute("Emp_No").toString());
            StringUtil.setSession(session.getAttribute("Emp_No").toString());

            Map<String,Object> Auth = authDAO.AuthCheck(AuthMap);
            if(!(Boolean) Auth.get("Rst"))
            {
                response.sendRedirect(request.getContextPath() + "/blank");
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView == null) return;

        HttpSession session = request.getSession();

        if(!"XMLHttpRequest".equals(request.getHeader("x-requested-with")))
        {
            Map<String, String> sessionMap = new HashMap<>();
            sessionMap.put("Emp_No", session.getAttribute("Emp_No").toString());
            sessionMap.put("Emp_Nm", session.getAttribute("Emp_Nm").toString());
            sessionMap.put("Role_No", session.getAttribute("Role_No").toString());
            sessionMap.put("curUrl", request.getRequestURI());

            modelAndView.addObject("UserInfo", sessionMap);

            Map<String, Object> MenuMap = new HashMap<>();
            MenuMap.put("_EMP_NO", session.getAttribute("Emp_No").toString());
            MenuMap.put("_CURRENT_URL_", request.getRequestURI()); //현재 URL
            List<Map<String,Object>> Menu = cmmLoginDAO.getMenu(MenuMap); //cmmAuthService.getMenu(MenuMap); //

            modelAndView.addObject("Menu", Menu);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
    }

    private boolean hasSessionInfo(HttpSession session)
    {
        return (session.getAttribute("Emp_No") != null);
    }


}
