/*
  Seth Sevier
  CS 249
  GHP3
  V4_Project_12_page_250
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
    Pizza pizza1 = new Pizza(Size.MEDIUM,0,0,0);
    Pizza pizza2 = new Pizza(Size.MEDIUM,0,0,0);
    Pizza pizza3 = new Pizza(Size.MEDIUM,0,0,0);
    
    public void PizzaOrder()
    {
	Pizza pizza1 = new Pizza(Size.MEDIUM,0,0,0);
	Pizza pizza2 = new Pizza(Size.MEDIUM,0,0,0);
	Pizza pizza3 = new Pizza(Size.MEDIUM,0,0,0);
    }
    public void setNumPizzas(int numPizzas) { this.numPizzas = numPizzas; }
    public void setPizza1(Pizza pizza1)
    {
	this.pizza1.setSize(pizza1.getSize());
	this.pizza1.setCheese(pizza1.getCheese());
	this.pizza1.setPepperoni(pizza1.getPepperoni());
	this.pizza1.setHam(pizza1.getHam());
    }
    public void setPizza2(Pizza pizza2)
    {
	this.pizza2.setSize(pizza2.getSize());
	this.pizza2.setCheese(pizza2.getCheese());
	this.pizza2.setPepperoni(pizza2.getPepperoni());
	this.pizza2.setHam(pizza2.getHam());
    }
    public void setPizza3(Pizza pizza3)
    {
	this.pizza3.setSize(pizza3.getSize());
	this.pizza3.setCheese(pizza3.getCheese());
	this.pizza3.setPepperoni(pizza3.getPepperoni());
	this.pizza3.setHam(pizza3.getHam());
    }
    public double calcTotal()
    {
	switch(numPizzas){
	case 1: return pizza1.calcCost();
	case 2: return pizza1.calcCost() + pizza2.calcCost();
	case 3: return pizza1.calcCost() + pizza2.calcCost() + pizza3.calcCost(); }
	return 0;
    }
}

public class Ghp3_pt2
{
    public static void main(String[] args)
    {
	Pizza pizza1 = new Pizza(Size.LARGE,1,0,1);
	Pizza pizza2 = new Pizza(Size.MEDIUM,2,2,0);
	/* All of the following code is unnecessary
	 * pizza1.calcCost() + pizza2.calcCost()
	 * would do the exact same thing without needing an order object!
	 */
	PizzaOrder order = new PizzaOrder();
	order.setNumPizzas(2);
	order.setPizza1(pizza1);
	order.setPizza2(pizza2);
	double total = order.calcTotal();

	System.out.println("Order total is: $" + total);
    }
}
