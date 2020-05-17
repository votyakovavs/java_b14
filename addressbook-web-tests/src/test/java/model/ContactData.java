package model;

import java.util.Objects;

public class ContactData {
  private final Integer id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String theTitle;
  private final String theCompany;
  private final String theAddress;
  private final String theHome;
  private final String theMobile;
  private final String theWork;
  private final String theFax;
  private final String eMail;
  private final String theGroup;

  public ContactData(String firstName, String middleName, String lastName, String nickName, String theTitle, String theCompany, String theAddress, String theHome, String theMobile, String theWork, String theFax, String eMail, String theGroup) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.theTitle = theTitle;
    this.theCompany = theCompany;
    this.theAddress = theAddress;
    this.theHome = theHome;
    this.theMobile = theMobile;
    this.theWork = theWork;
    this.theFax = theFax;
    this.eMail = eMail;
    this.theGroup = theGroup;
  }

  public ContactData(Integer id, String firstName, String middleName, String lastName, String nickName, String theTitle, String theCompany, String theAddress, String theHome, String theMobile, String theWork, String theFax, String eMail, String theGroup) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.theTitle = theTitle;
    this.theCompany = theCompany;
    this.theAddress = theAddress;
    this.theHome = theHome;
    this.theMobile = theMobile;
    this.theWork = theWork;
    this.theFax = theFax;
    this.eMail = eMail;
    this.theGroup = theGroup;
  }

  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTheTitle() {
    return theTitle;
  }

  public String getTheCompany() {
    return theCompany;
  }

  public String getTheAddress() {
    return theAddress;
  }

  public String getTheHome() {
    return theHome;
  }

  public String getTheMobile() {
    return theMobile;
  }

  public String getTheWork() {
    return theWork;
  }

  public String getTheFax() {
    return theFax;
  }

  public String geteMail() {
    return eMail;
  }

  public String getTheGroup() {
    return theGroup;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
