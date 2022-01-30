package com.techelevator;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    Map<String, Project> projects = new HashMap<>();
    List<Employee> engineeringEmployees = new ArrayList<>();
    List<Employee> marketingEmployees = new ArrayList<>();

    /**
     * The main entry point in the application
     *
     * @param args
     */
    public static void main(String[] args) {

        Application app = new Application();
        app.run();

    }


    private void run() {
        // create some departments
        createDepartments();


        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {

        Department marketing = new Department(1, "Marketing");
        Department sales = new Department(2, "Sales");
        Department engineering = new Department(3, "Engineering");

        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);


    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {


        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).getName());

        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee dean = new Employee();
        dean.setEmployeeId(1);
        dean.setFirstName("Dean");
        dean.setLastName("Johnson");
        dean.setEmail("djohnson@teams.com");
        dean.setSalary(60000);
        dean.setDepartment(departments.get(2));
        dean.setHireDate("08/21/2020");


        Employee angie = new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020");
        angie.raiseSalary(10);

        Employee margaret = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020");

        employees.add(dean);
        employees.add(angie);
        employees.add(margaret);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {


        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (int i = 0; i < employees.size(); i++) {

            System.out.println(employees.get(i).getFullName() + " (" + employees.get(i).getSalary() + ") " + employees.get(i).getDepartment().getName());

        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {

        Project teams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");

        for (Employee emp : employees) {
            if(emp.getDepartment().getName().equalsIgnoreCase("engineering")){
                engineeringEmployees.add(emp);

            }

        }
        teams.setTeamMembers(engineeringEmployees);
        projects.put(teams.getName(),teams);


    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project project = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");


        for (Employee emp : employees) {
            if(emp.getDepartment().getName().equalsIgnoreCase("marketing")){
                marketingEmployees.add(emp);

            }

        }
        project.setTeamMembers(marketingEmployees);
        projects.put(project.getName(),project);

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {

        System.out.println("\n------------- PROJECTS ------------------------------");
        System.out.println("TEams: " + engineeringEmployees.size());
        System.out.println("Marketing Landing Page: " + marketingEmployees.size());
    }

}
