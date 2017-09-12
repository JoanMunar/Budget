package pojo;


public class Budget_line {

    private int code;
    private String name;
    private double units;
    private double price;
    private int id;

    public Budget_line(int budgetCode, String budgetName, double budgetUnits, double budgetPrice, int budgetId) {

            this.code = budgetCode;
            this.name = budgetName;
            this.units = budgetUnits;
            this.price = budgetPrice;
            this.id = budgetId;
    }

    public Budget_line(int budgetId){
        this.code = budgetId;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {return id; }

    public void setId(int id) {this.id = id; }
}
