import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sajad on 2/27/2017.
 */
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("a", "a", 0, "0"));
        users.add(new User("b", "b", 1, "1"));
        users.add(new User("c", "c", 2, "2"));
        users.add(new User("d", "d", 3, "3"));
        users.add(new User("e", "e", 4, "4"));
        users.add(new User("f", "f", 5, "5"));
        users.add(new User("g", "g", 6, "6"));
        users.add(new User("h", "h", 7, "7"));
        users.add(new User("i", "i", 8, "8"));
        users.add(new User("j", "j", 9, "9"));
        User user;
        while (true) {
            while (true) {
                System.out.print("ID: ");
                int id = input.nextInt();
                System.out.print("Password: ");
                String pass = input.next();
                user = login(id, pass, users);
                if (user != null) {
                    break;
                }
            }

            while (true) {
                System.out.println("****************************");
                System.out.println("1.show list");
                System.out.println("2.add friend");
                System.out.println("3.send massege");
                System.out.println("4.show massege");
                System.out.println("5.exit");
                System.out.print("please enter number: ");
                int i = input.nextInt();
                if (i == 1) {
                    System.out.println("****************************");
                    Map<User, ArrayList<Post>> friendslist = user.getFriends();
                    for (Map.Entry<User, ArrayList<Post>> entry : friendslist.entrySet()) {
                        System.out.println(entry.getKey().getId() + "." + entry.getKey().getName() + entry.getKey().getFamily());
                    }
                }
                if (i == 2) {
                    System.out.println("****************************");
                    System.out.print("please Enter ID: ");
                    int id = input.nextInt();
                    for (User u : users) {
                        if (u.getId() == id) {
                            user.addFriends(u);
                            u.addFriends(user);
                        }
                    }
                }
                if (i == 3) {
                    System.out.println("****************************");
                    Map<User, ArrayList<Post>> friendslist = user.getFriends();
                    for (Map.Entry<User, ArrayList<Post>> entry : friendslist.entrySet()) {
                        System.out.println(entry.getKey().getId() + "." + entry.getKey().getName() + entry.getKey().getFamily());
                    }
                    System.out.print("please enter number: ");
                    int id = input.nextInt();
                    Scanner in = new Scanner(System.in);
                    System.out.println("massege: ");
                    String str = in.nextLine();
                    Post post = new Post(user.getId(), id, str);
                    for (Map.Entry<User, ArrayList<Post>> entry : friendslist.entrySet()) {
                        if (entry.getKey().getId() == id) {
                            Map<User, ArrayList<Post>> friend = entry.getKey().getFriends();
                            for (Map.Entry<User, ArrayList<Post>> en : friend.entrySet()) {
                                if (en.getKey().getId() == user.getId()) {
                                    en.getValue().add(post);
                                }
                            }
                            entry.getValue().add(post);
                        }
                    }
                }
                if (i == 4) {
                    System.out.println("****************************");
                    Map<User, ArrayList<Post>> friendslist = user.getFriends();
                    for (Map.Entry<User, ArrayList<Post>> entry : friendslist.entrySet()) {
                        System.out.println(entry.getKey().getId() + "." + entry.getKey().getName() + entry.getKey().getFamily());
                    }
                    System.out.print("please enter number: ");
                    int id = input.nextInt();
                    for (Map.Entry<User, ArrayList<Post>> entry : friendslist.entrySet()) {
                        if (entry.getKey().getId() == id) {
                            ArrayList<Post> posts=entry.getValue();
                            for (Post post:posts) {
                                System.out.println(post.getMessage());
                            }
                        }
                    }
                }
                if (i == 5) {
                    break;
                }
            }
        }
    }

    public static User login(int id, String password, ArrayList<User> users) {
        for (User user : users) {
            if (user.getId() == id) {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }
}
