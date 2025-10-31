import org.testng.Assert;
import org.testng.annotations.Test;

public class UserServiceTest {

    @Test
    public void testGetUserName_found() throws UserNotFoundException {
        UserService service = new UserService();
        String name = service.getUserName(1);
        Assert.assertEquals(name, "Anna");
    }

    @Test(expectedExceptions = UserNotFoundException.class)
    public void testGetUserName_notFound() throws UserNotFoundException {
        UserService service = new UserService();
        service.getUserName(99); // цього користувача нема
    }
}