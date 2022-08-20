package service;

import Util.Authenticator;
import Util.ReadInput;
import Util.UserUtils;
import model.User;

import java.util.ArrayList;

public class MainMenu implements MainMenuInterface {

    private ArrayList<User> users;
    private Authenticator authenticator;
    private UserUtils userUtils;

    public MainMenu(UserUtils userUtils, Authenticator authenticator) {
        this.userUtils = userUtils;
        this.authenticator = authenticator;
        users = userUtils.getUsers();
    }

    @Override
    public void printMainMenu() {

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");

            int choice = ReadInput.getScanner().nextInt();

            if (choice == 1) {
                System.out.println("UserName:");
                String userName = ReadInput.getScanner().next();
                System.out.println("Password:");
                String password = ReadInput.getScanner().next();

                boolean isUserExists = users.stream().anyMatch(user ->
                        (user.getUsername().equals(userName)) && (user.getPassword().equals(password))
                );

                if (isUserExists) {
                    User loggedInUser = users.stream().filter(user ->
                                    (user.getUsername().equals(userName)) && (user.getPassword().equals(password)))
                            .findFirst()
                            .get();
                    authenticator.setLoggedInUser(loggedInUser);
                    break;
                } else {
                    System.out.println("Invalid user!!!");
                }

            } else if (choice == 2) {
                printRegister();
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
        }

    }

    @Override
    public void printRegister() {
        System.out.println("UserName:");
        String userName = ReadInput.getScanner().next();
        System.out.println("Email:");
        String email = ReadInput.getScanner().next();
        System.out.println("Password:");
        String password = ReadInput.getScanner().next();

        boolean isUserExists = users.stream().anyMatch(user ->
                (user.getUsername().equals(userName)) && (user.getEmail().equals(email))
        );

        if (isUserExists) {
            System.out.println("User already exists");
        } else {
            User newUser = new User();
            newUser.setId(users.size() + 1);
            newUser.setEmail(email);
            newUser.setUsername(userName);
            newUser.setPassword(password);
            users.add(newUser);

            System.out.println("Registration Successful!");
        }
    }
}

