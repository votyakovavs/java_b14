package tests;

import org.testng.annotations.Test;
import model.NewRecordData;

public class NewRecordTests extends TestBase{

  @Test
  public void testNewRecord() throws Exception {
    app.goToAddNewPage();
    app.fillNewRecord(new NewRecordData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail"));
    app.submitNewRecord();
    app.returnToHomePage();
  }
}
