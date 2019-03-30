package model;

import java.io.Serializable;

public class Genre implements Serializable {
    private int id;
    private String text;

    public Genre(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getID() {
        return id;
    }
}