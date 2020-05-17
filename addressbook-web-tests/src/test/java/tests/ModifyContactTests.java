package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ModifyContactTests extends TestBase {

  @Test
  public void testAddContact() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail", "test2"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    //app.getContactHelper().initEditContact("2");
    app.getContactHelper().initEditContactVer2(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Name11", "MiddleName11", "Last11", "Nick11", "Title11", "Company11", "Address11", "Home11", "Mobile11", "Work11", "Fax11", "e-mail11", null);
    app.getContactHelper().fillContact(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
