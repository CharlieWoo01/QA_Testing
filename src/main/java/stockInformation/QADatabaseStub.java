package stockInformation;

public class QADatabaseStub implements IQADatabase
{
    private String[] userNames = {
        "Daniel","Michal","Nathaniel","Wilshire",
        "Nicholas","Steven","Alexander","Robert",
        "Thomas","Sree","David","Darren"
    };

    private String[] passwords = {
        "Daniel123","Michal123","Nathaniel123","Wilshire123",
        "Nicholas123","Steven123","Alexander123","Robert123",
        "Thomas123","Sree123","David123","Darren123"
    };

    private int[] companyIDs = {
        1, 4, 5, 9, 12, 16, 25, 30, 36, 40, 49, 64, 81, 99
    };

    public static int[] stockLevels = {
        11, 14, 15, 19, 112, 116, 125, 130, 136, 140, 149, 164, 181, 199
    };

    public boolean isRegisteredUser(String username, String password)
    {
        for (int i = 0; i < userNames.length; i++)
        {
            if (userNames[i].equalsIgnoreCase(username))
            {
                if (passwords[i].equals(password))
                    return true;
            }
            return false;
        }
        return true;
    }

    public boolean isValidCompanyID(int companyID) throws QAInvalidCompanyIDException 
    {
        if (companyID < 0 || companyID > 100)
            throw new QAInvalidCompanyIDException();

        for (int id : companyIDs)
        {
            if (id == companyID)
                return true;
        }
        return false;
    }

    public int getStockLevelByCompanyID(int companyID)
    {
        for (int i = 0; i < companyIDs.length; i++)
        {
            if (companyIDs[i] == companyID)
            {
                return stockLevels[i];
            }
        }
        return -1;
    }
}

