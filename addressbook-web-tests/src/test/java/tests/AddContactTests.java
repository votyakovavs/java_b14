package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddContactTests extends TestBase{

  @Test
  public void testAddContact() {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Name11", "MiddleName11", "Last11", "Nick11", "Title11", "Company11", "Address11", "Home11", "Mobile11", "Work11", "Fax11", "e-mail11", "test2");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()+1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
