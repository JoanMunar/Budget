package dao;
import pojo.Budget;
import pojo.Budget_line;
import pojo.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface BudgetDao {

    void createBudget(int id_budget, Date data,int id_user) throws SQLException;
    void createBudgetLine(int code, String name, int units, int price, int id_budget) throws SQLException;
    void deleteBudget(int id) throws SQLException;
    //List<Budget_line> budgetLine() throws SQLException;
    User getUser(String user) throws SQLException;
    List<Budget> budget(int userCode) throws SQLException;
    List<Budget> budgetId(int id) throws SQLException;
    Date getDate(int userCode) throws SQLException;
}
