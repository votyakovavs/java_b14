package tests;

import org.testng.annotations.Test;
import model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test2", "test", "test"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }
}