package stockInformation;

public class QASecurity
{
    public boolean login(String username, String password, IQADatabase qaDb) throws QAInvalidUsernameFormatException, QAInvalidPasswordFormatException
    {
        if (!isValidUsername(username))
            throw new QAInvalidUsernameFormatException();
        
        if (!isValidPassword(password))
            throw new QAInvalidPasswordFormatException();

        return qaDb.isRegisteredUser(username, password);
    }

    public boolean isValidUsername(String username)
    {
        username = username.trim();
        if (username.length() < 3)
            return false;

        for (char c : username.toCharArray())
        {
            if ( !Character.isAlphabetic(c))
                return false;
        }

        return true;
    }
    
    private boolean isValidPassword(String password)
    {
        password = password.trim();
        if (password.length() < 3)
            return false;

        for (char c :  password.toCharArray())
        {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }
}