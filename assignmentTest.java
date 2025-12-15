import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.khush.Assignment;

public class assignmentTest {
    @Test
    @DisplayName("generateRandomScore: scores list filled")
    void testGenerateRandomScore() {
        Assignment a = new Assignment("Test", 50);
        a.getScores().add(null);
        a.getScores().add(null);

        a.generateRandomScore();

        Assertions.assertNotNull(a.getScores().get(0));
        Assertions.assertNotNull(a.getScores().get(1));
    }
}
