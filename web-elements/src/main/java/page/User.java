package page;

import lombok.Getter;

public class User {
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter
    private String currentAddress;
    @Getter
    private String permanentAddress;

    public User(String name, String email, String currentAddress, String permanentAddress) {
        this.name = name;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    // User newUser = User.createUser("John", "john@example.com", "123 Main St", "456 Elm St");

}
