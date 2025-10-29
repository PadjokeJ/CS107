package dev.padjokej.oop;

class BanqueOOP {
  public static void main(String[] args) {
    Client pedro = new Client("Pedro", "Geneve", 1000.0, 2000.0);
    System.out.println(pedro);
    pedro.bouclerComptes();
    System.out.println(pedro);

    Client alexandra = new Client("Alexandra", "Lausanne", 3000.0, 4000.0);
    System.out.println(alexandra);
    alexandra.bouclerComptes();
    System.out.println(alexandra);
 
  }
}

class Client {
  private static final double tauxPriv = 0.01;
  private static final double tauxEpar = 0.02;

  private double soldePriv;
  private double soldeEpar;

  String nom;
  String ville;

  public Client(String n, String v, double p, double e) {
    soldePriv = p;
    soldeEpar = e;
    nom = n;
    ville = v;
  }

  public Client(String n) {
    this(n, "Lausanne", 0.0, 0.0);
  }

  public double getSolde(int acc) {
    return switch (acc) {
      case 0 -> soldePriv;
      case 1 -> soldeEpar;
      default -> 0.0;
    };
  }
  
  public void bouclerComptes() {
    this.bouclerCompte(0);
    this.bouclerCompte(1);
  }

  public void bouclerCompte(int acc) {
    switch (acc) {
      case 0 -> soldePriv *= (tauxPriv + 1);
      case 1 -> soldeEpar *= (tauxEpar + 1);
    };
  }

  public String toString() {
    return "Client " + nom + " de " + ville + "\n"
      + "Compte privé   : " + soldePriv + "\n"
      + "Compte epargne : " + soldeEpar;
  }
}

