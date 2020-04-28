package tests;

import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

  @Test
  public void testDeleteContact() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact("9");
    app.getContactHelper().deleteSelectedContacts();
    app.allert();
    app.getNavigationHelper().goToHomePage();
  }

}
