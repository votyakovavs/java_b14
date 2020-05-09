package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeleteContact() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail", "test2"), true);
    }
    //app.getContactHelper().selectContact("9");
    app.getContactHelper().selectContactVer2();
    app.getContactHelper().deleteSelectedContacts();
    app.allert();
    app.getNavigationHelper().goToHomePage();
  }

}
