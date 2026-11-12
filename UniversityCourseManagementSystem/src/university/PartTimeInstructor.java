/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university;

/**
 *
 * @author joaqu
 */
public class PartTimeInstructor extends Instructor {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeInstructor(String name, int hoursWorked, double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getSalary() {
        return hoursWorked * hourlyRate;
    }
}