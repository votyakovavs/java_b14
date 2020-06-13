package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactTests extends TestBase {

  @Test
  public void testAddContact() {
    app.goTo().HomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/dog.jpg");
    ContactData contact = new ContactData().withFirstName("Name").withMiddleName("MiddleName").withLastName("Last").withNickName("Nick").withTitle("Title").withCompany("Company")
            .withAddress("Flat 54\n" +
                    "65B Piekna Street\n" +
                    "Warsaw\n" +
                    "00-000\n")
            .withHome("123").withMobile("456").withWork("789").withFax("101112").withEmail("e-mail").withGroup("test2").withPhoto(photo);
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
