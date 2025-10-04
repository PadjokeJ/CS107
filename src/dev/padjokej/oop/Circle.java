package dev.padjokej.oop;

public class Circle {
  private double radius;
  private double x;
  private double y;
  
  public void setCenter(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public void setRadius(double r) {
    this.radius = r;
  }

  public double squareDistance(double x, double y) {
    double delta_x = (x - this.x);
    double delta_y = (y - this.y);

    double square_dist = delta_x * delta_x + delta_y * delta_y;
    return square_dist;
  }

  public double getArea() {
    double pi = Math.PI;
    return pi * this.radius * this.radius;
  }

  public boolean isWithin(double x, double y) {
    double sqrdist = this.squareDistance(x, y);
    double sqrrad = this.radius * this.radius;

    return sqrdist <= sqrrad;
  }

  public static void main() {
    Circle circ1 = new Circle();
    circ1.setRadius(10.0);
    circ1.setCenter(5.0, 5.0);

    Circle circ2 = new Circle();
    circ2.setRadius(10.0);
    circ2.setCenter(0.0, 0.0);

    Circle circ3 = new Circle();
    circ3.setRadius(8.0);
    circ3.setCenter(5.0, 5.0);

    System.out.println("Circle 1 surf : " + circ1.getArea());
    System.out.println("Circle 2 surf : " + circ2.getArea());
    System.out.println("Circle 3 surf : " + circ3.getArea());

    System.out.println();

    System.out.println("Is Point (8, 8) within Circle 1? : " + circ1.isWithin(8.0, 8.0));
    System.out.println("Is Point (11, 11) within Circle 2? : " + circ2.isWithin(11.0, 11.0));

  }
}
