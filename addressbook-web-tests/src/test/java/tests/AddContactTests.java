package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactTests extends TestBase {

  @Test
  public void testAddContact() {
    app.goTo().HomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Name").withMiddleName("MiddleName").withLastName("Last").withNickName("Nick").withTitle("Title").withCompany("Company").withAddress("Address").withHome("Home").withMobile("Mobile").withWork("Work").withFax("Fax").withEmail("e-mail").withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
