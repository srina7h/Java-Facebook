import Util.Authenticator;
import Util.UserUtils;
import service.MainMenu;
import service.PostMenu;

public class Fb {
    public static void main(String[] args) {

        UserUtils userUtils = new UserUtils();
        Authenticator authenticator = new Authenticator();
        MainMenu mainMenu = new MainMenu(userUtils, authenticator);
        mainMenu.printMainMenu();

        if (authenticator.getLoggedInUser() != null) {
            PostMenu postMenu = new PostMenu(authenticator.getLoggedInUser(),mainMenu);
            postMenu.printPostMenu();
        } else {
            mainMenu.printMainMenu();
        }
    }
}
