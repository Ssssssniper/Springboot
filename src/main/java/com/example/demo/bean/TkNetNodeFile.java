package com.example.demo.bean;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Date;

public class TkNetNodeFile {
    private Integer id;
    private String fname;
    private String fversion;
    private byte[] fcontent;
    private Date fuploadtime;
    private Integer fisNew;

    public Integer getid() {
        return id;
    }

    public void setid(Integer ID) {
        this.id = ID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFversion() {
        return fversion;
    }

    public void setFversion(String fversion) {
        this.fversion = fversion;
    }

    public byte[] getFcontent() {
        return fcontent;
    }

    public void setFcontent(byte[] fcontent) {
        this.fcontent = fcontent;
    }

    public Date getFuploadtime() {
        return fuploadtime;
    }

    public void setFuploadtime(Date fuploadtime) {
        this.fuploadtime = fuploadtime;
    }

    public Integer getFisNew() {
        return fisNew;
    }

    public void setFisNew(Integer fisNew) {
        this.fisNew = fisNew;
    }

    @Override
    public String toString() {
        return "TkNetNodeFile{" +
                "ID=" + id +
                ", fname='" + fname + '\'' +
                ", fversion='" + fversion + '\'' +
                ", fcontent=" + Arrays.toString(fcontent) +
                ", fuploadtime='" + fuploadtime + '\'' +
                ", fisNew=" + fisNew +
                '}';
    }
}
