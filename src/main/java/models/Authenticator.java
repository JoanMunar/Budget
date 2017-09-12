package models;


import dao.BudgetDao;
import dao.BudgetDaoImplements;
import pojo.User;

import java.sql.SQLException;

/**
 * Created by jmunarb on 28/06/17.
 */
public class Authenticator {

    private BudgetDao budgetDao = new BudgetDaoImplements();

    public Status authenticate(String user, String password) throws SQLException {

        User usuari = budgetDao.getUser(user);

        if (usuari != null && (usuari.getUser().equals(user)) && (usuari.getPassword().equals(password)) ) {
            return Status.SUCCESS;
        } else {
            return Status.FAILURE;
        }
    }

}
