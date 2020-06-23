package tests;

import model.ContactData;
import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().HomePage();
      File photo = new File("src/test/resources/dog.jpg");
      Groups groups = app.db().groups();
      if (groups.size() == 0) {
        app.goTo().GroupPage();
        app.group().create(new GroupData().withName("test100"));
      }
      app.contact().create(new ContactData().withFirstName("Name").withMiddleName("MiddleName").withLastName("Last").withNickName("Nick").withTitle("Title").withCompany("Company")
              .withAddress("Flat 54\n" +
                      "65B Piekna Street\n" +
                      "Warsaw\n" +
                      "00-000")
              .withHome("12345").withMobile("154456").withWork("67859").withFax("Fax").withEmail("e-mail").withPhoto(photo).inGroup(groups.iterator().next()), true);
    }
  }

  @Test
  public void TestAddContactToGroup() {
    Groups groups = app.db().groups();
    ContactData addedToGroupContact =
            app.db().contacts().stream().filter((s) -> (s.getGroups().size() < groups.size())).findAny().get();
    Groups before = addedToGroupContact.getGroups();
    GroupData group = groups.without(addedToGroupContact.getGroups()).iterator().next();
    app.contact().addContactToGroup(addedToGroupContact, group);
    app.goTo().HomePage();
    Groups after = app.db().contacts().stream().filter((s) -> s.equals(addedToGroupContact)).findFirst().get().getGroups();
    assertThat(after, equalTo(before.withAdded(group)));
  }
}