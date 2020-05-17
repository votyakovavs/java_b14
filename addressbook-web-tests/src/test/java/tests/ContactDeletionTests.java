package tests;

import model.ContactData;
import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeleteContact() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail", "test2"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    //app.getContactHelper().selectContact("9");
    app.getContactHelper().selectContactVer2(before.size()-1);
    app.getContactHelper().deleteSelectedContacts();
    app.allert();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
