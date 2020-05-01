package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void fillContact(ContactData contactData) {
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
  }

  /*  public void selectContact(String id) {
      click(By.id(id));
    }*/
  public void selectContactVer2() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  /*public void initEditContact(String numOfContact) {
    click(By.xpath("(//img[@alt='Edit'])["+numOfContact+"]"));
  }*/
  public void initEditContactVer2() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

}
