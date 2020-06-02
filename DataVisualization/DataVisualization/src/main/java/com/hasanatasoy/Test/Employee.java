package com.hasanatasoy.Test;

import com.hasanatasoy.annotations.*;
import com.hasanatasoy.annotations.charts.AllCharts;
import com.hasanatasoy.annotations.charts.DonutChart;
import com.hasanatasoy.annotations.charts.LineChart;
import com.hasanatasoy.annotations.charts.RadarChart;

@AllCharts
public class Employee {

    @DataName
    private String name;
    @SingleData
    private int happinessRate;
    private String address;
    private Company company;

    public Employee(String name, int happinessRate) {
        this.name = name;
        this.happinessRate = happinessRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHappinessRate() {
        return happinessRate;
    }

    public void setHappinessRate(int happinessRate) {
        this.happinessRate = happinessRate;
    }
}
