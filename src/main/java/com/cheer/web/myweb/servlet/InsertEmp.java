package com.cheer.web.myweb.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        String empno = request.getParameter("empno");

        EmpService empService = (EmpService)this.getServletContext().getAttribute("empService");

        Emp emp = new Emp();
        emp.setEmpno(Integer.valueOf(empno));

        empService.delete(emp);
        
        response.sendRedirect("../insert.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }

}
