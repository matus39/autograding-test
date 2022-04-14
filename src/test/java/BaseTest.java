import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Objects;

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


    @Test
    void testEncryptAndDecrypt3b() throws Exception {
        String input = "aaaa FWANFJ 4782 @$&(";

        CryptoHelperImpl cryptoHelper = new CryptoHelperImpl();

        SecretKey key = cryptoHelper.generateKey(128);
        IvParameterSpec ivParameterSpec = cryptoHelper.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = cryptoHelper.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = cryptoHelper.decrypt(algorithm, cipherText, key, ivParameterSpec);

        TestResult tr = new TestResult(
                "74144",
                "Test encryption",
                3,
                Objects.equals(input, plainText) ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL
        );
        System.out.println(tr);
    }
}
