package controllers;


import dao.BudgetDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


import java.util.Date;


public class CreateBudgetControllerForm extends HttpServlet {

    private static ApplicationContext appC = new ClassPathXmlApplicationContext("spring-conf.xml");
    private BudgetDaoImplements bdi = (BudgetDaoImplements) appC.getBean("budgetDaoImplements");

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user;
        int id_user;
        Date ld = new Date();

        //Id usuari
        HttpSession session = req.getSession();
        user = (User) session.getAttribute("user");
        id_user = user.getId();

        //Obtenir data en yyyy-MM
        Date date = new java.sql.Date(ld.getTime());

        if(date != null) {
            Integer idBudget = null;
            try {
                 idBudget = bdi.createBudget(date, id_user);
            } catch (SQLException e) {
                e.printStackTrace();
                resp.sendRedirect("/createError.jsp");
            }


            session.setAttribute("idBudget",idBudget);

            resp.sendRedirect("/createSuccess.jsp");

        }else {
            resp.sendRedirect("/createError.jsp");
        }
    }

}