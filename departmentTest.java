import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.khush.Department;

public class departmentTest {

    @Test
    @DisplayName("isDepartmentNameValid: 'Computer Science' -> true")
    void testValidDepartmentName() {
        boolean actual = Department.isDepartmentNameValid("Computer Science");
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: 'CS101' -> false")
    void testInvalidDepartmentName() {
        boolean actual = Department.isDepartmentNameValid("CS101");
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Constructor: invalid name -> departmentId is null")
    void testConstructorInvalidName() {
        Department d = new Department("CS101");
        Assertions.assertNull(d.getDepartmentId());
    }
}

