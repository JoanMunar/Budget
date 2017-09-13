package controllers;

import dao.BudgetDaoImplements;
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

/**
 * Created by jmunarb on 12/09/17.
 */
public class HomeController extends HttpServlet{

    private List<Budget> budgetList = new ArrayList<Budget>();
    private static ApplicationContext appC = new ClassPathXmlApplicationContext("spring-conf.xml");
    private BudgetDaoImplements bdi = (BudgetDaoImplements) appC.getBean("budgetDaoImplements");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = null;

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        try {
            budgetList = bdi.budgetIdList(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rd = req.getRequestDispatcher("/budgets.jsp");

        req.setAttribute("bList", budgetList);

        rd.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
