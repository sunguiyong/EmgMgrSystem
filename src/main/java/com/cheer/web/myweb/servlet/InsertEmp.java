package com.cheer.web.myweb.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;

import com.cheer.web.domain.Emp;
import com.cheer.web.service.EmpService;


@WebServlet(name = "insertEmp", urlPatterns = {"/servlet/insertEmp"})
public class InsertEmp extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(InsertEmp.class);

    private static final long serialVersionUID = 1L;

    public InsertEmp()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        request.setCharacterEncoding("utf-8");
        String empno = request.getParameter("empno");
        String ename = request.getParameter("ename");
        EmpService empService = (EmpService)this.getServletContext().getAttribute("empService");
        Emp emp = new Emp();
        emp.setEmpno(Integer.valueOf(empno));
        emp.setEname(ename);
        empService.save(emp);

        response.sendRedirect("../index.jsp");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }

}
