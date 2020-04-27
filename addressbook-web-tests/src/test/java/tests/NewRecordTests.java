package tests;

import org.testng.annotations.Test;
import model.NewRecordData;

public class NewRecordTests extends TestBase{

  @Test
  public void testNewRecord() throws Exception {
    app.getNavigationHelper().goToAddNewPage();
    app.getNewRecordHelper().fillNewRecord(new NewRecordData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail"));
    app.getNewRecordHelper().submitNewRecord();
    app.getNavigationHelper().returnToHomePage();
  }
}
