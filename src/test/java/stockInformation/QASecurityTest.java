package stockInformation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QASecurityTest {
    private QASecurity qaSecurity;
    private IQADatabase qaDb;

    @Before
    public void setUp() {
        qaDb = new QADatabaseStub();
        qaSecurity = new QASecurity();
    }

    @Test
    public void GivenValidCredentials_ShouldPass() {
        try {
            boolean result = qaSecurity.login("Daniel", "Daniel123", qaDb);
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception should not be thrown here. This should validate the user successfully");
        }
    }

    @Test
    public void GivenUsernameLessThanThreeChars_ShouldThrowInvalidUsernameFormatException() {
        assertThrows(QAInvalidUsernameFormatException.class, () -> {
            qaSecurity.login("ab", "Daniel123sss", qaDb);
        });
    }

    @Test
    public void GivenPasswordLessThanThreeChars_ShouldThrowInvalidPasswordFormatException() {
        assertThrows(QAInvalidPasswordFormatException.class, () -> {
            qaSecurity.login("Daniel", "aa", qaDb);
        });
    }

    @Test
    public void GivenPasswordContainsNoDigits_ShouldThrowInvalidPasswordFormatException() {
        assertThrows(QAInvalidPasswordFormatException.class, () -> {
            qaSecurity.login("Daniel", "aaaaaaaaa", qaDb);
        });
    }
}