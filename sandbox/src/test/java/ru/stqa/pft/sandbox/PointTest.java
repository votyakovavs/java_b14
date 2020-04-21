package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void testDistance1() {
    Point p1 = new Point(-2, 4);
    Point p2 = new Point(8, 1);
    Assert.assertEquals(p1.distance(p2),10.44);
  }
  @Test
  public void testDistance2() {
    Point p1 = new Point(-2.3, 4);
    Point p2 = new Point(8.5, 0.7);
    Assert.assertEquals(p1.distance(p2),11.29);
  }
  @Test
  public void testDistance3() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2),0);
  }
}
