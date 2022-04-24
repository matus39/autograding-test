public class TestResult {

    private String studentIdentifier;

    private String testIdentifier;

    private int numberOfPoints;

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
        return "TestResult{" +
                "studentIdentifier='" + studentIdentifier + '\'' +
                ", testIdentifier='" + testIdentifier + '\'' +
                ", numberOfPoints=" + numberOfPoints +
                ", testResult=" + testResult +
                ", details='" + details + '\'' +
                '}';
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
}
