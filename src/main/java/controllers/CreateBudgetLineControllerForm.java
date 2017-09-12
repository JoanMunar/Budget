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


public class CreateBudgetLineControllerForm extends HttpServlet {

    private static ApplicationContext appC = new ClassPathXmlApplicationContext("spring-conf.xml");
    private BudgetDaoImplements bdi = (BudgetDaoImplements) appC.getBean("budgetDaoImplements");

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String units = req.getParameter("units");
        String price = req.getParameter("price");
        String id = "200";

        if(code != null || name != null || units != null || price != null) {

            try {
                bdi.createBudgetLine(Integer.parseInt(code), name, Integer.parseInt(units), Integer.parseInt(price), Integer.parseInt(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            resp.sendRedirect("/createSuccess.jsp");

        }else {
            resp.sendRedirect("/createError.jsp");
        }

    }
}
