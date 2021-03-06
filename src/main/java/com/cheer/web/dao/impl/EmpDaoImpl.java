/*
 * 文件名：EmpDaoImpl.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月28日
 */

package com.cheer.web.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.web.dao.DeptDao;
import com.cheer.web.dao.EmpDao;
import com.cheer.web.domain.Dept;
import com.cheer.web.domain.Emp;
import com.cheer.web.util.DbHelper;
import com.cheer.web.util.Page;


public class EmpDaoImpl implements EmpDao
{
    private static final Logger LOGGER = LogManager.getLogger(EmpDaoImpl.class);

    private DeptDao deptDao;

    public EmpDaoImpl(DeptDao deptDao)
    {
        this.deptDao = deptDao;
    }

    @Override
    public void save(Emp emp)
    {
        Connection conn = DbHelper.getInstance().getConnection();

        PreparedStatement ps = null;
        try
        {
            String sql = "INSERT INTO emp(empno, ename) values(?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getEname());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        finally
        {
            DbHelper.closeStatement(ps);
        }
    }

    @Override
    public void batchSave(List<Emp> emps)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Emp emp)
    {
        Connection conn = DbHelper.getInstance().getConnection();

        String sql = "DELETE FROM emp WHERE empno = ?";

        PreparedStatement ps = null;

        int result = 0;
        try
        {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, emp.getEmpno());

            result = ps.executeUpdate();

            LOGGER.debug(sql);
            LOGGER.debug("删除{}条记录", result);
        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        finally
        {
            DbHelper.closeStatement(ps);
        }
    }

    @Override
    public void update(Emp emp)
    {
        Connection conn = DbHelper.getInstance().getConnection();
        String sql = "UPDATE emp SET ename = ? WHERE empno = ?";
        PreparedStatement ps = null;
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1, emp.getEname());
            ps.setInt(2, emp.getEmpno());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        finally
        {
            DbHelper.closeStatement(ps);
        }
        
    }

    @Override
    public Emp find(Integer empno)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Emp> getAll()
    {
        List<Emp> empList = new ArrayList<>();
        Connection conn = DbHelper.getInstance().getConnection();

        // String sql = "SELECT * FROM tbl_emp e LEFT OUT JOIN tbl_dept d ON(e.deptno = d.deptno)
        // ORDER BY empno";

        String sql = "SELECT * FROM emp ORDER BY empno";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Emp emp = null;
            while (rs.next())
            {
                emp = new Emp();

                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getDouble("sal"));
                emp.setComm(rs.getDouble("comm"));

                Dept dept = this.deptDao.find(rs.getInt("deptno"));
                emp.setDept(dept);

                empList.add(emp);
            }
        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        finally
        {
            DbHelper.closeResultSet(rs);
            DbHelper.closeStatement(ps);
        }

        return empList;
    }

    @Override
    public int getTotalCount()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Emp> getPage(Page page)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
