package service;

import model.Post;
import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PostMenu implements PostMenuInterface {

    private User loggedInUser;
    private Scanner scanner;
    private MainMenu mainMenu;

    public PostMenu(User loggedInUser, MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.loggedInUser = loggedInUser;
        scanner = new Scanner(System.in);
    }

    @Override
    public void printPostMenu() {
        while (true) {
            System.out.println("1. Create Post");
            System.out.println("2. View Post");
            System.out.println("3. Logout");
            System.out.println("Enter Your Choice:");
            int choice = scanner.nextInt();

            if (choice == 1) {
                ArrayList<Post> posts = loggedInUser.getPostArrayList();

                System.out.println("Enter your post");
                String userPostString = scanner.next();

                Post post = new Post(loggedInUser.getPostArrayList().size() + 1, userPostString, new Date());
                posts.add(post);

                System.out.println("Post added!");
            } else if (choice == 2) {
                if (loggedInUser.getPostArrayList().size() > 0) {
                    loggedInUser.getPostArrayList().forEach(post -> {
                        System.out.println(post.getId() + " - " + post.getPost() + " - " + post.getDate());
                    });
                } else {
                    System.out.println("No post to show");
                }
            } else if (choice == 3) {
                mainMenu.printMainMenu();
            } else {
                System.out.println("Invalid Choice");
            }

        }
    }

}
