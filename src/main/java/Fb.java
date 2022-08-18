import java.util.ArrayList;
import java.util.Scanner;

public class Fb {
    public static void main(String[] args) {
        ArrayList<Post> postsArrayList = new ArrayList<Post>();
        postsArrayList.add(new Post(1, "Feeling High"));
        postsArrayList.add(new Post(2, "Hello World"));
        System.out.println(" Enter 1 to Login :");
        System.out.println(" Enter 2 to Exit :");

        Scanner scanner = new Scanner(System.in);
        int Choice = scanner.nextInt();
        if (Choice == 1) {
            System.out.println("Enter Your UserName :");
            String userName = scanner.next();
            System.out.println("Enter 1 to Create Post :");
            System.out.println("Enter 2 to View Post :");
            System.out.println("Enter 3 to Logout :");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter your Post");
                String post = scanner.next();
                postsArrayList.add(new Post(postsArrayList.size() + 1, post));
            } else if (choice == 2) {
                System.out.println("POST");
                postsArrayList.forEach(Post -> {
                    System.out.println(Post.getId() + " - " + Post.getPost());
                });

            } else if (choice == 3) {
                System.out.println("Thank You");
            } else {
                System.out.println("Invalid choice");
            }
        } else {
            System.exit(0);
        }
    }
}
