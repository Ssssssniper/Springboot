package com.example.demo.bean;

public class SubMenu {
    private Integer id;
    private String title;
    private String path;
    private Integer subid;

    public SubMenu() {
    }

    public SubMenu(Integer id, String title, String path, Integer subid) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.subid = subid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSubid() {
        return subid;
    }

    public void setSubid(Integer subid) {
        this.subid = subid;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", subid=" + subid +
                '}';
    }
}
