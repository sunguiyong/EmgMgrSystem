package com.cheer.web.myweb.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "updateEmp", urlPatterns = {"/servlet/updateEmp"})
public class UpdateEmp extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public UpdateEmp()
    {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        request.setCharacterEncoding("utf-8");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }

}
