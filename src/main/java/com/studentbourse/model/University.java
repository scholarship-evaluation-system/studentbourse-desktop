package com.studentbourse.model;

public class University {

    private int id;
    private String name;
    private int rank;

    public University(int id, String name, int rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return name;
    }
}
