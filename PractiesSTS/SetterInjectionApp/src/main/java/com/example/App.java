package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Initialize Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get Address bean from Spring context
        Address address = (Address) context.getBean("addressBean");
        System.out.println("Enter city:");
        address.setCity(scanner.nextLine());
        System.out.println("Enter state:");
        address.setState(scanner.nextLine());
        System.out.println("Enter pincode:");
        address.setPincode(scanner.nextLine());

        // Get Organization bean from Spring context
        Organization organization = (Organization) context.getBean("organizationBean");
        System.out.println("Enter organization name:");
        organization.setName(scanner.nextLine());

        // Get Employee bean from Spring context
        Employee employee = (Employee) context.getBean("employeeBean");
        System.out.println("Enter employee name:");
        employee.setName(scanner.nextLine());
        System.out.println("Enter employee ID:");
        employee.setId(scanner.nextInt());
        System.out.println("Enter employee salary:");
        employee.setSalary(scanner.nextDouble());
        scanner.nextLine(); // consume the newline
        System.out.println("Enter employee address (city, state, pincode):");
        employee.setAddress(address);
        System.out.println("Enter employee organization:");
        employee.setOrganization(organization);

        // Output details
        System.out.println("Employee Details: " + employee);

        // Close the scanner
        scanner.close();
    }
}
