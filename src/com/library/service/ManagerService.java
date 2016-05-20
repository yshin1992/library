package com.library.service;

public interface ManagerService<T> extends AbstractService<T>
{
    public boolean updateManager(T t);
}
