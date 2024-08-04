package managers.AuthManager;

public interface AuthManagerInterface {
    void createUser(String login, String password, String repeatPassword);
    void authUser(String login, String password);
}
