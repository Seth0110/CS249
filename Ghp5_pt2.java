/*
  Seth Sevier
  CS 249
  V4_Project_8_page_511
    Rewrite the solution using inheritance.
    Define Pet as an abstract class, and its 2 methods as abstract methods
    In main() create an array with 2 dogs and 2 cats
    Iterate through it and output both dosages for all
*/

import java.text.DecimalFormat;

abstract class Pet
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
    public abstract double acepromazine();
    public abstract double carprofen();
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

public class Ghp5_pt2
{
    public static void main(String[] args)
    {
	DecimalFormat f = new DecimalFormat("###.#");
	
	Pet[] pets = new Pet[4];
	pets[0] = new Dog("Dogbert",6,25.0);
	pets[1] = new Dog("Gromit",8,30.0);
	pets[2] = new Cat("Catbert",3,7.0);
	pets[3] = new Cat("Garfield",4,20.0);

	for (int i = 0;i < 4;i++)
	    {
		System.out.println(pets[i].getName() + "'s Acepromazine dose: " + f.format(pets[i].acepromazine()));
		System.out.println(pets[i].getName() + "'s Carprofen dose: " + f.format(pets[i].carprofen()));
	    }
    }
}
