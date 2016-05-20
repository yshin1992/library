
package com.library.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 借助第三方工具类org.apache.commons.beanutils进行转换 
*@author YanShuai
*@version 1.0,2015年7月16日
*@See
*@since V1.0
 */
public class Map2BeanUtil
{

    public static Object map2Object(Map<String, Object> map , Class<?> clazz) throws InstantiationException,
            IllegalAccessException, InvocationTargetException
    {
        if (map == null)
        {
            return null;
        }
        Object obj = clazz.newInstance();

        BeanUtils.populate(obj, map);

        return obj;
    }

    public static Object stringMap2Object(Map<String, String[]> map , Class<?> clazz) throws InstantiationException,
            IllegalAccessException, InvocationTargetException
    {
        if (map == null)
        {
            return null;
        }
        Object obj = clazz.newInstance();

        BeanUtils.populate(obj, map);

        return obj;
    }

    public static Map<?, ?> object2Map(Object obj) throws InstantiationException, IllegalAccessException
    {
        if (obj == null)
        {
            return null;
        }
        return new BeanMap(obj);
    }
}
