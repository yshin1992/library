
package com.library.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.library.cache.SystemCache;
import com.library.constants.SysConstants;
import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;

public class MenuTreeTag extends SimpleTagSupport
{
    //带有属性的标签必须有get,set方法
    private String imgUrl;

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    @Override
    public void doTag() throws JspException, IOException
    {
        PageContext pageCtx = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageCtx.getRequest();
        LoginUserInfo loginUserInfo = (LoginUserInfo) request.getSession().getAttribute(SysConstants.SESSION_KEY_LOGIN_USER_INFO);
        StringBuilder funcBuilder = new StringBuilder("<div class=\"container\"><div class=\"leftsidebar_box\"><div class=\"line\"></div>");
        Map<Integer, SysFunc> sysFuncMap = loginUserInfo.getSysFunc();
        if (sysFuncMap != null)
        {
            int maxSize = SystemCache.getInstance().getSysFuncMap().size();
            Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
            StringBuilder[] menuBuilder = new StringBuilder[maxSize];
            Set<Integer> keySet = sysFuncMap.keySet();
            int index = 0;
            for (Integer key : keySet)
            {
                SysFunc temp = sysFuncMap.get(key);
                if (temp.getFunctype().equals("Menu"))
                {
                    menuBuilder[index] = new StringBuilder("<dl class=" + temp.getCss() + "><dt>" + temp.getFuncname()
                            + "<img src=" + imgUrl + "></dt>");
                    indexMap.put(temp.getAiid(), index);
                    index++;
                }
                else if (temp.getFunctype().equals("MenuItem"))
                {
                    menuBuilder[indexMap.get(temp.getParentid())].append("<dd><a href=" + temp.getUrl()
                            + " target=\"main\">" + temp.getFuncname() + "</a></dd>");
                }
            }
            for (int i = 0; i < index; i++)
            {
                menuBuilder[i].append("</dl>");
                funcBuilder.append(menuBuilder[i]);
            }
        }
        funcBuilder.append("</div></div>");
        getJspContext().getOut().println(funcBuilder);
        getJspContext().getOut().flush();
    }

}
