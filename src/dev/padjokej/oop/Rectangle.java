package dev.padjokej.oop;

class Rectangle {
  private double largeur;
  private double hauteur;

  public Rectangle(double l, double h) {
    largeur = l;
    hauteur = h;
  }

  public double surface() {
    return largeur * hauteur;
  }

  public double getLargeur() {
    return largeur;
  }
  public double getHauteur() {
    return hauteur;
  }
  public void setHauteur(double h) {
    if (h < 0)
      h *= -1;
    hauteur = h;
  }
  public void setLargeur(double l) {
    if (l < 0)
      l *= -1;
    largeur = l;
  }
}
