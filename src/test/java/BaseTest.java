import org.junit.jupiter.api.Test;

public class BaseTest {

    @Test
    public void testFirst2b() {
        TestResult tr = new TestResult(
                "74144",
                "Test 1",
                2,
                TestResultTypeEnu.CORRECT
        );
        System.out.println(tr);
    }

    @Test
    public void testSecond3b() {
        TestResult tr = new TestResult(
                "74144",
                "Test 2",
                3,
                TestResultTypeEnu.FAIL
        );
        System.out.println(tr);
    }

    @Test
    public void testThird1b() {
        TestResult tr = new TestResult(
                "74144",
                "Test 3",
                1,
                TestResultTypeEnu.CORRECT
        );
        System.out.println(tr);
    }
}
