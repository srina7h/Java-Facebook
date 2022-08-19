package model;

import java.util.Date;

public class Post {
    private int id;
    private String post;

    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
