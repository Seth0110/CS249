/*
  Seth Sevier
  CS249
  GHP 8 part 2
  
  Adds a right triangle class to Ghp8
*/

import java.lang.Math.*;

interface Shape
{
    public double area();
}

class Circle implements Shape
{
    private double radius;

    public Circle(double r)
    {
	if(r > 0)
	    radius = r;
	else
	    {
		System.out.println("Unable to create Circle with that radius, setting radius to 0 instead");
		radius = 0;
	    }
    }

    public void setRadius(double r)
    {
	if(r <= 0)
	    System.out.println("It is not possible to have a circle with a radius of " + r);
	else
	    radius = r;
    }
    public double getRadius() { return radius;   }
    public double area()
    {
	return (Math.PI * Math.pow(radius, 2));
    }
}

class Rectangle implements Shape
{
    private double length;
    private double width;

    public Rectangle(double l,double w)
    {
	if ((l > 0) && (w > 0))
	    {
		length = l;
		width = w;
	    }
	else
	    {
		System.out.println("Unable to create Rectangle with those values, setting both to 0 instead.");
		length = 0;
		width = 0;
	    }
    }

    public void setLength(double l)
    {
	if (l > 0)
	    length = l;
	else
	    System.out.println("Unable to set length to " + l);
    }
    public void setWidth(double w)
    {
	if (w > 0)
	    width = w;
	else
	    System.out.println("Unable to set width to " + w);
    }
    public double getLength() { return length; }
    public double getWidth()  { return width;  }

    public double area()
    {
	return (length * width);
    }
}

class Triangle implements Shape
{
    private double base;
    private double height;

    public Triangle(double b, double h)
    {
	if ((b > 0) && (h > 0))
	    {
		base = b;
		height = h;
	    }
	else
	    System.out.println("Unable to create Triangle with those values, setting both to 0 instead.");	    
    }
    
    public void setBase(double b)
    {
	if (b > 0)
	    base = b;
	else
	    System.out.println("Cannot set base to that value.");
    }
    public void setHeight(double h)
    {
	if (h > 0)
	    height = h;
	else
	    System.out.println("Cannot set height to that value.");
    }
    public double getBase()   { return base;       }
    public double getHeight() { return height;     }
    public String getName()   { return "Triangle"; }

    public double area()
    {
	return (.5 * base * height);
    }
}

public class Ghp8pt2
{
    static void ShowArea(Shape s)
    {
	System.out.println("Area of Shape: " + s.area());
    }
    public static void main(String[] args)
    {
	Circle c = new Circle(4);
	Rectangle r = new Rectangle(4,3);
	Triangle t = new Triangle(3,4);
	ShowArea(c);
	ShowArea(r);
	ShowArea(t);
    }
}
