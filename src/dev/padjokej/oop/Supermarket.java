import java.util.Date;
import java.util.ArrayList;

public class Supermarket {

    public static void main(String[] args) {
        // Les articles vendus dans le supermarché
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);

        // Les caddies du supermarché
        Caddie caddie1 = new Caddie();
        Caddie caddie2 = new Caddie();
        Caddie caddie3 = new Caddie();

        // Les caisses du supermarché
        // le premier argument est le numero de la caisse
        // le second argument est le montant initial de la caisse.
        Caisse caisse1 = new Caisse(1, 0.0);
        Caisse caisse2 = new Caisse(2, 0.0);

        // les clients font leurs achats
        // le second argument de la méthode remplir
        // correspond à une quantité

        // remplissage du 1er caddie
        caddie1.remplir(choufleur, 2);
        caddie1.remplir(cdrom, 1);
        caddie1.remplir(biscuits, 4);
        caddie1.remplir(boisson, 6);
        caddie1.remplir(poisson, 2);

        // remplissage du 2eme caddie
        caddie2.remplir(roman, 1);
        caddie2.remplir(camembert, 1);
        caddie2.remplir(petitspois, 2);
        caddie2.remplir(poires, 2);

        // remplissage du 3eme caddie
        caddie3.remplir(cafe, 2);
        caddie3.remplir(pain, 1);
        caddie3.remplir(camembert, 2);

        // Les clients passent à la caisse
        caisse1.scanner(caddie1);
        caisse1.scanner(caddie2);
        caisse2.scanner(caddie3);
        
        caisse1.totalCaisse();
        caisse2.totalCaisse();
    }
}

class Article {
  private String name;
  private double price;
  private boolean isCheaper;
  
  private int quantity;

  public Article(String name, double price, boolean isCheaper) {
    this.name = name;
    this.price = price;
    this.isCheaper = isCheaper;

    this.quantity = 1;
  }

  public Article clone() {
    return new Article(name, price, isCheaper);
  }

  public double getPrice() {
    double coeff = 1;
    if (this.isCheaper) 
      coeff = 0.5;
    return price * quantity * coeff;
  }

  public void setQuantity(int q) {
    quantity = q;
  }
  public int getQuantity() {
    return quantity;
  }

  public String toString() {
    String toAppend = "";
    if (this.isCheaper) 
      toAppend = " (1/2 prix)";
    return name + " : " + price + " * " + quantity + " = " + getPrice() + " Frs" + toAppend;
  }
}

class Caddie {
  private ArrayList<Article> items;

  public Caddie() {
    items = new ArrayList<Article>();
  }

  public void remplir(Article item, int quantity) {
    Article itemToAdd = item.clone();
    itemToAdd.setQuantity(quantity);

    items.add(itemToAdd);
  }

  public ArrayList<Article> getItems() {
    return items;
  }
}

class Caisse {
  private ArrayList<Article> items;
  
  private int id;
  private double totalPrice;

  public Caisse(int id, double totalPrice) {
    this.id = id;
    this.totalPrice = totalPrice;

    items = new ArrayList<Article>();
  }

  public void scanner(Caddie caddie) {
    this.items.addAll(caddie.getItems());
    bakePrice();
    printTicket(caddie);
  }
  
  public void printTicket(Caddie caddie) {
    System.out.println("== == == == == == == == == == == == == == ==");
    System.out.println(new Date());
    System.out.println();
    double price = 0.0;
    for (Article item : caddie.getItems()) {
      System.out.println(item);
      price += item.getPrice();
    }
    System.out.println();
    System.out.println("Montant à payer : " + price);
    System.out.println("== == == == == == == == == == == == == == ==");
  }

  public void bakePrice() {
    totalPrice = 0.0;
    for (Article item : items) {
      totalPrice += item.getPrice();
    }
  }

  public double totalCaisse() {
    System.out.println("La caisse " + id + " a encaissé " + totalPrice + " Frs aujourd'hui");
    return totalPrice;
  }
}
