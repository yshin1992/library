
package com.library.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.library.util.C3P0DBUtil;
import com.mchange.v2.c3p0.PooledDataSource;

//@WebFilter(filterName="dataSourceFilter",urlPatterns="/*")
public class DataSourceFilter implements Filter
{
    private DataSource ds;

    private static Logger logger = Logger.getLogger(DataSourceFilter.class);

    @Override
    public void destroy()
    {
        
    }

    @Override
    public void doFilter(ServletRequest arg0 , ServletResponse arg1 , FilterChain arg2) throws IOException,
            ServletException
    {
        arg2.doFilter(arg0, arg1);
        try
        {
            logger.debug("空闲的连接: " + ((PooledDataSource) ds).getNumIdleConnectionsDefaultUser());
            logger.debug("使用中的连接: " + ((PooledDataSource) ds).getNumBusyConnectionsDefaultUser());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
        ds = C3P0DBUtil.getDataSource();
    }

}
