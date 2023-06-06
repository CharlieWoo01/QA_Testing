package stockInformation;

public interface IQADatabase
{
    boolean isRegisteredUser(String username, String password);
    
    boolean isValidCompanyID(int companyID) throws QAInvalidCompanyIDException;

    int getStockLevelByCompanyID(int companyID);
}

