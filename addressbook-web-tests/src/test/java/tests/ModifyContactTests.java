package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModifyContactTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().HomePage();
      app.contact().create(new ContactData().withFirstName("Name").withMiddleName("MiddleName").withLastName("Last").withNickName("Nick").withTitle("Title").withCompany("Company")
              .withAddress("Flat 54\n" +
                      "65B Piekna Street\n" +
                      "Warsaw\n" +
                      "00-000")
              .withHome("12345").withMobile("154456").withWork("67859").withFax("Fax").withEmail("e-mail").withGroup("test2"), true);
    }
  }

  @Test
  public void testModifyContact() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("src/test/resources/dog.jpg");
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Name").withMiddleName("MiddleName").withLastName("Last").withNickName("Nick").withTitle("Title").withCompany("Company")
            .withAddress("Flat 54\n" +
                    "65B Piekna Street\n" +
                    "Warsaw\n" +
                    "00-000")
            .withHome("12345").withMobile("67859").withWork("154456").withFax("Fax").withEmail("e-mail").withPhoto(photo);
    app.goTo().HomePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
