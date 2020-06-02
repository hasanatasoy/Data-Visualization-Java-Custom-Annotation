package com.hasanatasoy.model;

import com.hasanatasoy.enums.Chart;

import java.util.List;

public class DataModel {

    private String data;
    private List<Chart> charts;

    public DataModel(String data, List<Chart> charts) {
        this.data = data;
        this.charts = charts;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "data='" + data + '\'' +
                ", charts=" + charts +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }
}
