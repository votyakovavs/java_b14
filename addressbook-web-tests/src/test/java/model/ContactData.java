package model;

public class ContactData {
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

  public ContactData(String firstName, String middleName, String lastName, String nickName, String theTitle, String theCompany, String theAddress, String theHome, String theMobile, String theWork, String theFax, String eMail) {
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
}
