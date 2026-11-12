/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author joaqu
 */
public class Patient {
    private String patientId;
    private String name;

    public Patient(String patientId, String name) {
        this.patientId = patientId == null ? "" : patientId.trim();
        this.name = name == null ? "" : name.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }
}