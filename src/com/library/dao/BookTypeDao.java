package com.library.dao;

import java.io.Serializable;
import java.util.List;

public interface BookTypeDao<T> extends AbstractDao<T>
{
    public List<T> queryListByLevel(Serializable level);
    
    public List<T> queryListByPID(Integer pid);
}
