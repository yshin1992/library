package com.library.dao;

import java.util.Map;

public interface SysFuncDao<T> extends AbstractDao<T>
{
    /**
     * 获取所有一级菜单
     * @return
     */
    public Map<Integer,T> queryTopFunc();
    
    /**
     * 获取管理员可以使用的菜单及菜单项
     * @param mgrID
     * @return
     */
    public Map<Integer,T> queryFuncWithMgrID(String mgrID);
}
