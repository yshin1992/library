
package com.library.service.impl;

import java.util.List;

import com.library.dao.BookTypeDao;
import com.library.domain.BookType;
import com.library.service.QueryBookTypeService;

public class QueryBookTypeServiceImpl implements QueryBookTypeService<BookType>
{
    private BookTypeDao<BookType> bookTypeDao;

    public QueryBookTypeServiceImpl(BookTypeDao<BookType> bookTypeDao)
    {
        this.bookTypeDao = bookTypeDao;
    }

    @Override
    public List<BookType> queryListByPid(Integer pid)
    {
        return bookTypeDao.queryListByLevel(pid);
    }

}
