package pattern.facade;

/**
 * Created by Marcin on 2018-05-05.
 */
public class UserService {

    public Account getAccount() {
        return new Account("New Account");
    }

    public void changeUserName(){

    }
}
