
package com.library.servlet.manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.library.cache.SystemCache;
import com.library.constants.SysConstants;
import com.library.constants.UrlConstants;
import com.library.domain.Manager;
import com.library.entity.LoginUserInfo;
import com.library.service.ManagerService;
import com.library.service.impl.ManagerServiceImpl;
import com.library.util.Map2BeanUtil;

@WebServlet(name = "updateMgrInfo", urlPatterns = "/manager/updateMgrInfo.do")
public class UpdateMgrInfoServlet extends HttpServlet
{
    private static final long serialVersionUID = -8688689264108775810L;

    private static Logger logger=Logger.getLogger(UpdateMgrInfoServlet.class);
    
    private ManagerService<Manager> managerService=new ManagerServiceImpl();
    
    /**
     * 进入初始化页面使用doGet
     */
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(UrlConstants.INIT_UPDATE_PAGE).forward(request, response);
    }

    /**
     * 提交修改使用doPost
     */
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            Manager manager=(Manager) Map2BeanUtil.stringMap2Object(request.getParameterMap(), Manager.class);
            if(managerService.updateManager(manager)){
                LoginUserInfo loginUserInfo=SystemCache.getInstance().getLoginUserWithSessionId(request.getSession().getId());
                Manager tmp=(Manager) loginUserInfo.getModel();
                manager.setIsadmin(tmp.getIsadmin());
                manager.setStatus(tmp.getStatus());
                //更新SysCache的manager对象
                loginUserInfo.setModel(manager);
                request.getRequestDispatcher(UrlConstants.UPDATE_SUCCESS_PAGE).forward(request, response);
                return;
            }else{
                logger.debug("用户信息更新失败！");
            }
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            logger.error("类型转换出错！");
            e.printStackTrace();
        }
        request.setAttribute(SysConstants.UPDATE_ERROR_INFO, "更新信息失败!");
        request.getRequestDispatcher(UrlConstants.INIT_UPDATE_PAGE).forward(request, response);
    }

}
