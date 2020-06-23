package tests;

import model.ContactData;
import model.Contacts;
import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTests extends TestBase {

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
  public void TestDeleteContactFromGroup() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    if (!contacts.stream().filter((s) -> (s.getGroups().size() > 0)).findAny().isPresent()) {
      app.contact().addContactToGroup(contacts.iterator().next(), groups.iterator().next());
    }
    ContactData deletedFromGroupContact = app.db().contacts().stream().filter((s) -> (s.getGroups().size() > 0)).findAny().get();
    Groups before = deletedFromGroupContact.getGroups();
    GroupData modifiedGroup = before.iterator().next();
    app.contact().deleteContactFromGroup(deletedFromGroupContact, modifiedGroup);
    Groups after = app.db().contacts().stream().filter((s) -> s.equals(deletedFromGroupContact)).findFirst().get().getGroups();
    assertThat(after, equalTo(before.without(modifiedGroup)));
  }
}