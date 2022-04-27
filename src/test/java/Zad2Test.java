import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Zad2Test extends BaseTest {

    @Test
    @Order(1)
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
    @Order(2)
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
    @Order(3)
    public void testThird1b() {
        TestResult tr = new TestResult(
                "74144",
                "Test 3",
                1,
                TestResultTypeEnu.CORRECT
        );
        System.out.println(tr);
    }

    @Test
    @Order(4)
    void testEncryptAndDecrypt3b() {
        TestResult tr = new TestResult();
        tr.setStudentIdentifier("74144");
        tr.setTestIdentifier("Test encryption");
        tr.setNumberOfPoints(3);

        try {
            String input = "aaaa FWANFJ 4782 @$&(";

            CryptoHelperImpl cryptoHelper = new CryptoHelperImpl();

            SecretKey key = cryptoHelper.generateKey(128);
            IvParameterSpec ivParameterSpec = cryptoHelper.generateIv();
            String algorithm = "AES/CBC/PKCS5Padding";
            String cipherText = cryptoHelper.encrypt(algorithm, input, key, ivParameterSpec);
            String plainText = cryptoHelper.decrypt(algorithm, cipherText, key, ivParameterSpec);

            tr.setTestResult(Objects.equals(input, plainText) ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);

        } catch (Exception exception) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(exception.getMessage());
        }

        System.out.println(tr);
    }

}
