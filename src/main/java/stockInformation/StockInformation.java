package stockInformation;

public class StockInformation
{
    private boolean validated;
    private IQADatabase qaDb;

    public StockInformation(IQADatabase qaDb)
    {
        this.qaDb = qaDb;
        validated = false;
    }

    public boolean isValidated()
    {
        return validated;
    }

    public void login(String username, String password) throws QAInvalidUserException, QAInvalidUsernameFormatException, QAInvalidPasswordFormatException
    {
        QASecurity security = new QASecurity();

        if (!security.login(username, password, qaDb))
            throw new QAInvalidUserException();

        validated = true;
    }

    public int getStockLevel(int companyID) throws QAInvalidCompanyIDException
    {
        if (!isValidated())
            return -1;

        if (!qaDb.isValidCompanyID(companyID))
            throw new QAInvalidCompanyIDException();

        StockInformationWebService ws = new StockInformationWebService();
        return ws.getStockLevel(companyID, qaDb);
    }
}
