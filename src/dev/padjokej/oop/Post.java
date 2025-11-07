class Post {

	public static void  main(String args[]) {
		LetterBox letterBox = new LetterBox(30);

		//Creation de divers courriers/colis..
		Letter lettre1 = new Letter(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
		Letter lettre2 = new Letter(800, false, "", "A4"); // invalide

		Advert pub1 = new Advert(1500, true, "Les Moilles  13A, 1913 Saillon");
		Advert pub2 = new Advert(3000, false, ""); // invalide

		Pack colis1 = new Pack(5000, true, "Grand rue 18, 1950 Sion", 30);
		Pack colis2 = new Pack(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Pack invalide !

		letterBox.addMail(lettre1);
		letterBox.addMail(lettre2);
		letterBox.addMail(pub1);
		letterBox.addMail(pub2);
		letterBox.addMail(colis1);
		letterBox.addMail(colis2);


		System.out.println("Le montant total d'affranchissement est de " +
						  letterBox.affranchir());
		letterBox.afficher();
		
		System.out.println("La letterBox contient " + letterBox.courriersInvalides()
						  + " courriers invalides");
	}
}

class LetterBox {
  Mail[] mailInBox;
  int index;
  double total;
  public LetterBox (int n) {
    mailInBox = new Mail[n];
    index = 0;
    total = 0.0;
  }

  public void addMail(Mail mail) {
    mailInBox[index] = mail;
    index++;
  }

  public double affranchir() {
    total = 0.0;
    for (int i = 0; i < index; i++) {
      Mail mail = mailInBox[i];
      if (mail != null)
        total += mail.affranchir();
    }
    return total;
  }

  public void afficher() {
    System.out.println(this);
  }

  public int courriersInvalides() {
    int n = 0;
    for (Mail mail : mailInBox) {
      if (mail != null && mail.isInvalid()) {
        n++;
      }
    }
    return n;
  }

  public String toString() {
    String contents = "";

    for (Mail mail : mailInBox) {
      if (mail != null)
        contents += mail + "\n\n";
    }

    return contents;
  }
}

class Mail {
  int weight;
  boolean express;
  String address;

  public Mail (int w, boolean e, String a) {
    weight = w;
    express = e;
    address = a;
  }
  
  public String mailType() {
    return this.getClass().getName();
  }

  public double mailPrice() { return 0.0; }

  public boolean isInvalid() {
    return address.isEmpty();
  }

  public double affranchir() {
    if (isInvalid()) {
      return 0.0;
    }
    if (express) {
      return 2.0 * mailPrice();
    }
    return mailPrice();
  }

  public String toString() {
    String invalidString = "";
    double price = mailPrice();
    if (isInvalid()) {
      invalidString = "(Invalid Mail)\n";
      price = 0.0;
    }
    return 
      mailType() + "\n"
      + invalidString
      + " -> Weight  : " + weight  + "\n"
      + " -> Address : " + address + "\n"
      + " -> Express : " + express + "\n"
      + " -> Price   : " + price;
  }
}

class Letter extends Mail {
  String letterSize;
  public Letter(int w, boolean e, String a, String t) {
    super(w, e, a);
    letterSize = t;
  }

  public double mailPrice() {
    double basePrice = 0;
    if (letterSize.equals("A3")) {
      basePrice = 3.50;
    } else if (letterSize.equals("A4")) {
      basePrice = 2.50;
    }
    
    return basePrice + (weight / 1000.0);
  }

  public String toString() {
    return super.toString() + "\n"
      + " -> Format  : " + letterSize;
  }
}

class Pack extends Mail {
  double volume;
  public Pack(int w, boolean e, String a, double v) {
    super(w, e, a);
    volume = v;
  }

  public double mailPrice() {
    return volume * 0.25 + (weight / 1000.0);
  }

  public boolean isInvalid() {
    return super.isInvalid() || volume > 50.0;
  }

  public String toString() {
    return super.toString() + "\n"
      + " -> Volume  : " + volume;
  }
}

class Advert extends Mail {
  public Advert(int w, boolean e, String a) {
    super(w, e, a);
  }

  public double mailPrice() {
    return 5.0 * (weight / 1000.0);
  }
}
