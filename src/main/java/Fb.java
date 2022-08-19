import Util.Authenticator;
import model.User;

import java.util.Scanner;

public class Fb {
    public static void main(String[] args){
        Authenticator aun = new Authenticator();
        aun.mainMenu();

        User loggedInUser = aun.getLoggedInUser();
    }
}
