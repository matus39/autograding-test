import com.google.gson.Gson;

public class TestResult {

    private static final String START_TEST_RESULT_IDENTIFIER = "\n###_AUTOGRADING_TEST_RESULT_START_###\n";
    private static final String END_TEST_RESULT_IDENTIFIER = "\n###_AUTOGRADING_TEST_RESULT_END_###\n";

    private String studentIdentifier;

    private String testIdentifier;

    private int numberOfPoints;

    private String expectedValue;

    private String actualValue;

    private TestResultTypeEnu testResult;

    private String details;

    public TestResult() {
    }

    public TestResult(String studentIdentifier, String testIdentifier, int numberOfPoints, TestResultTypeEnu testResult) {
        this.studentIdentifier = studentIdentifier;
        this.testIdentifier = testIdentifier;
        this.numberOfPoints = numberOfPoints;
        this.testResult = testResult;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return START_TEST_RESULT_IDENTIFIER + gson.toJson(this) + END_TEST_RESULT_IDENTIFIER;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public void setStudentIdentifier(String studentIdentifier) {
        this.studentIdentifier = studentIdentifier;
    }

    public String getTestIdentifier() {
        return testIdentifier;
    }

    public void setTestIdentifier(String testIdentifier) {
        this.testIdentifier = testIdentifier;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public TestResultTypeEnu getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResultTypeEnu testResult) {
        this.testResult = testResult;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getActualValue() {
        return actualValue;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }
}
