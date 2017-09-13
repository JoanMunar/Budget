package controllers;


import dao.BudgetDaoImplements;
import models.Authenticator;
import models.Status;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Budget;
import pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BudgetControllerForm extends HttpServlet {

    private List<Budget> budgetList = new ArrayList<Budget>();

    private static ApplicationContext appC = new ClassPathXmlApplicationContext("spring-conf.xml");
    private BudgetDaoImplements bdi = (BudgetDaoImplements) appC.getBean("budgetDaoImplements");

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("user");
        String password = req.getParameter("password");
        RequestDispatcher rd = null;

        try {
            Authenticator authenticator = new Authenticator();
            Status result = authenticator.authenticate(userName, password);

                if (Status.SUCCESS.equals(result)) {

                    HttpSession session = req.getSession();
                    User user = bdi.getUser(userName);
                    session.setAttribute("user", user);

                    resp.sendRedirect("/Home");

                } else {
                    rd = req.getRequestDispatcher("/error.jsp");
                    rd.forward(req, resp);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}