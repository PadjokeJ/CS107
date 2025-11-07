import java.time.Year;

public class Direction {
  public static void main(String[] args) {
    Student gaston = new Student("Gaston Peutimide" , 2020, "SSC", 6.0);
    Student yvan   = new Student("Yvan Rattrapeur"  , 2016, "SSC", 2.5);
    ExchangeStudent bjorn = new ExchangeStudent("Bjorn Borgue", 2018, "Informatique", "KTH");
    Teacher mathieu = new Teacher("Mathieu Matheu"  , 2015, 10000, "LMEP", "Physique");
    Secretary soph = new Secretary("Sophie Scribona", 2005, 5000 , "LMT" );
    
    Person[] EPFLiens = { gaston, yvan, bjorn, mathieu, soph };
    
    int numStudents = 0;
    int year = Year.now().getValue();
    int totalDelta = 0;
    
    for (Person guy : EPFLiens) {
      if (guy instanceof Student || guy instanceof ExchangeStudent) {
        numStudents++;
      }
      totalDelta += (year - guy.year);
    }
    
    System.out.println("Between the " + EPFLiens.length + " EPFLiens, there is " + numStudents + " students");
    System.out.println("They are here for an average of " + totalDelta / EPFLiens.length + "years");
    System.out.println(" vvv List of EPFLiens vvv ");
    for (Person guy : EPFLiens) {
      System.out.println(guy);
    }

  }
}

class Person {
  public String name;
  public int year;
  
  public String what;
  
  public Person (String name, int year) {
    this.what = "Person";
    this.name = name;
    this.year = year;
  }

  public String toString() {
    return what + ": \n"
      + "  Nom     - " + name + "\n"
      + "  Annee   - " + year;
  }
}


class Salaried extends Person {
  public int salary;
  
  public String laboratory;

  public Salaried (String name, int year, int salary, String lab) {
    super(name, year);
    
    this.what = "Salaried Person";

    this.salary = salary;
    this.laboratory = lab;
  }

  public String toString() {
    return super.toString() + "\n"
      + "  Lab     - " + laboratory + "\n"
      + "  Salary  - " + salary;
  }
}

class Secretary extends Salaried {
public Secretary (String name, int year, int salary, String lab) {
    super(name, year, salary, lab);

    this.what = "Secretary";
  }
}

class Teacher extends Salaried {
  String section;
  public Teacher (String name, int year, int salary, String lab, String section) {
    super(name, year, salary, lab);
    
    this.section = section;

    this.what = "Teacher";
  }
  public String toString() {
    return super.toString() + "\n"
      + "  Section - " + section;
  }
}

class Section extends Person {
  public String section;

  public Section (String name, int year, String section) {
    super(name, year);
    this.what = "Student";

    this.section = section;
  }

  public String toString() {
    return super.toString() + "\n"
      + "  Section - " + section;
  }
}

class Student extends Section {
  public double grade;

  public Student (String name, int year, String section, double grade) {
    super(name, year, section);
    this.what = "Regular " + this.what;

    this.grade = grade;
  }

  public String toString() {
    return super.toString() + "\n"
      + "  Grade   - " + grade;
  }
}

class ExchangeStudent extends Section {
  public String origin;

  public ExchangeStudent (String name, int year, String section, String origin) {
    super(name, year, section);

    this.what = "Exchange " + this.what;

    this.origin = origin;
  }

  public String toString() {
    return super.toString() + "\n"
      + "  Origin  - " + origin;
  }
}

