
package com.library.service.impl;

import java.util.List;

import com.library.dao.BookTypeDao;
import com.library.dao.impl.BookTypeDaoImpl;
import com.library.domain.BookType;
import com.library.service.BookTypeService;

public class BookTypeServiceImpl implements BookTypeService<BookType>
{
    private BookTypeDao<BookType> bookTypeDao = new BookTypeDaoImpl();

    @Override
    public List<BookType> queryListByPID(Integer pid)
    {
        return bookTypeDao.queryListByPID(pid);
    }

    @Override
    public List<BookType> queryListByLevel(Integer level)
    {
        return bookTypeDao.queryListByLevel(level);
    }

    @Override
    public Integer addBookType(BookType t)
    {
        return bookTypeDao.addModel(t);
    }

    @Override
    public BookType queryById(BookType t)
    {
        return bookTypeDao.getModel(t);
    }

    @Override
    public boolean updateBookType(BookType t)
    {
        return bookTypeDao.updateModel(t) == null ? false : true;
    }

    @Override
    public boolean deleteBookType(BookType t)
    {
        return bookTypeDao.deleteModel(t) == null ? false : true;
    }

}
