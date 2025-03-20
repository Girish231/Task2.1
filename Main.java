package sit707_week2;

/**
 * Main class to execute the Selenium registration operation.
 * 
 * @author Ahsan Habib
 */
public class Main 
{
    public static void main(String[] args) 
    {
        // Call the Selenium function to perform registration on Officeworks
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
    }
}
