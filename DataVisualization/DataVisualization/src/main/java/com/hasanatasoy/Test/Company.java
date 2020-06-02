package com.hasanatasoy.Test;

import com.hasanatasoy.annotations.*;
import com.hasanatasoy.annotations.charts.BarChart;
import com.hasanatasoy.annotations.charts.LineChart;
import com.hasanatasoy.annotations.charts.PolarAreaChart;

import java.util.List;

@BarChart
@PolarAreaChart
@LineChart
public class Company {

    private List<Employee> employees;
    @DataName
    private String name;
    @SingleData
    private int employeeCount;

    public Company(List<Employee> employees, String name){
        this.employees = employees;
        this.name = name;
        employeeCount = employees.size();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }
}
