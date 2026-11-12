/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author joaqu
 */
public abstract class StaffMember {
    private String name;
    private String employeeId;

    public StaffMember(String name, String employeeId) {
        this.name = name == null ? "" : name.trim();
        this.employeeId = employeeId == null ? "" : employeeId.trim();
    }

    public String getName() {
        return name;
    }

    // Kept UML capitalization: getEmployeeID()
    public String getEmployeeID() {
        return employeeId;
    }

    public abstract double calculateSalary();
}