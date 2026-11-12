/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author joaqu
 */
public class Doctor extends StaffMember implements Prescriber {
    private double monthlySalary;
    private int numberOfSurgeries;

    // Surgery bonus is configurable; change if professor specifies another formula.
    private static final double SURGERY_BONUS = 1500.0;

    public Doctor(String name, String employeeId, double monthlySalary, int numberOfSurgeries) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
        this.numberOfSurgeries = numberOfSurgeries;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + (numberOfSurgeries * SURGERY_BONUS);
    }

    @Override
    public void prescribeMedicine(String patientName, String medicineName) {
        // Deterministic confirmation message
        System.out.println(getName() + " prescribes " + medicineName + " to " + patientName + ".");
    }
}