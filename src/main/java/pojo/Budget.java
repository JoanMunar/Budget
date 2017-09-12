package pojo;

import java.util.Date;

/**
 * Created by jmunarb on 29/06/17.
 */
public class Budget {

    int id_budget;
    Date date;


    public Budget(int id_budget) {
        this.id_budget = id_budget;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_budget() {
        return id_budget;
    }

    public void setId_budget(int id_budget) {
        this.id_budget = id_budget;
    }

}
