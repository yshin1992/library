package com.library.service;

import java.util.List;

public interface BookTypeService<T> extends AbstractService<T>
{
    public List<T> queryListByPID(Integer pid);
    
    public List<T> queryListByLevel(Integer level);
    
    public Integer addBookType(T t);
    
    public T queryById(T t);
    
    public boolean updateBookType(T t);
    
    public boolean deleteBookType(T t);
}
