package tests;

import model.MailMessage;
import model.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangeUserPasswordTests extends TestBase {
  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    UserData user = app.db().users().stream().filter((m) -> !m.getUserName().equals("administrator")).iterator().next();
    String username = user.getUserName();
    String email = user.getEmail();
    String password = "root";
    app.uiSession().loginFromUI();
    app.goTo().manageUsersPage();
    app.goTo().userPage(username);
    app.goTo().resetPassword();
    app.uiSession().logout();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = app.mail().findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user.getUserName(), password));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}