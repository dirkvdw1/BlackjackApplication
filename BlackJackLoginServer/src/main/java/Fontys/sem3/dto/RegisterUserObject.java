package Fontys.sem3.dto;

public class RegisterUserObject {

    private String name;
    private String password;

    public RegisterUserObject(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public RegisterUserObject() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
