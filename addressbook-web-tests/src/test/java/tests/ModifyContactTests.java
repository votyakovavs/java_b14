package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ModifyContactTests extends TestBase {

  @Test
  public void testAddContact() {
    app.getNavigationHelper().goToHomePage();
    //app.getContactHelper().initEditContact("2");
    app.getContactHelper().initEditContactVer2();
    app.getContactHelper().fillContact(new ContactData("Name11", "MiddleName11", "Last11", "Nick11", "Title11", "Company11", "Address11", "Home11", "Mobile11", "Work11", "Fax11", "e-mail11", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }

}
