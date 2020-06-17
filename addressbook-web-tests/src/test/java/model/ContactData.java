package model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private Integer id = Integer.MAX_VALUE;
  @Expose
  private String firstName;
  @Expose
  private String middleName;
  @Expose
  private String lastName;
  @Expose
  private String nickName;
  @Expose
  private String title;
  @Expose
  private String company;
  @Expose
  private String address;
  @Expose
  private String home;
  @Expose
  private String mobile;
  @Expose
  private String work;
  @Expose
  private String fax;
  private String allEmails;
  @Expose
  private String group;
  private String allPhones;
  @Expose
  private String eMail;
  @Expose
  private String eMail2;
  @Expose
  private String eMail3;
  @Expose
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public String getEmail() {
    return eMail;
  }

  public String getEmail2() {
    return eMail2;
  }

  public String getEmail3() {
    return eMail3;
  }

  public Integer getId() {
    return id;
  }

  public String getAllPhones() {
    return allPhones;
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

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withEmail2(String eMail2) {
    this.eMail2 = eMail2;
    return this;
  }

  public ContactData withEmail(String eMail) {
    this.eMail = eMail;
    return this;
  }

  public ContactData withEmail3(String eMail3) {
    this.eMail3 = eMail3;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withId(Integer id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

}
