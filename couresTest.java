import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.khush.Course;
import org.khush.Department;
import org.khush.Student;

public class couresTest {
    @Test
    @DisplayName("addAssignment: valid assignment -> true")
    void testAddAssignment() {
        Department d = new Department("Math");
        Course c = new Course("Calculus", 3, d);

        boolean actual = c.addAssignment("Midterm", 50);
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid: 50 + 50 -> true")
    void testAssignmentWeightValid() {
        Department d = new Department("Math");
        Course c = new Course("Calculus", 3, d);

        c.addAssignment("Midterm", 50);
        c.addAssignment("Final", 50);

        boolean actual = c.isAssignmentWeightValid();
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("registerStudent: new student -> true")
    void testRegisterStudent() {
        Department d = new Department("Math");
        Course c = new Course("Calculus", 3, d);
        Student s = new Student("khush tailor", Student.Gender.MALE, null, d);

        boolean actual = c.registerStudent(s);
        Assertions.assertTrue(actual);
    }
}
