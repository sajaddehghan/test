import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sajad on 2/27/2017.
 */
public class User {
    private String name;
    private String family;
    private int id;
    private String password;
    private Map<User,ArrayList<Post>> friends=new HashMap<>();

    public User(String name, String family, int id, String password) {
        this.name = name;
        this.family = family;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Map<User, ArrayList<Post>> getFriends() {
        return friends;
    }

    public void addFriends(User user) {
        ArrayList<Post> post=new ArrayList<>();
        friends.put(user,post);
    }
}
