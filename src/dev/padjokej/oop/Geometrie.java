import java.util.Scanner;
import java.lang.Math;

class Geometrie {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Point[] p = new Point[3];
    for (int i = 0; i < 3; i++) {
      System.out.println("Construction d'un nouveau point");
      System.out.print("  x : ");
      double x = s.nextDouble();
      System.out.print("  y : ");
      double y = s.nextDouble();
      p[i] = new Point(x, y);
    }

    Triangle t = new Triangle(p);
    System.out.println(t);
  }
}

class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    setPos(x, y);
  }

  public void setX(double x) {
    this.x = x;
  }
  public void setY(double y) {
    this.y = y;
  }
  public void setPos(double x, double y) {
    setX(x);
    setY(y);
  }

  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }
  
  public double distance(Point p) {
    double otherX = p.getX();
    double otherY = p.getY();
    
    double deltaX = otherX - x;
    double deltaY = otherY - y;

    double sqrDist = deltaX * deltaX + deltaY * deltaY;

    return Math.sqrt(sqrDist);
  }

  public String toString() {
    return "x : " + x + ", y : " + y;
  }
}

class Triangle {
  private Point s1, s2, s3;

  public Triangle(Point[] points) {
    this(points[0], points[1], points[2]);
  }
  public Triangle(Point p1, Point p2, Point p3) {
    s1 = p1;
    s2 = p2;
    s3 = p3;
  }

  public Point getPoint(int index) {
    return switch (index) {
      case 0 -> s1;
      case 1 -> s2;
      case 2 -> s3;
      default -> null;
    };
  }

  public double perimeter() {
    return s1.distance(s2) + s2.distance(s3) + s3.distance(s1);
  }

  public String toString() {
    return "Triangle \n" 
      + " Points : \n"
      + "  Point 1 : " + getPoint(0) + "\n" 
      + "  Point 2 : " + getPoint(1) + "\n"
      + "  Point 3 : " + getPoint(2) + "\n"
      + " Perimeter : \n  " + perimeter() + "\n";
  }
}
