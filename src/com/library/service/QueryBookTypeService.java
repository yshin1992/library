package com.library.service;

import java.util.List;

import com.library.domain.BookType;

public interface QueryBookTypeService<T> extends AbstractService<T>
{
    public List<BookType> queryListByPid(Integer pid);
}
