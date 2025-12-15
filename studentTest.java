import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.khush.Course;
import org.khush.Department;
import org.khush.Student;

public class studentTest {

    @Test
    @DisplayName("registerCourse: new course -> true")
    void testRegisterCourse() {
        Department d = new Department("Math");
        Course c = new Course("Algebra", 3, d);
        Student s = new Student("John Doe", Student.Gender.MALE, null, d);

        boolean actual = s.registerCourse(c);
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("registerCourse: same course twice -> false")
    void testRegisterSameCourseTwice() {
        Department d = new Department("Math");
        Course c = new Course("Algebra", 3, d);
        Student s = new Student("John Doe", Student.Gender.MALE, null, d);

        s.registerCourse(c);
        boolean actual = s.registerCourse(c);

        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("dropCourse: registered course -> true")
    void testDropCourse() {
        Department d = new Department("Math");
        Course c = new Course("Algebra", 3, d);
        Student s = new Student("John Doe", Student.Gender.MALE, null, d);

        s.registerCourse(c);
        boolean actual = s.dropCourse(c);

        Assertions.assertTrue(actual);
    }
}
