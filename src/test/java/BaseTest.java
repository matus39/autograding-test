import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    private static final String START_TESTS_IDENTIFIER = "\n###_AUTOGRADING_TESTS_START_###\n";
    private static final String END_TESTS_IDENTIFIER = "\n###_AUTOGRADING_TESTS_END_###\n";

    @BeforeAll
    static void beforeAll() {
        System.out.print(START_TESTS_IDENTIFIER);
    }

    @AfterAll
    static void afterAll() {
        System.out.print(END_TESTS_IDENTIFIER);
    }
}
