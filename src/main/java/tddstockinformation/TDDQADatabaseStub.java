package tddstockinformation;

public class TDDQADatabaseStub implements TDDQADatabase {

    private String[] usernames = {
            "SomeUsername","Michal","Nathaniel","Wilshire",
            "Nicholas","Steven","Alexander","Robert",
            "Thomas","Sree","David","Darren"
    };

    private String[] passwords = {
            "AnotherPassword","Michal123","Nathaniel123","Wilshire123",
            "Nicholas123","Steven123","Alexander123","Robert123",
            "Thomas123","Sree123","David123","Darren123"
    };

    @Override
    public boolean isRegisteredUser(String username, String password) {
        for (int i = 0; usernames.length < i; i++) {
            if (usernames[i].equalsIgnoreCase(username)) {
                if(passwords[i].equalsIgnoreCase(password));
            }
            return false;
        }
        return true;
    }
}
