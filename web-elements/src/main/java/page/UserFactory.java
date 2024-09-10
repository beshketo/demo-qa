package page;

public class UserFactory {



        public static User generateUser(String name, String email, String currentAddress, String permanentAddress) {
            return new User(name, email, currentAddress, permanentAddress);
        }


}
