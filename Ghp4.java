/*
  Seth Sevier
  CS 249
  GHP4
  V4_Project_8_page_337
*/

enum Size
{
    SMALL, MEDIUM, LARGE;
};

class Pizza
{
    // Variables
    private Size size;
    private int cheese_toppings;
    private int pepperoni_toppings;
    private int ham_toppings;

    // Constructors
    public Pizza(Size s, int c, int p, int h)
    {
	size = s;
	cheese_toppings = c;
	pepperoni_toppings = p;
	ham_toppings = h;
    }
    public static Pizza copy(Pizza pizza)
    {
	if (pizza != null) { return new Pizza(pizza.size, pizza.cheese_toppings, pizza.pepperoni_toppings, pizza.ham_toppings); }
	else               { return null; }
    }

    // Getters & Setters
    public void setSize(Size s)     { size = s; }
    public void setCheese(int c)    { cheese_toppings = c; }
    public void setPepperoni(int p) { pepperoni_toppings = p; }
    public void setHam(int h)       { ham_toppings = h; }
    public Size getSize()           { return size; }
    public int  getCheese()         { return cheese_toppings; }
    public int  getPepperoni()      { return pepperoni_toppings; }
    public int  getHam()            { return ham_toppings; }

    // Functions
    private double toppingCost() { return 2 * (getCheese() + getPepperoni() + getHam()); }
    public double calcCost()
    {
	switch(size) {
	case SMALL:  return 10 + toppingCost();
	case MEDIUM: return 12 + toppingCost();
	case LARGE:  return 14 + toppingCost(); }
	return 0;
    }
}

class PizzaOrder
{
    // Variables
    private int numPizzas;
    private Pizza[] pizzaAry = new Pizza[numPizzas];

    // Constructors
    public PizzaOrder(PizzaOrder o)
    {
	numPizzas = o.getNumPizzas();
	pizzaAry = new Pizza[o.getPizzas().length];
	for(int i = 0;i < pizzaAry.length;i++)
	    pizzaAry[i] = Pizza.copy(o.getPizzas()[i]);
    }
    public PizzaOrder(Pizza ... pizzas)
    {
	numPizzas = pizzas.length;
	pizzaAry = pizzas;
    }
    public static PizzaOrder copy(PizzaOrder po)
    {
	if (po != null) { return new PizzaOrder(po); }
        else { return null; }
    }

    // Getters & Setters
    public void setNumPizzas(int numPizzas)  { numPizzas = numPizzas; }
    public int getNumPizzas()                { return numPizzas; }
    public void setPizza(Pizza pizza, int n) { pizzaAry[n] = pizza; }
    public Pizza getPizza(int n)             { return pizzaAry[n]; }
    public Pizza[] getPizzas()               { return pizzaAry; }

    // Functions
    public double calcTotal(int n)
    {
	double total = 0;
	for (int i = 0;i < n;i++)
	    total += pizzaAry[i].calcCost();
	return total;
    }
}

public class Ghp4
{
    public static void main(String[] args)
    {
	Pizza pizza1 = new Pizza(Size.LARGE,1,0,1);
	Pizza pizza2 = new Pizza(Size.MEDIUM,2,2,0);
	PizzaOrder order = new PizzaOrder(pizza1,pizza2);
	PizzaOrder order2 = new PizzaOrder(order);

	order2.getPizza(0).setCheese(3);
	
	double total = order2.calcTotal(order2.getNumPizzas());
	double origTotal = order.calcTotal(order.getNumPizzas());

	System.out.println(total);
	System.out.println(origTotal);
    }
}
