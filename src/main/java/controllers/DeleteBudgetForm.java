package controllers;


import dao.BudgetDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteBudgetForm extends HttpServlet{

    private static ApplicationContext appC = new ClassPathXmlApplicationContext("spring-conf.xml");
    private BudgetDaoImplements bdi = (BudgetDaoImplements) appC.getBean("budgetDaoImplements");

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id;

        if (req.getParameter("deleteBudget") != null) {

            id = req.getParameter("deleteBudget");

            try {
                bdi.deleteBudget(Integer.parseInt(id));
                resp.sendRedirect("/deleteSuccess.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
