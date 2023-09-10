package org.example;

import java.io.Serializable;

public class News implements Serializable {

    private int id;
    private String filepath;
private String title;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", filepath='" + filepath + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
