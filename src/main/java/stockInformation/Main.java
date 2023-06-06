package stockInformation;

public class Main {
    public static void main(String[] args) {

        IQADatabase qaDb = new IQADatabase() {
            @Override
            public boolean isRegisteredUser(String username, String password) {
                return false;
            }

            @Override
            public boolean isValidCompanyID(int companyID) throws QAInvalidCompanyIDException {
                return false;
            }

            @Override
            public int getStockLevelByCompanyID(int companyID) {
                return 0;
            }
        };

        // Create an instance of StockInformation
        StockInformation stockInfo = new StockInformation(qaDb);

        try {
            // Call the login method
            stockInfo.login("Daniel", "Daniel123");

            // Check if the login was successful
            if (stockInfo.isValidated()) {
                // Call the getStockLevel method
                int stockLevel = stockInfo.getStockLevel(1);

                // Print the stock level
                System.out.println("Stock Level: " + stockLevel);
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }
        } catch (QAInvalidUserException e) {
            System.out.println("Invalid user.");
        } catch (QAInvalidUsernameFormatException e) {
            System.out.println("Invalid username format.");
        } catch (QAInvalidPasswordFormatException e) {
            System.out.println("Invalid password format.");
        } catch (QAInvalidCompanyIDException e) {
            System.out.println("Invalid company ID.");
        }
    }
}
