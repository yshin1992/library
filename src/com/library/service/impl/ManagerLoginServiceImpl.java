
package com.library.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.library.cache.SystemCache;
import com.library.dao.ManagerDao;
import com.library.dao.SystemOperateLogDao;
import com.library.dao.impl.ManagerDaoImpl;
import com.library.dao.impl.SystemOperateLogDaoImpl;
import com.library.domain.Manager;
import com.library.entity.LoginUserInfo;
import com.library.entity.SystemOperateLog;
import com.library.service.LoginService;

public class ManagerLoginServiceImpl implements LoginService<LoginUserInfo>
{
    private ManagerDao<Manager> managerDao;

    private SystemOperateLogDao<SystemOperateLog> systemOperateLogDao;

    public ManagerLoginServiceImpl()
    {
        managerDao = new ManagerDaoImpl();
        systemOperateLogDao = new SystemOperateLogDaoImpl();
    }

    @Override
    public LoginUserInfo login(String userId , String password , HttpServletRequest request)
    {
        LoginUserInfo loginUserInfo = null;
        Manager manager = new Manager();
        manager.setManagerID(userId);
        manager.setPassword(password);
        manager = managerDao.getModel(manager);
        Date operateDate = new Date();
        if (manager != null)
        {
            loginUserInfo = new LoginUserInfo();
            loginUserInfo.setSessionId(request.getSession().getId());
            loginUserInfo.setModel(manager);
            loginUserInfo.setLoginIp(request.getRemoteAddr());
            loginUserInfo.setLoginTime(operateDate);
            SystemCache.getInstance().putLoginUserInfo(loginUserInfo);
        }
        //系统操作日志
        SystemOperateLog systemOperateLog = new SystemOperateLog();
        //        getRemoteAddr方法返回发出请求的客户机的IP地址 
        //        getRemoteHost方法返回发出请求的客户机的完整主机名
        //        getRemotePort方法返回客户机所使用的网络端口号
        systemOperateLog.setIp(request.getRemoteAddr());
        systemOperateLog.setSessionId(request.getSession().getId());
        systemOperateLog.setUserId(userId);
        systemOperateLog.setTargetObject("登录");
        systemOperateLog.setOperateDate(operateDate);
        systemOperateLog.setUrl(request.getRequestURL().toString());
        systemOperateLog.setAcceptLanguage(request.getHeader("Accept-Language"));
        systemOperateLog.setUserAgent(request.getHeader("User-Agent"));
        if (manager != null)
        {
            //0代表登录操作成功
            systemOperateLog.setOperateResult((short) 0);
        }
        else
        {
            //1代表登录操作失败
            systemOperateLog.setOperateResult((short) 1);
        }
        systemOperateLogDao.addModel(systemOperateLog);
        return loginUserInfo;
    }

    @Override
    public void logout(HttpServletRequest request , String targetObject)
    {
        String sessionId = request.getSession().getId();
        LoginUserInfo loginUserInfo = SystemCache.getInstance().getLoginUserWithSessionId(sessionId);
        Manager manager = (Manager) loginUserInfo.getModel();
        //系统操作日志
        SystemOperateLog systemOperateLog = new SystemOperateLog();
        //        getRemoteAddr方法返回发出请求的客户机的IP地址 
        //        getRemoteHost方法返回发出请求的客户机的完整主机名
        //        getRemotePort方法返回客户机所使用的网络端口号
        systemOperateLog.setIp(request.getRemoteAddr());
        systemOperateLog.setSessionId(request.getSession().getId());
        systemOperateLog.setUserId(manager.getManagerID());
        systemOperateLog.setTargetObject(targetObject);
        systemOperateLog.setOperateDate(new Date());
        systemOperateLog.setUrl(request.getRequestURL().toString());
        systemOperateLog.setAcceptLanguage(request.getHeader("Accept-Language"));
        systemOperateLog.setUserAgent(request.getHeader("User-Agent"));
        //0代表登录操作成功
        systemOperateLog.setOperateResult((short) 0);
        systemOperateLogDao.addModel(systemOperateLog);
        //从系统缓存中移除该用户
        SystemCache.getInstance().removeLoginUser(sessionId);
    }

}
