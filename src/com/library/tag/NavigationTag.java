
package com.library.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.library.cache.SystemCache;
import com.library.constants.SysConstants;
import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;

public class NavigationTag extends SimpleTagSupport
{
    /**
     * css样式
     */
    private String cssClass;

    public String getCssClass()
    {
        return cssClass;
    }

    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    @Override
    public void doTag() throws JspException, IOException
    {
        /**
         * 这里的写法只适用于二级菜单
         */
        StringBuilder navBuilder = new StringBuilder("<div class='"+cssClass+"'>您的当前位置:");
        PageContext pageCtx = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageCtx.getRequest();
        LoginUserInfo loginUserInfo = (LoginUserInfo) request.getSession().getAttribute(
                SysConstants.SESSION_KEY_LOGIN_USER_INFO);
        SysFunc sysFunc = loginUserInfo.getUrlFunc().get(request.getAttribute(SysConstants.ACCESS_URL));
        if (sysFunc != null)
        {
            navBuilder.append(SystemCache.getInstance().getSysFuncMap().get(sysFunc.getParentid()).getFuncname())
                    .append(" >> ").append(sysFunc.getFuncname());
        }
        navBuilder.append("</div>").append("<hr/>");
        getJspContext().getOut().println(navBuilder);
        getJspContext().getOut().flush();
    }
}
