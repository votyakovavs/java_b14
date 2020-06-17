package generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognised format");
    }
  }

  private void saveJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveCsv(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
              contact.getFirstName(), contact.getMiddleName(), contact.getLastName(),
              contact.getNickName(), contact.getTitle(), contact.getCompany(),
              contact.getAddress(), contact.getHome(), contact.getMobile(),
              contact.getWork(), contact.getFax(), contact.getEmail(), contact.getGroup(), contact.getPhoto()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("Name%s", i))
              .withMiddleName(String.format("MiddleName%s", i))
              .withLastName(String.format("Last%s", i))
              .withNickName(String.format("Nick%s", i))
              .withTitle(String.format("Title%s", i))
              .withCompany(String.format("Company%s", i))
              .withAddress(String.format("Address%s", i))
              .withHome(String.format("Home%s", i))
              .withMobile(String.format("4555%s", i))
              .withWork(String.format("789%s", i))
              .withFax(String.format("111%s", i))
              .withEmail(String.format("Email%s", i))
              .withGroup(String.format("test%s", i)));
    }
    return contacts;
  }
}
