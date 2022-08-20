package Util;

import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Authenticator {
    private User loggedInUser;

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

}