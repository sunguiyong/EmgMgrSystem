/*
 * 文件名：DiListener.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月28日
 */

package com.cheer.web.myweb.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.web.dao.DeptDao;
import com.cheer.web.dao.EmpDao;
import com.cheer.web.dao.impl.DeptDaoImpl;
import com.cheer.web.dao.impl.EmpDaoImpl;
import com.cheer.web.service.EmpService;
import com.cheer.web.service.impl.EmpServiceImpl;

@WebListener
public class BeanRegistListener implements ServletContextListener
{

    private static final Logger LOGGER = LogManager.getLogger(BeanRegistListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        LOGGER.info("ServletContext Listener......");
        ServletContext application = sce.getServletContext();

        DeptDao deptDao = new DeptDaoImpl();
        EmpDao empDao = new EmpDaoImpl(deptDao);

        EmpService empService = new EmpServiceImpl(empDao);

        application.setAttribute("empService", empService);
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }

}
