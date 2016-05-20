
package com.library.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSet2BeanUtil
{

    public static Object resultSet2Bean(ResultSet rs , Class<?> clazz) throws SQLException, InstantiationException,
            IllegalAccessException, InvocationTargetException
    {
        if (rs == null)
        {
            return null;
        }
        ResultSetMetaData rsmd = rs.getMetaData();
        Object obj = null;
        if (rs.next())
        {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
            {
                map.put(rsmd.getColumnName(i), rs.getObject(i));
            }
            obj = Map2BeanUtil.map2Object(map, clazz);
        }
        return obj;
    }

    public static List<? extends Object> resultSet2List(ResultSet rs , Class<?> clazz) throws SQLException,
            InstantiationException, IllegalAccessException, InvocationTargetException
    {
        if (rs == null)
        {
            return null;
        }
        ResultSetMetaData rsmd = rs.getMetaData();
        List<Object> resList = new ArrayList<Object>();
        while (rs.next())
        {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
            {
                map.put(rsmd.getColumnName(i), rs.getObject(i));
            }
            resList.add(Map2BeanUtil.map2Object(map, clazz));
        }
        return resList;
    }
}
