package model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("user")
@Entity
@Table(name = "mantis_user_table")
public class UserData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "username")
  private String userName;
  @Expose
  @Column(name = "realname")
  private String realName;
  @Expose
  @Column(name = "email")
  private String email;
  @Expose
  @Column(name = "password")
  private String password;

  public int getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getRealName() {
    return realName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withUserName(String username) {
    this.userName = username;
    return this;
  }

  public UserData withRealName(String realname) {
    this.realName = realname;
    return this;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserData withPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return id == userData.id &&
            Objects.equals(userName, userData.userName) &&
            Objects.equals(realName, userData.realName) &&
            Objects.equals(email, userData.email) &&
            Objects.equals(password, userData.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, realName, email, password);
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", username='" + userName + '\'' +
            ", realname='" + realName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
  }

}