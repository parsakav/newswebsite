package org.example;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String pass;
    private int role_id;

    public User(){

    }
    public User(String name, String pass, int role_id) {
        this.name = name;
        this.pass = pass;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
