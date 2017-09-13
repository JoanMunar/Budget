package dao;


import com.mysql.jdbc.PreparedStatement;
import dbc.ConnectionFactory;
import pojo.Budget;
import pojo.BudgetLine;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BudgetDaoImplements implements BudgetDao{

    private ConnectionFactory dbc;


    public int createBudget(Date data, int id_user) throws SQLException {

        String sql = "INSERT into pfinal.budget VALUES(DEFAULT,?,?)";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        try {
            ps.setDate(1, (java.sql.Date) data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.setInt(2, id_user);

        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id_budget = rs.getInt(1);

        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
        return id_budget;
    }

    public void createBudgetLine(String name, int units, double price, int id_budget) throws SQLException {

        String sql = "INSERT into pfinal.budget_line VALUES(DEFAULT,?,?,?,?)";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1,name);
        ps.setInt(2, units);
        ps.setDouble(3, price);
        ps.setInt(4,id_budget);

        ps.execute();

        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
    }
    public void deleteBudget(int id_budget) throws SQLException {

        String sql = "DELETE FROM pfinal.budget WHERE id_budget=?";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1, id_budget);
        ps.execute();

        sql = "DELETE FROM pfinal.budget WHERE id_budget = ?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1, id_budget);
        ps.execute();

        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }

    }


    public User getUser(String user) throws SQLException {
        String sql = "SELECT * FROM pfinal.user where user='" + user +"'";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        if (rs.next() ) {

            int id = rs.getInt("user.id_user");
            String username = rs.getString("user.user");
            String pass = rs.getString("user.password");
            String phone = rs.getString("user.phone");

            User usuari = new User(id,username,pass,phone);


            return usuari;
        }
        return null;
    }


    public List<Budget> budgetIdList(int userCode) throws SQLException {
        String sql = "SELECT id_budget FROM pfinal.budget,pfinal.user WHERE budget.id_user=user.id_user and user.id_user=?";
        List<Budget> budgetList = new ArrayList<Budget>();

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1,userCode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int budgetId = rs.getInt("budget.id_budget");

            Budget budget = new Budget(budgetId);
            budgetList.add(budget);

        }
        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
        return budgetList;
    }

    public Date getDate(int id_budget) throws SQLException {
        String sql = "SELECT * FROM pfinal.budget WHERE budget.id_budget=?";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1,id_budget);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            Date budgetDate = rs.getDate("budget.date");

            return budgetDate;
        }
        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
        return null;
    }

    public List<BudgetLine> budgetLineId(int id_budget) throws SQLException {
        String sql = "SELECT * FROM pfinal.budget_line WHERE budget_line.id_budget=?";
        List<BudgetLine> budgetLine = new ArrayList<BudgetLine>();
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1,id_budget);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int budgetCode = rs.getInt("budget_line.code");
            String budgetName = rs.getString("budget_line.name");
            double budgetUnits = rs.getDouble("budget_line.units");
            double budgetPrice = rs.getDouble("budget_line.price");
            int budgetId = rs.getInt("budget_line.id_budget");

            BudgetLine budget_line = new BudgetLine(budgetCode, budgetName,budgetUnits, budgetPrice, budgetId);
            budgetLine.add(budget_line);

        }
        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
        return budgetLine;
    }


    public void setDbc(ConnectionFactory dbc) {
        this.dbc = dbc;
    }

}

