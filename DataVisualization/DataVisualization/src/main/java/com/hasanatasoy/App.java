package com.hasanatasoy;


import com.hasanatasoy.Test.Company;
import com.hasanatasoy.Test.Database;
import com.hasanatasoy.Test.Person;
import com.hasanatasoy.service.DataVisualizationService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ){
        DataVisualizationService service =
                new DataVisualizationService("/home/hasan/Desktop/Data_Visualization");
        Database database = new Database();
        List<Person> persons = database.findAllPerson();
        Person person = database.findPersonById(1L);
        List<Company> companies = database.findAllCompany();
        Company company = database.findCompanyById(2L);
        service.visualize(persons, "Persons Graph");
        service.visualize(person, "Person Graph");
        service.visualize(companies, "Companies Graph");
        service.visualize(company.getEmployees(), "Employees Graph");
    }

}
