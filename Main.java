package sit707_week2;

public class Main {
    public static void main(String[] args) {
        // Call Officeworks registration
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        
        // Call eBay registration
        SeleniumOperations.registration_page("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror");
    }
}