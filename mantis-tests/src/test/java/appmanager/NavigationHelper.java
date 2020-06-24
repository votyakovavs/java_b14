package appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void manageUsersPage() {
    click(By.xpath("//span[contains(text(),'Управление')]/.."));
    click(By.linkText("Управление пользователями"));
  }

  public void userPage(String username) {
    click(By.linkText(username));
  }

  public void resetPassword() {
    click(By.xpath("//input[@value='Сбросить пароль']"));
  }

}