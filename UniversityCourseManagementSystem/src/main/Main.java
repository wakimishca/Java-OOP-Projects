/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author joaqu
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import university.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String instrName = readLettersOnly("Enter instructor name: ");
        int instrType = readIntWithPrompt("Full-Time or Part-Time? (1-Full-Time, 2-Part-Time): ", 1, 2);

        Instructor instructor;
        if (instrType == 1) {
            double monthly = readDoubleWithPrompt("Enter monthly salary: ", 0, Double.MAX_VALUE);
            instructor = new FullTimeInstructor(instrName, monthly);
        } else {
            int hours = readIntWithPrompt("Enter hours worked: ", 0, Integer.MAX_VALUE);
            double rate = readDoubleWithPrompt("Enter hourly rate: ", 0, Double.MAX_VALUE);
            instructor = new PartTimeInstructor(instrName, hours, rate);
        }

        String courseName = readCourseName("Enter course name: ");
        int numStudents = readIntWithPrompt("Enter number of students: ", 1, Integer.MAX_VALUE);

        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= numStudents; i++) {
            String sname = readLettersOnly("Enter student " + i + " name: ");
            String sid = readDigitsOnly("Enter student " + i + " ID: ");
            students.add(new Student(sname, sid));
        }

        // logins
        System.out.println(instructor.login());

        Course course = new Course(courseName, instructor, students);

        System.out.println("Course: " + course.getCourseName());
        System.out.println("Instructor: " + course.getInstructor().getName());
        System.out.printf("Salary: ₱%.1f%n", course.getInstructor().getSalary());
        System.out.println("Students:");
        for (Student s : course.getStudents()) {
            System.out.println("- " + s.getName() + " (ID: " + s.getId() + ")");
        }
    }

    // Input validation methods:
    private static String readLettersOnly(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.matches("[a-zA-Z ]+")) return input;
            System.out.println("Invalid input. Only letters and spaces are allowed.");
        }
    }

    private static String readDigitsOnly(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.matches("\\d+")) return input;
            System.out.println("Invalid input. Numbers only (no letters or special characters).");
        }
    }

    private static String readCourseName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.matches("[a-zA-Z0-9 ]+")) return input;
            System.out.println("Invalid course name. Only letters, numbers, and spaces are allowed.");
        }
    }

    private static int readIntWithPrompt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v < min || v > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                } else return v;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again (numbers only).");
            }
        }
    }

    private static double readDoubleWithPrompt(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (v < min || v > max) {
                    System.out.println("Please enter a valid positive number.");
                } else return v;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again (numbers only).");
            }
        }
    }
}