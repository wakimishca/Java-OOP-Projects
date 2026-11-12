# Java OOP Projects

Two console applications written in Java with NetBeans, built to practice object-oriented programming: inheritance, abstract classes, interfaces, polymorphism, and encapsulation.

## 1. Hospital Management System

A program that creates a hospital staff member, adds patients to a department, and calculates salary.

**Features**
- Create a Doctor or a Nurse
- Salary is calculated differently for each role (doctors: monthly salary plus a bonus per surgery; nurses: hours worked x hourly rate)
- Add patients to a department and display the patient list
- Doctors can prescribe a medicine to a selected patient
- Input validation on every prompt (letters only, digits only, valid number ranges)

**OOP concepts used**
- Abstract class: `StaffMember`
- Inheritance: `Doctor` and `Nurse` extend `StaffMember`
- Interface: `Prescriber` (implemented by `Doctor`)
- Polymorphism: each role overrides `calculateSalary()`
- Encapsulation: private fields with getters

## 2. University Course Management System

A program that sets up a course with an instructor and a list of students.

**Features**
- Create a Full-Time or Part-Time instructor
- Salary is calculated differently for each type (monthly salary, or hours worked x hourly rate)
- Create a course and add students with their names and ID numbers
- Display the course, instructor, salary, and student list
- Input validation on every prompt

**OOP concepts used**
- Abstract class: `Instructor`
- Inheritance: `FullTimeInstructor` and `PartTimeInstructor` extend `Instructor`
- Polymorphism: each type overrides `getSalary()`
- Encapsulation: private fields with getters
- Composition: `Course` holds an `Instructor` and a list of `Student` objects

## Built With

- Java
- NetBeans IDE

## How to Run

1. Download or clone this repository.
2. Open one of the project folders (`HospitalManagementSystem` or `UniversityCourseManagementSystem`) as a project in NetBeans (requires Java JDK 8 or newer).
3. Run `Main.java` and follow the prompts in the console.
