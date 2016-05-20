
package com.library.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.library.cache.SystemCache;
import com.library.dao.SystemOperateLogDao;
import com.library.dao.impl.SystemOperateLogDaoImpl;
import com.library.domain.Manager;
import com.library.entity.LoginUserInfo;
import com.library.entity.SystemOperateLog;

@WebListener
public class SessionStateListener implements HttpSessionListener
{
    private SystemOperateLogDao<SystemOperateLog> systemOperateLogDao= new SystemOperateLogDaoImpl();

    @Override
    public void sessionCreated(HttpSessionEvent event)
    {
        System.out.println("session创建：" + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event)
    {
        System.out.println("session销毁:" + event.getSession().getId());
        LoginUserInfo loginUserInfo = SystemCache.getInstance().getLoginUserWithSessionId(event.getSession().getId());
        //用户超时退出
        if (loginUserInfo != null)
        {
            SystemCache.getInstance().removeLoginUser(event.getSession().getId());
            //系统操作日志
            SystemOperateLog systemOperateLog = new SystemOperateLog();
            systemOperateLog.setSessionId(event.getSession().getId());
            if (loginUserInfo.getModel() instanceof Manager)
            {
                Manager manager = (Manager) loginUserInfo.getModel();
                systemOperateLog.setUserId(manager.getManagerID());
            }
            systemOperateLog.setTargetObject("超时退出");
            systemOperateLog.setOperateDate(new Date());
            systemOperateLog.setOperateResult((short) 0);
            systemOperateLogDao.addModel(systemOperateLog);
        }
    }

}
