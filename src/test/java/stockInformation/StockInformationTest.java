package stockInformation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StockInformationTest {
    private IQADatabase qaDb;
    private StockInformation stockInformation;

    @Before
    public void setUp() {
        qaDb = new QADatabaseStub();
        stockInformation = new StockInformation(qaDb);
    }

    @Test
    public void GivenValidCredentials_ShouldLogin() {
        try {
            stockInformation.login("Daniel", "Daniel123");
            assertTrue(stockInformation.isValidated());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void GivenValidCompanyID_ReturnStockLevel() {
        try {
            stockInformation.login("Daniel", "Daniel123");
            int stockLevel = stockInformation.getStockLevel(1);
            assertEquals(11, stockLevel);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void GivenInvalidCompanyID_ShouldThrowInvalidCompanyIDException() {
        assertThrows(QAInvalidCompanyIDException.class, () -> {
            stockInformation.login("Daniel", "Daniel123");
            stockInformation.getStockLevel(101);
        });
    }

    @Test
    public void GivenNullUsername_ShouldThrowNullException() {
        assertThrows(NullPointerException.class, () -> {
            stockInformation.login(null, "Daniel123");
        });
    }

    @Test
    public void GivenEmptyUsername_ShouldThrowException() {
        assertThrows(QAInvalidUsernameFormatException.class, () -> {
            stockInformation.login("", "Daniel123");
        });
    }

    @Test
    public void GivenNullPassword_ShouldThrowNullException() {
        assertThrows(NullPointerException.class, () -> {
            stockInformation.login("Daniel", null);
        });
    }

    @Test
    public void GivenEmptyPassword_ShouldThrowInvalidPasswordFormatException() {
        assertThrows(QAInvalidPasswordFormatException.class, () -> {
            stockInformation.login("Daniel", "");
        });
    }

    @Test
    public void TestLogin_InvalidCredentials_ShouldThrowInvalidUserException() {
        assertThrows(QAInvalidUserException.class, () -> {
            stockInformation.login("InvalidUser", "InvalidPassword12");
        });
    }

    @Test(expected = QAInvalidCompanyIDException.class)
    public void GivenInvalidCompanyID_ThrowException() throws Exception {
        stockInformation.login("Daniel", "Daniel123");
        stockInformation.getStockLevel(1000);
    }
}
