package stockInformation;

interface IStockInformationWebService
{
    int getStockLevel(int companyID, IQADatabase db);
}

public class StockInformationWebService implements IStockInformationWebService
{
    public int getStockLevel(int companyID, IQADatabase db)
    {
        return db.getStockLevelByCompanyID(companyID);
    }
}
