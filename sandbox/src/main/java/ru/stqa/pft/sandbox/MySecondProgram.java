package ru.stqa.pft.sandbox;

public class MySecondProgram {
  public static void main(String[] args) {
    Point p1 = new Point(-2, 4);
    Point p2 = new Point(8, 1);
    System.out.println("Расстояние между точками a(" + p1.a + "," + p1.b + ") и b(" + p2.a + "," + p2.b + ") = " + p1.distance(p2));
  }
}
