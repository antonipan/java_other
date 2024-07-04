package homework3.users;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;
    boolean isAdmin = false;

    public boolean getIsAuthenticate() {
        return isAuthenticate;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }

    public void setAdmin() {
        if(isAuthenticate){
            this.isAdmin = true;
        } else {
            System.out.println("Пользователь не авторизован, чтобы назначить его администратором");
        }
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        this.isAuthenticate = this.name.equals(name) && this.password.equals(password);
        return this.isAuthenticate;
    }

}