/*
  Seth Sevier
  CS 249
  V4_Problem_8_page_472
    Define Pet as a superclass of Dog and Cat classes.
    Define acepromazine() and carprofen() in Pet to return 0.
    Overwrite both in methods to calculate the correct dosage.

  Takes no inputs, displays four dosages.
*/

import java.text.DecimalFormat;

class Pet
{
    /* Variables */
    private String name;
    private int age;
    private double weight;

    /* Constructors */
    public Pet(String initialName, int initialAge, double initialWeight)
    {
	name = initialName;
	if ((initialAge < 0) || (initialWeight < 0))
	    {
		System.out.println("Error: Negative age or weight");
		System.exit(0);
	    }
	else
	    {
		age = initialAge;
		weight = initialWeight;
	    }
    }
    public Pet(String initialName)
    {
	name = initialName;
	age = 0;
	weight = 0;
    }
    public Pet(int initialAge)
    {
	name = "No name yet.";
	weight = 0;
	if (initialAge < 0)
	    {
		System.out.println("Error: Negative Age.");
		System.exit(0);
	    }
	else
	    age = initialAge;
    }
    public Pet(double initialWeight)
    {
	name = "No name yet";
	age = 0;
	if (initialWeight == 0)
	    {
		System.out.println("Error: Negative Weight.");
		System.exit(0);
	    }
	else
	    weight = initialWeight;
    }
    public Pet()
    {
	name = "No name yet.";
	age = 0;
	weight = 0;
    }

    /* Getters and Setters */
    public int    getAge()    { return age;  }
    public String getName()   { return name; }
    public double getWeight() {	return weight; }
    public void set(String newName, int newAge, double newWeight)
    {
	name = newName;
	if ((newAge < 0) || (newWeight < 0))
	    {
		System.out.println("Error: Negative age or weight.");
		System.exit(0);
	    }
	else
	    {
		age = newAge;
		weight = newWeight;
	    }
    }
    public void setName(String newName)
    {
	name = newName;
    }
    public void setWeight(double newWeight)
    {
	if (newWeight < 0)
	    {
		System.out.println("Error: Negative weight");
		System.exit(0);
	    }
	else
	    weight = newWeight;
    }

    /* Functions */
    public String toString()
    {
	return ("Name: " + name + " Age: " + age + " years" + "\nWeight: " + weight + " pounds");
    }
    public double acepromazine() { return 0; }
    public double carprofen()    { return 0; } 
}

class Cat extends Pet
{
    public Cat(String initialName, int initialAge, double initialWeight)
    {
	super(initialName, initialAge, initialWeight);
    }
	
    public double acepromazine()
    {
	return ((this.getWeight() / 2.2) * (10 / .002));
    }
    public double carprofen()
    {
	return ((this.getWeight() / 2.2) * (12 / .25));
    }
}

class Dog extends Pet
{
    public Dog(String initialName, int initialAge, double initialWeight)
    {
	super(initialName, initialAge, initialWeight);
    }
    public double acepromazine()
    {
	return ((this.getWeight() / 2.2) * (10 / .03));
    }
    public double carprofen()
    {
	return ((this.getWeight() / 2.2) * (12 / .5));
    }
}

public class Ghp5_pt1
{
    public static void main(String[] args)
    {
	DecimalFormat f = new DecimalFormat("###.#");
	
        Cat catbert = new Cat("Catbert",3,7.0);
	Dog dogbert = new Dog("Dogbert",6,25.0);
	System.out.println(catbert.getName() + "'s Acepromazine dose: " + f.format(catbert.acepromazine()));
	System.out.println(catbert.getName() + "'s Carprofen dose: " + f.format(catbert.carprofen()));
	System.out.println(dogbert.getName() + "'s Acepromazine dose: " + f.format(dogbert.acepromazine()));
	System.out.println(dogbert.getName() + "'s Carprofen dose: " + f.format(dogbert.carprofen()));
    }
}
