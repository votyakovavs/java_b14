package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void GroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("New"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void HomePage() {
    if (isElementPresent(By.name("MainForm"))) {
      return;
    }
    click(By.linkText("home"));
  }

}
