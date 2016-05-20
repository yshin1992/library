
package com.library.dao.impl;

import java.io.Serializable;

import com.library.dao.SystemOperateLogDao;
import com.library.entity.SystemOperateLog;
import com.library.util.DBTemplate;

public class SystemOperateLogDaoImpl implements SystemOperateLogDao<SystemOperateLog>
{

    private static final String INSERT_OPERATE_LOG = "insert into operatelog values(null,?,?,?,?,?,?,?,?,?)";

    private static final String QUERY_OPERATE_LOG = "select * from operatelog where aiid=?";

    @Override
    public Integer addModel(SystemOperateLog t)
    {
        Object[] params = { t.getUserId(), t.getSessionId(), t.getIp(), t.getUrl(), t.getTargetObject(),
                t.getUserAgent(), t.getAcceptLanguage(), t.getOperateDate(), t.getOperateResult() };
        DBTemplate.executeUpdate(INSERT_OPERATE_LOG, params);
        return 0;
    }

    /**
     * 日志删除操作不要做具体的实现
     */
    @Override
    public final Integer deleteModel(SystemOperateLog t)
    {
        return 0;
    }

    /**
     * 日志更新操作不要做具体的实现
     */
    @Override
    public final Integer updateModel(SystemOperateLog t)
    {
        return 0;
    }

	@Override
	public SystemOperateLog getModel(Serializable t) {
		Object[] params ={t};
        return (SystemOperateLog) DBTemplate.queryForObject(QUERY_OPERATE_LOG, params, SystemOperateLog.class);
	}

}
