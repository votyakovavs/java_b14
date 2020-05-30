package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail", "test2"), true);
    }
  }

  @Test
  public void testDeleteContact() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().del(index);
    app.allert();
    app.goTo().HomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
