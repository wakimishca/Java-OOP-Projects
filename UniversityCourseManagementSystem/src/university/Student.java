/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university;

/**
 *
 * @author joaqu
 */
public class Student {
    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name == null ? "" : name.trim();
        this.id = id == null ? "" : id.trim();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}