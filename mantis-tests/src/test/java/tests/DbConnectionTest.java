package tests;

import model.UserData;
import model.Users;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

  @Test
  public void testDbConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select id, username, realname, email, password from mantis_user_table");
      Users users = new Users();
      while (rs.next()) {
        users.add(new UserData().withId(rs.getInt("id"))
                .withUserName(rs.getNString("username"))
                .withRealName(rs.getNString("realname"))
                .withEmail(rs.getNString("email"))
                .withPassword(rs.getNString("password")));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(users);
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }
}
