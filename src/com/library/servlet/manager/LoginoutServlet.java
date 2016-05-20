
package com.library.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;
import com.library.entity.LoginUserInfo;
import com.library.service.LoginService;
import com.library.service.impl.ManagerLoginServiceImpl;

@WebServlet(name = "loginout", urlPatterns = "/manager/loginout.do")
public class LoginoutServlet extends HttpServlet
{
    private static final long serialVersionUID = -6777338594401380915L;

    private LoginService<LoginUserInfo> loginService = new ManagerLoginServiceImpl();

    /**
     * 用户正常退出
     */
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        loginService.logout(request, "正常退出");
        //销毁session
        request.getSession().invalidate();
        //这里不能直接重定向到"/login.jsp"
        response.sendRedirect(request.getContextPath() + UrlConstants.LOGIN_PAGE);
    }

}
