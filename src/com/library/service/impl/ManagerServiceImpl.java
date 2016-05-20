
package com.library.service.impl;

import com.library.dao.ManagerDao;
import com.library.dao.impl.ManagerDaoImpl;
import com.library.domain.Manager;
import com.library.service.ManagerService;

public class ManagerServiceImpl implements ManagerService<Manager>
{
    private ManagerDao<Manager> managerDao;
    
    public ManagerServiceImpl()
    {
        managerDao = new ManagerDaoImpl();
    }

    @Override
    public boolean updateManager(Manager t)
    {
        return managerDao.updateModel(t) == 1 ? true : false;
    }

}
