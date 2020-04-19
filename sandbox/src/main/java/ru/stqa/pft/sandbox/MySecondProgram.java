package ru.stqa.pft.sandbox;

public class MySecondProgram {
  public static void main(String[] args) {
    Point p1 = new Point(-2, 4);
    Point p2 = new Point(8, 1);
    System.out.println("Расстояние между точками a(" + p1.a + "," + p1.b + ") и b(" + p2.a + "," + p2.b + ") = " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.a - p1.a), 2) + Math.pow((p2.b - p1.b), 2));
  }
}
