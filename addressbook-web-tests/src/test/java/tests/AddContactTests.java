package tests;

import org.testng.annotations.Test;
import model.ContactData;

public class AddContactTests extends TestBase{

  @Test
  public void testAddContact() {
    app.getContactHelper().createContact(new ContactData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail", "test2"), true);
  }
}
