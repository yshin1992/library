
package com.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.SysConstants;
import com.library.constants.UrlConstants;
import com.library.entity.LoginUserInfo;

@WebFilter(filterName = "accessURLFilter", urlPatterns = "*.do")
public class AccessURLFilter implements Filter
{

    @Override
    public void destroy()
    {

    }

    /**
     * 监视用户访问的URL
     * 并传递用户当前访问的位置
     */
    @Override
    public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        LoginUserInfo loginUserInfo = (LoginUserInfo) req.getSession().getAttribute(
                SysConstants.SESSION_KEY_LOGIN_USER_INFO);
        if (loginUserInfo != null || req.getRequestURI().endsWith("login.do"))
        {
            if (loginUserInfo != null)
            {
                req.setAttribute(SysConstants.ACCESS_URL, req.getRequestURI().replace(req.getServletContext().getContextPath()+SysConstants.PATH_SEPARATOR, ""));
            }
            chain.doFilter(request, response);
        }
        else
        {
            ((HttpServletResponse) response).sendRedirect(req.getContextPath() + UrlConstants.LOGIN_PAGE);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {

    }

}
