
package com.library.servlet.manager;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.SysConstants;
import com.library.constants.UrlConstants;
import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;
import com.library.enums.UserType;
import com.library.service.LoginService;
import com.library.service.SysFuncService;
import com.library.service.impl.ManagerLoginServiceImpl;
import com.library.service.impl.SysFuncServiceImpl;
import com.library.util.StringUtil;

@WebServlet(name = "login", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 2381562197655909286L;

    private LoginService<LoginUserInfo> loginService = new ManagerLoginServiceImpl();
    
    /**
     * 获取用户菜单
     */
    private SysFuncService<SysFunc> sysFuncService=new SysFuncServiceImpl();

    /**
     * 用户登录
     */
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        //用户名或密码为空时
        if (StringUtil.isEmpty(userId) || StringUtil.isEmpty(password) || StringUtil.isEmpty(userType)
                || !UserType.isCorrectType(userType))
        {
            request.setAttribute(SysConstants.LOGIN_FAIL_INFO, "用户名或密码错误");
            request.getRequestDispatcher(UrlConstants.LOGIN_FAULT_PAGE).forward(request, response);
            return;
        }
        LoginUserInfo loginUserInfo = loginService.login(userId, password, request);
        if (loginUserInfo != null)
        {
            //用户登录成功
            loginUserInfo.setUserType(UserType.getUserType(userType));
            Map<Integer,SysFunc> sysFunc=sysFuncService.queryFuncWithMgrID(userId);
            loginUserInfo.setSysFunc(sysFunc);
            loginUserInfo.setUrlFunc(sysFunc);
            request.getSession().setAttribute(SysConstants.SESSION_KEY_LOGIN_USER_INFO, loginUserInfo);
            request.getRequestDispatcher(UrlConstants.LOGIN_SUCCESS_PAGE).forward(request, response);
        }
        else
        {
            //用户登录失败
            request.setAttribute(SysConstants.LOGIN_FAIL_INFO, "用户名或密码错误");
            request.getRequestDispatcher(UrlConstants.LOGIN_FAULT_PAGE).forward(request, response);
        }
    }
}
