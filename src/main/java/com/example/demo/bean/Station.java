package com.example.demo.bean;

import java.util.List;

public class Station {
    private String station;
    private List<Dcdata> datalist;

    public Station() {
    }

    public Station(String station, List<Dcdata> datalist) {
        this.station = station;
        this.datalist = datalist;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public List<Dcdata> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<Dcdata> datalist) {
        this.datalist = datalist;
    }

    @Override
    public String toString() {
        return "Station{" +
                "station='" + station + '\'' +
                ", datalist=" + datalist +
                '}';
    }


}
