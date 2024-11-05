package page;

public class User {

    private String name;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    public User(String name, String email, String currentAddress, String permanentAddress) {
        this.name = name;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCurrentAddress() {
        return currentAddress;
    }
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }
    public String getPermanentAddress() {
        return permanentAddress;
    }
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    // Статичний метод для створення нового користувача
    public static User createUser(String name, String lastname, String userName, String password) {
        return new User(name, lastname, userName, password);
    }

}
