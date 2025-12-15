import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.khush.Util;

public class utilTest {
    @Test
    @DisplayName("toTitleCase: 'computer science' -> 'Computer Science'")
    void testToTitleCase_Normal() {
        String actual = Util.toTitleCase("computer science");
        Assertions.assertEquals("Computer Science", actual);
    }

    @Test
    @DisplayName("toTitleCase: 'java' -> 'Java'")
    void testToTitleCase_SingleWord() {
        String actual = Util.toTitleCase("java");
        Assertions.assertEquals("Java", actual);
    }

    @Test
    @DisplayName("toTitleCase: empty string -> empty string")
    void testToTitleCase_Empty() {
        String actual = Util.toTitleCase("");
        Assertions.assertEquals("", actual);
    }
}
