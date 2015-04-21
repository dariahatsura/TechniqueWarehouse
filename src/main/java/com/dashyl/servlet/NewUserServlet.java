package com.dashyl.servlet;

import com.dashyl.DAO.UserDAO;
import com.dashyl.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Darya on 20.04.2015.
 */
@WebServlet("/new_user")
public class NewUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("static/jsp/new_user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        UserDAO userService = new UserDAO();
        userService.save(new User(user));
        resp.sendRedirect("");
    }
}