/**
 * Created by sajad on 2/27/2017.
 */
public class Post {
    private int idstart;
    private int idend;
    private String message;

    public Post(int idstart, int idend, String messaige) {
        this.idstart = idstart;
        this.idend = idend;
        this.message = messaige;
    }

    public int getIdstart() {
        return idstart;
    }

    public void setIdstart(int idstart) {
        this.idstart = idstart;
    }

    public int getIdend() {
        return idend;
    }

    public void setIdend(int idend) {
        this.idend = idend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
