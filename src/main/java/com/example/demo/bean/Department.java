package com.example.demo.bean;

public class Department {
    private String id;
    private String part;

    public Department() {
    }

    public Department(String part) {
        this.part = part;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", part='" + part + '\'' +
                '}';
    }
}
