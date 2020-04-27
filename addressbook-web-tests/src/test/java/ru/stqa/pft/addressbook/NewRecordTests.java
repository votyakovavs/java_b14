package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class NewRecordTests extends TestBase{

  @Test
  public void testNewRecord() throws Exception {
    goToAddNewPage();
    fillNewRecord(new NewRecordData("Name", "MiddleName", "Last", "Nick", "Title", "Company", "Address", "Home", "Mobile", "Work", "Fax", "e-mail"));
    submitNewRecord();
    returnToHomePage();
  }
}
