package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void fillContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTheTitle());
    type(By.name("company"), contactData.getTheCompany());
    type(By.name("address"), contactData.getTheAddress());
    type(By.name("home"), contactData.getTheHome());
    type(By.name("mobile"), contactData.getTheMobile());
    type(By.name("work"), contactData.getTheWork());
    type(By.name("fax"), contactData.getTheFax());
    type(By.name("email"), contactData.geteMail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getTheGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  /*  public void selectContact(String id) {
      click(By.id(id));
    }*/
  public void selectContactVer2(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  /*public void initEditContact(String numOfContact) {
    click(By.xpath("(//img[@alt='Edit'])["+numOfContact+"]"));
  }*/
  public void initEditContactVer2(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    if (isElementPresent(By.name("MainForm"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void goToAddNewPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("submit"))) {
      return;
    }
    click(By.linkText("add new"));
  }

  public void createContact(ContactData contactData, boolean creation) {
    goToAddNewPage();
    fillContact(contactData, creation);
    submitContact();
    returnToHomePage();
  }

  public void delContact(int index) {
    selectContactVer2(index);
    deleteSelectedContacts();
  }

  public void modifyContact(int index, ContactData contact) {
    initEditContactVer2(index);
    fillContact(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastName = cells.get(2).getText();
      String name = cells.get(1).getText();
      Integer id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, lastName, null, name, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
