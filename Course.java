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
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private ArrayList<Student> registeredStudents = new ArrayList<>();
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        if (isCourseNameValid(courseName) && credits > 0 && department != null) {
            this.courseName = courseName;
            this.credits = credits;
            this.department = department;
            this.assignments = new ArrayList<>();
            this.registeredStudents = new ArrayList<>();
            this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        } else {
            this.courseName = null;
            this.credits = 0;
            this.department = null;
            this.assignments = null;
            this.registeredStudents = null;
            this.courseId = null;
        }
    }

    private static boolean isCourseNameValid(String courseName) {
        if (courseName == null || courseName.isEmpty()) return false;
        for (int i = 0; i < courseName.length(); i++) {
            char c = courseName.charAt(i);
            if (!Character.isLetter(c) && c != ' ') return false;
        }
        return true;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) return false;

        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        return true;
    }

    public boolean addAssignment(String assignmentName, double weight) {
        if (assignmentName == null || assignmentName.isEmpty())
            return false;

        Assignment newAssignment = new Assignment(assignmentName, weight);
        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }
        assignments.add(newAssignment);
        return true;
    }

    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return Math.abs(sum - 100) < 0.001;
    }

    public int[] calcStudentsAverage() {
        int studentcount = registeredStudents.size();
        int[] finalAverage = new int[studentcount];

        for (int i = 0; i < studentcount; i++) {
            double weightedsum = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    weightedsum += score * assignment.getWeight();
                }
            }
            finalAverage[i] = (int) Math.round(weightedsum / 100.0);
        }
        return finalAverage;
    }
    public String toSimplifiedString() {
        return courseId + " - " +
                courseName + " - " +
                credits + " credits - " +
                (department != null ? department.getDepartmentName() : "No Department");
    }
        @Override
        public String toString () {
            return "Course{" +
                    "courseId='" + courseId + '\'' +
                    ", courseName='" + courseName + '\'' +
                    ", credits=" + credits +
                    ", department=" + department +
                    '}';
        }
    }



