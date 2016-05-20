
package com.library.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DBTemplate
{
    private static Logger logger = Logger.getLogger(DBTemplate.class);

    /**
     * 更新,删除都调用此方法
     * @param sql
     * @param params
     * @return
     */
    public static Integer executeInsert(String sql , Object[] params)
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        try
        {
            con = C3P0DBUtil.getConnection();
            pstm = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            if (params != null)
            {
                for (int i = 0; i < params.length; i++)
                {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            int exeResult = pstm.executeUpdate();
            if(exeResult==1){
                rs= pstm.getGeneratedKeys();
                if(rs.next()){
                    return rs.getInt(1);
                }
            }else{
                return null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            C3P0DBUtil.attemptClose(pstm);
            C3P0DBUtil.attemptClose(con);
        }
        return null;
    }
    
    /**
     * 更新,删除都调用此方法
     * @param sql
     * @param params
     * @return
     */
    public static Integer executeUpdate(String sql , Object[] params)
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try
        {
            con = C3P0DBUtil.getConnection();
            pstm = con.prepareStatement(sql);
            if (params != null)
            {
                for (int i = 0; i < params.length; i++)
                {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            int exeResult = pstm.executeUpdate();
            return exeResult;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            C3P0DBUtil.attemptClose(pstm);
            C3P0DBUtil.attemptClose(con);
        }
        return 0;
    }

    /**
     * 实现方案一
     * @param sql
     * @param params
     * @param clazz
     * @return
     */

    public static Object queryForObject(String sql , Object[] params , Class<?> clazz)
    {
        Object obj = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try
        {
            con = C3P0DBUtil.getConnection();
            pstm = con.prepareStatement(sql);
            if (params != null)
            {
                for (int i = 0; i < params.length; i++)
                {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            rs = pstm.executeQuery();
            obj = ResultSet2BeanUtil.resultSet2Bean(rs, clazz);
        }
        catch (SQLException e)
        {
            logger.error("执行SQL语句出现异常！");
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            logger.error("实例化对象出现异常！");
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            logger.error("访问实例属性出现异常！");
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            logger.error("实现实例方法出现异常！");
            e.printStackTrace();
        }
        finally
        {
            C3P0DBUtil.attemptClose(rs);
            C3P0DBUtil.attemptClose(pstm);
            C3P0DBUtil.attemptClose(con);
        }
        return obj;
    }

    public static List<? extends Object> queryForList(String sql , Object[] params , Class<?> clazz)
    {
        List<? extends Object> resList = new ArrayList<Object>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try
        {
            con = C3P0DBUtil.getConnection();
            pstm = con.prepareStatement(sql);
            if (params != null)
            {
                for (int i = 0; i < params.length; i++)
                {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            rs = pstm.executeQuery();
            resList = ResultSet2BeanUtil.resultSet2List(rs, clazz);

        }
        catch (SQLException e)
        {
            logger.error("执行SQL语句出现异常！");
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            logger.error("实例化对象出现异常！");
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            logger.error("访问实例属性出现异常！");
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            logger.error("实现实例方法出现异常！");
            e.printStackTrace();
        }
        finally
        {
            C3P0DBUtil.attemptClose(rs);
            C3P0DBUtil.attemptClose(pstm);
            C3P0DBUtil.attemptClose(con);
        }
        return resList;
    }

    /**
     * 实现方案二
     * @param sql
     * @param params
     * @param mapper
     * @return
     */
//    public static Object queryForObject(String sql , Object[] params , ObjectMapper mapper)
//    {
//        Object obj = null;
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        try
//        {
//            con = C3P0DBUtil.getConnection();
//            pstm = con.prepareStatement(sql);
//            if (params != null)
//            {
//                for (int i = 0; i < params.length; i++)
//                {
//                    pstm.setObject(i + 1, params[i]);
//                }
//            }
//            rs = pstm.executeQuery();
//            obj = mapper.mapping(rs);
//        }
//        catch (SQLException e)
//        {
//            logger.error("执行SQL语句出现异常！");
//            e.printStackTrace();
//        }
//        finally
//        {
//            C3P0DBUtil.attemptClose(rs);
//            C3P0DBUtil.attemptClose(pstm);
//            C3P0DBUtil.attemptClose(con);
//        }
//        return obj;
//    }
//
//    public static List<? extends Object> queryForList(String sql , Object[] params , ObjectMapper mapper)
//    {
//        List<Object> resList = new ArrayList<Object>();
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        try
//        {
//            con = C3P0DBUtil.getConnection();
//            pstm = con.prepareStatement(sql);
//            if (params != null)
//            {
//                for (int i = 0; i < params.length; i++)
//                {
//                    pstm.setObject(i + 1, params[i]);
//                }
//            }
//            rs = pstm.executeQuery();
//            while (rs.next())
//            {
//                resList.add(mapper.mapping(rs));
//            }
//
//        }
//        catch (SQLException e)
//        {
//            logger.error("执行SQL语句出现异常！");
//            e.printStackTrace();
//        }
//        finally
//        {
//            C3P0DBUtil.attemptClose(rs);
//            C3P0DBUtil.attemptClose(pstm);
//            C3P0DBUtil.attemptClose(con);
//        }
//        return resList;
//    }

}
