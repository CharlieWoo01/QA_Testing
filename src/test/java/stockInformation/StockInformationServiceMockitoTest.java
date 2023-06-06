package stockInformation;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class StockInformationServiceMockitoTest {
        private StockInformationWebService stockInformationService;
        private IQADatabase mockDb;

        @Before
        public void setUp() {
            mockDb = mock(IQADatabase.class);
            stockInformationService = new StockInformationWebService();
        }

        @Test
        public void GivenValidCompanyID_ThenReturnsStockLevel() throws QAInvalidCompanyIDException {
            int companyID = 1;
            int expectedStockLevel = 11;

            when(mockDb.isValidCompanyID(companyID)).thenReturn(true);
            when(mockDb.getStockLevelByCompanyID(companyID)).thenReturn(expectedStockLevel);

            int actualStockLevel = stockInformationService.getStockLevel(companyID, mockDb);

            assertEquals(expectedStockLevel, actualStockLevel);
            verify(mockDb).getStockLevelByCompanyID(companyID);
        }

        @Test()
        public void GivenInvalidCompanyID_Throw_InvalidCompanyIDException() throws QAInvalidCompanyIDException {
            int companyID = 101;

            when(mockDb.isValidCompanyID(companyID)).thenReturn(false);

            stockInformationService.getStockLevel(companyID, mockDb);
        }

    @Test
    public void GivenRegisteredUserCredentials_ShouldReturnTrue() {
        String username = "Daniel";
        String password = "Daniel123";

        when(mockDb.isRegisteredUser(username, password)).thenReturn(true);

        boolean isValidUser = mockDb.isRegisteredUser(username, password);

        assertTrue(isValidUser);
        verify(mockDb).isRegisteredUser(username, password);
    }

    @Test()
    public void GivenUnregisteredUserCredentials_ShouldReturnFalse() {
        String username = "Iceland";
        String password = "Norway";

        when(mockDb.isRegisteredUser(username, password)).thenReturn(false);

        boolean isInvalidUser = mockDb.isRegisteredUser(username, password);

        assertFalse(isInvalidUser);
        verify(mockDb).isRegisteredUser(username, password);
    }

    @Test()
    public void GivenValidCompanyID_ShouldReturnExpectedStockLevel() {
        int companyID = 1;
        int expectedStockLevel = 11;

        when(mockDb.getStockLevelByCompanyID(companyID)).thenReturn(expectedStockLevel);

        int actualStockLevel = mockDb.getStockLevelByCompanyID(companyID);

        assertEquals(expectedStockLevel, actualStockLevel);
        verify(mockDb).getStockLevelByCompanyID(companyID);
    }

    @Test()
    public void GivenInvalidCompanyID_ShouldThrowInvalidCompanyIDException() throws QAInvalidCompanyIDException {
        int companyID = 101;

        when(mockDb.isValidCompanyID(companyID)).thenReturn(false);

        boolean invalidCompanyID = mockDb.isValidCompanyID(companyID);
        assertFalse(invalidCompanyID);
    }
    
}
