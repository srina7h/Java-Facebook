public class Post {
    public Post() {
    }

    private int id;
    private String post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Post(int id, String post) {
        this.id = id;
        this.post = post;
    }
}
