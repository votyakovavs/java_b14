package ru.stqa.pft.sandbox;

public class Point {
  public double a;
  public double b;

  public Point(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double distance(Point other) {
    return Math.sqrt(Math.pow((other.a - this.a), 2) + Math.pow((other.b - this.b), 2));
  }
}

