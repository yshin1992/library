package com.library.service;

import java.util.Map;

public interface SysFuncService<T> extends AbstractService<T>
{
    public Map<Integer,T> queryTopFunc();
    
    public Map<Integer,T> queryFuncWithMgrID(String mgrID);
}
