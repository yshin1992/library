package com.library.service.impl;

import java.util.Map;

import com.library.dao.SysFuncDao;
import com.library.dao.impl.SysFuncDaoImpl;
import com.library.entity.SysFunc;
import com.library.service.SysFuncService;

public class SysFuncServiceImpl implements SysFuncService<SysFunc>
{
    private SysFuncDao<SysFunc> sysFuncDao=new SysFuncDaoImpl();

    @Override
    public Map<Integer, SysFunc> queryTopFunc()
    {
        return sysFuncDao.queryTopFunc();
    }

    @Override
    public Map<Integer, SysFunc> queryFuncWithMgrID(String mgrID)
    {
        return sysFuncDao.queryFuncWithMgrID(mgrID);
    }
    
    
}
