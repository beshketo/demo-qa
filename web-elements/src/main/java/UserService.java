import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(1, "Anna"));
        users.add(new User(2, "Vlad"));
    }

    public String getUserName(int expectedId) throws UserNotFoundException{
        for (User user : users) {
            if (user.getId() == expectedId){
                return user.getName();
            }
        }
        throw new UserNotFoundException("User with id " + expectedId + " isn't found");
    }
}
