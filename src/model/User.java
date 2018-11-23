package model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String date;
    private String txt;
    private String id;
    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id, String username, String date, String txt){
        this.id = id;
        this.username = username;
        this.date = date;
        this.txt = txt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
