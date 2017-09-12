package pojo;



public class User {

    private String user;
    private String password;
    private String phone;
    private int id;


    public User(int id_user, String user, String password, String phone){

        this.id = id_user;
        this.user = user;
        this.password = password;
        this.phone = phone;


    }

    public User(String user, String password){
        this.user = user;
        this.password = password;

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
