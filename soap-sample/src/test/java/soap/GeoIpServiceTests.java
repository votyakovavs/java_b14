package soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void geoIpServiceTest(){
    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("77.43.243.177");
    assertEquals(geoIP, "<GeoIP><Country>RU</Country><State>90</State></GeoIP>");
  }
  @Test
  public void badGeoIpServiceTest(){
    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("77.43.243.177");
    assertEquals(geoIP, "<GeoIP><Country>FR</Country><State>90</State></GeoIP>");
  }
}