package controllers;

import dao.BudgetDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class CreateBudgetLineControllerForm extends HttpServlet {

    private static ApplicationContext appC = new ClassPathXmlApplicationContext("spring-conf.xml");
    private BudgetDaoImplements bdi = (BudgetDaoImplements) appC.getBean("budgetDaoImplements");

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String units = req.getParameter("units");
        String price = req.getParameter("price");

        HttpSession session = req.getSession();
        Integer id = (Integer) session.getAttribute("idBudget");

        if(name != null || units != null || price != null) {

            try {
                bdi.createBudgetLine(name, Integer.parseInt(units), Double.parseDouble(price.replaceAll(",",".")), id);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            resp.sendRedirect("/createSuccess.jsp");

        }else {
            resp.sendRedirect("/errorForm.jsp");
        }

    }
}
