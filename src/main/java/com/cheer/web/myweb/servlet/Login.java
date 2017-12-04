package com.cheer.web.myweb.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.web.domain.User;


@WebServlet(name = "login", urlPatterns = {"/servlet/login"})
public class Login extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(Login.class);

    private static final long serialVersionUID = 1L;

    public Login()
    {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet() method is invoked...");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> list = Db.getAll();
        for (User user : list)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                HttpSession session = request.getSession();
                request.getSession().setAttribute("user", user);
                session.setAttribute("isLogin", true);
                response.sendRedirect("../index.jsp");
                return;
            }
        }
        response.sendRedirect("../error.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }

}


class Db
{
    public static List<User> list = new ArrayList<User>();
    static
    {
        list.add(new User("admin", "admin"));
        list.add(new User("sun", "123"));
        list.add(new User("sunguiyong", "123"));
    }

    public static List<User> getAll()
    {
        return list;
    }
}
