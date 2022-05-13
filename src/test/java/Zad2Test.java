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
                "Test 1",
                2,
                TestResultTypeEnu.CORRECT
        );
        tr.setExpectedValue("123");
        tr.setActualValue("123");

        System.out.println(tr);
    }

    @Test
    @Order(2)
    public void testSecond3b() {
        TestResult tr = new TestResult(
                "Test 2",
                3,
                TestResultTypeEnu.FAIL
        );
        tr.setExpectedValue("AAA");
        tr.setActualValue("cfnfawjfkn ak");

        System.out.println(tr);
    }

    @Test
    @Order(3)
    public void testThird1b() {
        TestResult tr = new TestResult(
                "Test 3",
                1,
                TestResultTypeEnu.CORRECT
        );
        tr.setExpectedValue("true");
        tr.setActualValue("true");

        System.out.println(tr);
    }

    @Test
    @Order(4)
    void testEncryptAndDecrypt3b() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("Test encryption");
        tr.setNumberOfPoints(3);

        String input = "aaaa FWANFJ 4782 @$&(";
        tr.setExpectedValue(input);

        try {
            CryptoHelperImpl cryptoHelper = new CryptoHelperImpl();

            SecretKey key = cryptoHelper.generateKey(128);
            IvParameterSpec ivParameterSpec = cryptoHelper.generateIv();
            String algorithm = "AES/CBC/PKCS5Padding";
            String cipherText = cryptoHelper.encrypt(algorithm, input, key, ivParameterSpec);
            String plainText = cryptoHelper.decrypt(algorithm, cipherText, key, ivParameterSpec);

            tr.setTestResult(Objects.equals(input, plainText) ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);
            tr.setActualValue(plainText);

        } catch (Exception exception) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(exception.getMessage());
        }

        System.out.println(tr);
    }

}
