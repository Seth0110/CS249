/*
  Seth Sevier
  CS249
  GHP 8
  
  "
  Define an interface named Shape with a single method named
  area that calculates the area of the shape.
  public double area();
  Next, define a class named Circle that implements Shape.
  The Circle class should have an instance variable for the radius,
  a constructor that sets the radius, accessor/mutator methods for
  the radius, and an implementation of the area method.  Also define
  a class named Rectangle that implements Shape.  The Rectangle
  class should have instance variables for the height and width,
  a constructor that sets the height and width, accessor mutator 
  methods for the height and width, and an implementation of the 
  area method.

  The following test code should then output the area of the Circle
  and Rectangle objects:
  public static void main(String[] args)
  {
    Circle c = new Circle(4);  // Radius of 4
    Rectangle r = new Rectangle(4,3); // Height = 4, Width = 3
    ShowArea(c);
    ShowArea(r);
  }
  "
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

public class Ghp8
{
    static void ShowArea(Shape s)
    {
	System.out.println("Area of Shape: " + s.area());
    }
    public static void main(String[] args)
    {
	Circle c = new Circle(4);
	Rectangle r = new Rectangle(4,3);
	ShowArea(c);
	ShowArea(r);
    }
}
