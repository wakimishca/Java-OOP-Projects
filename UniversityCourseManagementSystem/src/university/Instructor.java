/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university;

/**
 *
 * @author joaqu
 */
public abstract class Instructor {
    private String name;

    public Instructor(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public String getName() {
        return name;
    }

    public abstract double getSalary();

    // login method
    public String login() {
        return getName() + " has logged in.";
    }
}