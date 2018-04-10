/*
  Seth Sevier
  CS 249
  GHP3
  V4_Project_8_page_337
*/

enum Size
{
    SMALL, MEDIUM, LARGE;
};

class Pizza
{
    private Size size;
    private int cheese_toppings;
    private int pepperoni_toppings;
    private int ham_toppings;

    public Pizza(Size s, int c, int p, int h)
    {
	size = s;
	cheese_toppings = c;
	pepperoni_toppings = p;
	ham_toppings = h;
    }
    public static Pizza copy(Pizza pizza) {
	if(pizza != null){
	    return new Pizza(pizza.size, pizza.cheese_toppings, pizza.pepperoni_toppings, pizza.ham_toppings);
	}
	else{ return null; }
    }
    
    public void setSize(Size s)     { size = s; }
    public void setCheese(int c)    { cheese_toppings = c; }
    public void setPepperoni(int p) { pepperoni_toppings = p; }
    public void setHam(int h)       { ham_toppings = h; }
    public Size getSize()           { return size; }
    public int  getCheese()         { return cheese_toppings; }
    public int  getPepperoni()      { return pepperoni_toppings; }
    public int  getHam()            { return ham_toppings; }

    private double toppingCost() {
	return 2 * (getCheese() + getPepperoni() + getHam()); }
    
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
    int numPizzas;
    Pizza pizza1 = new Pizza(Size.LARGE,0,0,0);
    Pizza pizza2 = new Pizza(Size.LARGE,0,0,0);
    Pizza pizza3 = new Pizza(Size.LARGE,0,0,0);
    
    public PizzaOrder() {}
    public PizzaOrder(PizzaOrder o)
    {
	numPizzas = o.getNumPizzas();
	this.pizza1 = Pizza.copy(o.getPizza1());
        this.pizza2 = Pizza.copy(o.getPizza2());
	this.pizza3 = Pizza.copy(o.getPizza3());
    }
    public void setNumPizzas(int numPizzas) { this.numPizzas = numPizzas; }
    public int getNumPizzas() { return numPizzas; }
    public void setPizza1(Pizza pizza1) {
	this.pizza1 = pizza1; }
    public void setPizza2(Pizza pizza2) {
	this.pizza2 = pizza2; }
    public void setPizza3(Pizza pizza3) { 
	this.pizza3 = pizza3; }
    public Pizza getPizza1() {
	if (numPizzas >= 1) { return pizza1; }
	else { return null; } }
    public Pizza getPizza2() {
	if (numPizzas >= 2) { return pizza2; }
	else { return null; } }
    public Pizza getPizza3() {
	if (numPizzas >= 3) { return pizza3; }
	else { return null; } }
    public double calcTotal()
    {
	switch(numPizzas){
	case 1: return pizza1.calcCost();
	case 2: return pizza1.calcCost() + pizza2.calcCost();
	case 3: return pizza1.calcCost() + pizza2.calcCost() + pizza3.calcCost(); }
	return 0;
    }
}

public class Ghp3_pt3
{
    public static void main(String[] args)
    {
	Pizza pizza1 = new Pizza(Size.LARGE,1,0,1);
	Pizza pizza2 = new Pizza(Size.MEDIUM,2,2,0);
	PizzaOrder order = new PizzaOrder();
	order.setNumPizzas(2);
	order.setPizza1(pizza1);
	order.setPizza2(pizza2);
	PizzaOrder order2 = new PizzaOrder(order);

	order2.pizza1.setCheese(3);
	
	double total = order2.calcTotal();
	double origTotal = order.calcTotal();

	System.out.println(total);
	System.out.println(origTotal);
    }
}
