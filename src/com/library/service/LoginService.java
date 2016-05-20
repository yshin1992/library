package com.library.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService<T> extends AbstractService<T>
{
    public T login(String userId,String password,HttpServletRequest request);
    
    public void logout(HttpServletRequest request,String targetObject);
}
