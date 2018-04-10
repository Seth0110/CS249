/*
  Seth Sevier
  CS 249
  GHP3
  V4_Project_11_page_250
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

public class Ghp3
{
    public static void main(String[] args)
    {
	Pizza pizza1 = new Pizza(Size.LARGE,1,1,2);
	System.out.println("Cost of the test pizza is: $" + pizza1.calcCost());
    }
}
