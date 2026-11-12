/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author joaqu
 */
public class Department {
    private String name;
    private Patient[] patients;

    public Department(String name) {
        this.name = name == null ? "" : name.trim();
        this.patients = new Patient[0];
    }

    public void addPatient(Patient p) {
        if (p == null) return;
        Patient[] tmp = new Patient[patients.length + 1];
        System.arraycopy(patients, 0, tmp, 0, patients.length);
        tmp[patients.length] = p;
        patients = tmp;
    }

    public void showPatients() {
        if (patients.length == 0) {
            System.out.println("No patients in department " + name + ".");
            return;
        }
        System.out.println("Patients in " + name + ":");
        for (Patient p : patients) {
            System.out.println("- " + p.getName() + " (ID: " + p.getPatientId() + ")");
        }
    }

    public String getName() {
        return name;
    }

    /**
     * Returns a defensive copy of the patient array (still Patient[] as UML requires)
     */
    public Patient[] getPatients() {
        Patient[] copy = new Patient[patients.length];
        System.arraycopy(patients, 0, copy, 0, patients.length);
        return copy;
    }
}