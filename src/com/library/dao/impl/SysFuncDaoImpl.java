
package com.library.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.dao.SysFuncDao;
import com.library.entity.SysFunc;
import com.library.util.DBTemplate;

public class SysFuncDaoImpl implements SysFuncDao<SysFunc>
{

    public static final String QUERY_FUNC_WITH_MGRID = "select * from sysfunc where aiid in (select funcid from role2func where roleid=(select roleid from manager2role where managerid='340121199209010442'));";

    @Override
    public Integer addModel(SysFunc t)
    {
        return 0;
    }

    @Override
    public Integer deleteModel(SysFunc t)
    {
        return 0;
    }

    @Override
    public Integer updateModel(SysFunc t)
    {
        return 0;
    }

	@Override
	public SysFunc getModel(Serializable t) {
		// TODO Auto-generated method stub
		return null;
	}
    
    @SuppressWarnings("unchecked")
    @Override
    public Map<Integer, SysFunc> queryTopFunc()
    {
        String sql = "select * from sysfunc where functype='Menu'";
        List<SysFunc> resList = (List<SysFunc>) DBTemplate.queryForList(sql, null, SysFunc.class);
        Map<Integer, SysFunc> map = null;
        if (resList != null)
        {
            map = new HashMap<Integer, SysFunc>();
            for (SysFunc sysFunc : resList)
            {
                map.put(sysFunc.getAiid(), sysFunc);
            }
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<Integer, SysFunc> queryFuncWithMgrID(String mgrID)
    {
        List<SysFunc> resList = (List<SysFunc>) DBTemplate.queryForList(QUERY_FUNC_WITH_MGRID, null, SysFunc.class);
        Map<Integer, SysFunc> map = null;
        if (resList != null)
        {
            map = new HashMap<Integer, SysFunc>();
            for (SysFunc sysFunc : resList)
            {
                map.put(sysFunc.getAiid(), sysFunc);
            }
        }
        return map;
    }

}
