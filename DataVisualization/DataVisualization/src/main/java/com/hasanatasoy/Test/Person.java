package com.hasanatasoy.Test;

import com.hasanatasoy.annotations.*;
import com.hasanatasoy.annotations.charts.BarChart;
import com.hasanatasoy.annotations.charts.LineChart;

import java.util.List;

@BarChart
public class Person {

    @DataName
    private String name;
    @DataName
    private String surname;
    @MultipleData
    private List<Integer> datas;
    private int age;

    public Person(String name, String surname, List<Integer> datas) {
        this.name = name;
        this.surname = surname;
        this.datas = datas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Integer> getDatas() {
        return datas;
    }

    public void setDatas(List<Integer> datas) {
        this.datas = datas;
    }
}
