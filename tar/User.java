package tar;

public class User {
    private String username;
    private String password;
    private String email;

    public String get_pass(){
        return password;
    }

    public String get_user(){
        return username;
    }

    public String get_email(){
        return password;
    }

    void set_pass(String pass){
        this.password=pass;
    }

    void set_user(String user){
        this.username=user;
    }

    void set_email(String email){
        this.email=email;
    }
}
