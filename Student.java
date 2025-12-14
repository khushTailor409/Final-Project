package org.khush;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString // add simplified string ??
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%05d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) return false;

        registeredCourses.add(course);

        if (!course.getRegisteredStudents().contains(this)) {
            course.getRegisteredStudents().add(this);
        }

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }
        return true;
    }
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) return false;

        registeredCourses.remove(course);

        int studentIndex = course.getRegisteredStudents().indexOf(this);
        if (studentIndex >= 0){

            course.getRegisteredStudents().remove(studentIndex);

        for (Assignment assignment : course.getAssignments()) {
            if (studentIndex < assignment.getScores().size()) {
                assignment.getScores().remove(studentIndex);
                }
            }
        }
    return true;
    }
}