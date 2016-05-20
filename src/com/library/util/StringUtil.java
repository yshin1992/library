
package com.library.util;

public class StringUtil
{
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str)
    {
        if (str == null || "".equals(str.replaceAll("/\\s/g", "")))
            return true;
        return false;
    }
    
}
