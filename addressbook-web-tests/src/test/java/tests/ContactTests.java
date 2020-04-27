package tests;

import org.testng.annotations.Test;
import model.ContactData;

public class ContactTests extends TestBase{

  @Test
  public void testContact() throws Exception {
    app.getNavigationHelper().goToAddNewPage();
    app.getContactHelper().fillContact(new ContactData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail"));
    app.getContactHelper().submitContact();
    app.getNavigationHelper().returnToHomePage();
  }
}
