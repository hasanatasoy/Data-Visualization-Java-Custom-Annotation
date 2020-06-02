package com.hasanatasoy.Test;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Employee> employees = List.of(
            new Employee("Abdullah", 8),
            new Employee("Yunus", 7),
            new Employee("Büşra", 7),
            new Employee("Zeynep", 10)
    );
    private List<Employee> employees2 = List.of(
            new Employee("Hüseyin", 6),
            new Employee("Efe", 1)
    );
    private List<Employee> employees3 = List.of(
            new Employee("Nermin", 8),
            new Employee("Tahsin", 6),
            new Employee("Serhat", 9)
    );

    private List<Person> persons = List.of(
            new Person("Hasan", "Atasoy", List.of(32, 45, 23)),
            new Person("Sertan", "Sayımbay", List.of(12, 77, 54)),
            new Person("Tunahan", "Aydos", List.of(8, 43, 48)),
            new Person("Bedirhan", "Atasoy", List.of(52, 12, 89))
            );
    private List<Company> companies = List.of(
            new Company(employees, "Getir"),
            new Company(employees2, "Dogus-Group"),
            new Company(employees3, "Trendyol-Group")
    );

    public List<Person> findAllPerson(){
        return persons;
    }

    public Company findCompanyById(Long id){
        return companies.get(2);
    }

    public Person findPersonById(Long id){
        return persons.get(0);
    }

    public List<Company> findAllCompany(){
        return companies;
    }
}
