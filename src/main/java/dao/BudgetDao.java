package dao;
import pojo.Budget;
import pojo.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface BudgetDao {

    int createBudget(Date data,int id_user) throws SQLException;
    void createBudgetLine(String name, int units, double price, int id_budget) throws SQLException;
    void deleteBudget(int id) throws SQLException;
    User getUser(String user) throws SQLException;
    List<Budget> budgetIdList(int userCode) throws SQLException;
    Date getDate(int userCode) throws SQLException;
}
