package dev.padjokej.oop;

import dev.padjokej.oop.Rectangle;

class ManipRectangle {
  public static void main(String[] args) {
    Rectangle rect = new Rectangle(20.0, 15.8);
    System.out.println(rect.surface());
    rect.setLargeur(6.7);
    System.out.println(rect.surface());
  }
}
