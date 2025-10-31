public class Main{
    public void main (String[]args) throws UserNotFoundException {
        System.out.println("Hello world!");
        UserService userService = new UserService();
        User user = new User(1, "Anna");
        userService.getUserName(1);
    }
}
