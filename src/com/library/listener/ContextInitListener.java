package com.library.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.library.cache.SystemCache;
import com.library.service.impl.SysFuncServiceImpl;
import com.library.util.C3P0DBUtil;

@WebListener
public class ContextInitListener implements ServletContextListener {

	private DataSource ds;

	private static Logger logger = Logger.getLogger(ContextInitListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		C3P0DBUtil.closeDataSource(ds);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.debug(event.getServletContext().getInitParameter("webAppRootKey")+"系统启动");
		logger.debug("初始化连接池");
		ds = C3P0DBUtil.getDataSource();
		logger.debug("初始化连接池成功");
		logger.debug("加载系统缓存...");
		SystemCache.getInstance().setSysFuncMap(new SysFuncServiceImpl().queryTopFunc());
		logger.debug("加载系统缓存成功");
	}

}
