package controllers;


import dao.BudgetDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.BudgetLine;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BudgetLineControllerForm extends HttpServlet {

    private List<BudgetLine> budgetLine = new ArrayList<BudgetLine>();
    private Date budgetDate;
    private static ApplicationContext appC = new ClassPathXmlApplicationContext("spring-conf.xml");

    private BudgetDaoImplements bdi = (BudgetDaoImplements) appC.getBean("budgetDaoImplements");

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id_budget = Integer.parseInt(req.getParameter("id"));
        RequestDispatcher rd = null;

        try {
            budgetLine = bdi.budgetLineId(id_budget);
            budgetDate = bdi.getDate(id_budget);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rd = req.getRequestDispatcher("/budgetLine.jsp");

        req.setAttribute("bLine", budgetLine);
        req.setAttribute("date", budgetDate);


        rd.forward(req, resp);
    }

}