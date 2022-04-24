import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    private static final String START_TESTS_IDENTIFIER = "###_AUTOGRADING_TESTS_START_###";
    private static final String END_TESTS_IDENTIFIER = "###_AUTOGRADING_TESTS_END_###";

    @BeforeAll
    static void beforeAll() {
        System.out.println(START_TESTS_IDENTIFIER);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(END_TESTS_IDENTIFIER);
    }
}
