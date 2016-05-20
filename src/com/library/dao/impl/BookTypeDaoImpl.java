package com.library.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.library.dao.BookTypeDao;
import com.library.domain.BookType;
import com.library.util.DBTemplate;

public class BookTypeDaoImpl implements BookTypeDao<BookType> {

	private static final String QUERY_BOOKTYPE = "select id,typeName,days,fine,parentId,level from BookType where id=?";

	private static final String DELETE_BOOKTYPE = "delete from BookType where id=?";

	private static final String UPDATE_BOOKTYPE = "update BookType set typeName=?,days=?,fine=?,parentId=?,level=? where id=?";

	private static final String INSERT_BOOKTYPE = "insert into BookType(typeName,days,fine,parentId,level) values(?,?,?,?,?)";

	private static final String QUERY_BY_LEVEL = "select id,typeName,days,fine,parentId,level from BookType where level=?";

	private static final String QUERY_BY_PID = "select id,typeName,days,fine,parentId,level from BookType where parentId=?";

	@Override
	public Integer addModel(BookType t) {
		Object[] params = { t.getTypeName(), t.getDays(), t.getFine(), t.getParentId(), t.getLevel() };
		return DBTemplate.executeInsert(INSERT_BOOKTYPE, params);
	}

	@Override
	public Integer deleteModel(BookType t) {
		Object[] params = { t.getId() };
		return DBTemplate.executeUpdate(DELETE_BOOKTYPE, params);
	}

	@Override
	public Integer updateModel(BookType t) {
		Object[] params = { t.getTypeName(), t.getDays(), t.getFine(), t.getParentId(), t.getLevel(), t.getId() };
		return DBTemplate.executeUpdate(UPDATE_BOOKTYPE, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookType> queryListByPID(Integer pid) {
		if (null != pid) {
			Object[] params = { pid };
			return (List<BookType>) DBTemplate.queryForList(QUERY_BY_PID, params, BookType.class);
		}
		return null;
	}

	@Override
	public BookType getModel(Serializable t) {
		Object[] params = { t };
		BookType bookType = (BookType) DBTemplate.queryForObject(QUERY_BOOKTYPE, params, BookType.class);
		return bookType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookType> queryListByLevel(Serializable level) {
		if (null != level) {
			Object[] params = { level };
			return (List<BookType>) DBTemplate.queryForList(QUERY_BY_LEVEL, params, BookType.class);
		}
		return null;
	}

}
