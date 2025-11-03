class FiguresGeometriques {
    public static void main(String[] args) {
        RectangleColore rc = new RectangleColore(1.2, 3.4, 4.3, 12.5, 12389);
        rc.affiche();

        Cercle c = new Cercle(2.3, 4.5, 12.2);
        c.affiche();
    }
}

class Rectangle extends Figure {
    private double largeur;
    private double longueur;

    public Rectangle(double x, double y, double largeur, double longueur) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public double surface() {
        return largeur * longueur;
    }

    public double getLongueur() {
        return longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double l) {
        largeur = l;
    }

    public void setLongueur(double l) {
        longueur = l;
    }

    public void affiche() {
        super.affiche();
        System.out.println("w -> " + this.getLargeur() + ", h -> " + this.getLongueur());
    }

}

class Cercle extends Figure {
    private double rayon;

    public Cercle(double x, double y, double r) {
        super(x, y);
        rayon = r;
    }

    public double surface() {
        return Math.PI * rayon * rayon;
    }

    public boolean estInterieur(double x, double y) {
        return (((x - getX()) * (x - getX()) + (y - getY()) * (y - getY()))
                    <= rayon * rayon);
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double r) {
        if (r < 0.0) r = 0.0;
        rayon = r;
    }

    public void affiche() {
        super.affiche();
        System.out.println("r -> " + rayon);
    }
}

class RectangleColore extends Rectangle {
    private int couleur;

    public RectangleColore(double x, double y, double w, double h, int col) {
        super(x, y, w, h);
        couleur = col;
    }

    public void affiche() {
        super.afficher();
        System.out.println("c -> " + couleur);
    }
}

class Figure {
    private double x, y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void affiche() {
        System.out.println("x -> " + x + ", y -> " + y);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}

