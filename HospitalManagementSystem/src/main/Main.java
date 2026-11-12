/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author joaqu
 */
import java.util.Scanner;
import hospital.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" Hospital Management System ");

        int staffChoice = promptInt("Create (1) Doctor or (2) Nurse? Enter 1 or 2: ", 1, 2);

        String name = promptLettersAndSpaces("Enter name: ");
        String empId = promptAlphaNum("Enter employee ID: ");

        StaffMember staff;
        if (staffChoice == 1) {
            double monthly = promptDouble("Enter monthly salary: ");
            int surgeries = promptInt("Enter number of surgeries: ", 0, Integer.MAX_VALUE);
            staff = new Doctor(name, empId, monthly, surgeries);
        } else {
            int hours = promptInt("Enter hours worked: ", 0, Integer.MAX_VALUE);
            double rate = promptDouble("Enter hourly rate: ");
            staff = new Nurse(name, empId, hours, rate);
        }

        String deptName = promptLettersDigitsSpaces("Enter department name: ");
        Department department = new Department(deptName);

        int numPatients = promptInt("How many patients to add? ", 0, Integer.MAX_VALUE);
        for (int i = 1; i <= numPatients; i++) {
            String pid = promptAlphaNum("Patient " + i + " ID: ");
            String pname = promptLettersAndSpaces("Patient " + i + " name: ");
            department.addPatient(new Patient(pid, pname));
        }

        // Login (simple display)
        System.out.println(staff.getName() + " logged in.");
        System.out.printf("Calculated salary: ₱%.1f%n", staff.calculateSalary());

        // Display patients
        department.showPatients();

        // If staff is a Doctor, allow selecting a patient to prescribe to
        if (staff instanceof Doctor) {
            Doctor d = (Doctor) staff;
            Patient[] patients = department.getPatients();
            if (patients.length == 0) {
                System.out.println("No patients to prescribe to. You may provide a patient name manually.");
                String manual = promptOptionalLettersAndSpaces("Enter patient name to prescribe to (or leave blank to skip): ");
                if (!manual.isEmpty()) {
                    String med = promptLettersDigitsSpaces("Enter medicine name: ");
                    d.prescribeMedicine(manual, med);
                }
            } else {
                System.out.println("Select a patient to prescribe to by number:");
                for (int i = 0; i < patients.length; i++) {
                    System.out.printf("%d) %s (ID: %s)%n", i + 1, patients[i].getName(), patients[i].getPatientId());
                }
                int sel = promptInt("Enter selection (1-" + patients.length + "): ", 1, patients.length);
                String med = promptLettersDigitsSpaces("Enter medicine name: ");
                d.prescribeMedicine(patients[sel - 1].getName(), med);
            }
        }

        System.out.println("=== End ===");
    }

    /* Input helpers (strict validation) */

    private static int promptInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v < min || v > max) {
                    System.out.printf("Please enter a number between %d and %d.%n", min, max);
                } else return v;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again (digits only).");
            }
        }
    }

    private static int promptInt(String prompt) {
        return promptInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static double promptDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (v < 0) {
                    System.out.println("Please enter a non-negative number.");
                } else return v;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again (digits and optional decimal point).");
            }
        }
    }

    private static String promptLettersAndSpaces(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches("[a-zA-Z ]+")) return s;
            System.out.println("Invalid input. Only letters and spaces allowed.");
        }
    }

    private static String promptAlphaNum(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches("[a-zA-Z0-9]+")) return s;
            System.out.println("Invalid input. Only letters and digits allowed (no spaces).");
        }
    }

    private static String promptLettersDigitsSpaces(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches("[a-zA-Z0-9 ]+")) return s;
            System.out.println("Invalid input. Only letters, digits, and spaces allowed.");
        }
    }

    private static String promptOptionalLettersAndSpaces(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine().trim();
        if (s.isEmpty()) return "";
        if (s.matches("[a-zA-Z ]+")) return s;
        System.out.println("Invalid input (skipping).");
        return "";
    }
}