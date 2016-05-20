package com.library.dao;

import java.io.Serializable;

public interface AbstractDao<T> {
	
	public Integer addModel(T t);
	
	public Integer deleteModel(T t);
	
	public T getModel(Serializable t);
	
	public Integer updateModel(T t);
}
