package org.khush;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private Department department;
    private ArrayList<Student> registeredStudents = new ArrayList<>();

    // Constructor for testing
    public Course(String courseId, String courseName, Department department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
    }
}

