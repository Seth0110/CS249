/* 
   Store sells cameras, lenses, and media
   Each sells different brands

   Needs to support sales, inventory restock, and where shipments are recieved.

   Some cool features I'd implement if I had more time:
   - Actually finish everything so it works
   - Format the doubles in the reports
   - Serialize the classes so I can create an inventory file
   - Better inventory search functions
   - Create enums of the brands/types/etc for better tracking
   - Revenue tracking
 */

abstract class Item
{
    /* Provides the basic framework for an inventory item */

    /* Variables */
    private String name;
    private String brand;
    private double price;    // In dollars

    /* Constructors */
    public Item()
    {
	name = null;
	brand = null;
	price = 0;
    }
    public Item(String n, String b, double p)
    {
	name = n;
	brand = b;
	price = p;
    }

    /* Getters & Setters */
    public String getBrand() { return brand; }
    public String getName()  { return name; }
    public double getPrice() { return price; }
    public void setBrand(String b) { brand = b; }
    public void setName(String n)  { name = n;  }
    public void setPrice(double p) { price = p; }
}

class Camera extends Item
{
    /* Sadly I don't know much about cameras,
       so without Google I cannot give realistic specs for cameras
       However I do know that cameras have lenses! */

    private Lens l;
    
    /* Constructors */
    public Camera()
    {
	super();
    }
    public Camera(double f, String t, String n, String b, double p)
    {
	super(n,b,p);
	l = new Lens(f,t,n,b,p);
    }
    public Camera(Lens l, String n, String b, double p)
    {
	l = new Lens(l);
    }
}

class Lens extends Item
{
    /* Variables */
    private double focus;       // in mm
    private String type;        // So far either dx or vr

    /* Constructors */
    public Lens()
    {
	super();
	focus = 0;
	type = null;
    }
    public Lens(double f, String t, String n, String b, double p)
    {
	super(n,b,p);
	focus = f;
	type = t;
    }
    public Lens(Lens l)
    {
	/* My copy constructor is all screwed up but I'd rather get more work done elsewhere right now */
	return new Lens(l.getFocus, l.getType, l.getName(), l.getBrand, l.getPrice);
    }

    /* Getters & Setters */
    public void setFocus() {}
    public void setType()  {}
    public double getFocus(){ return focus; }
    public String getType() { return type; }
}

class Media extends Item
{
    /* Variables */
    private String type;        // Film, flash, USB, etc
    private double capacity;    // In Gigabytes
}

class Inventory
{
    /* Variables */
    private Camera[] cameraInv;
    private Lens[] lensInv;
    private Media[] mediaInv;

    /* Constructors */
    public Inventory()
    {}

    /* Methods */
    /* Helper function for sale */
    public boolean remCamera(Camera c)
    {
	for (int i = 0; i < cameraInv.length(); i++)
	    {
		if (cameraInv[i] == c[i]) // This comparison doesn't work right
		    {
			/* Ran out of time! */
		    }
	    }
    }
    /* Removes stock entries */
    public void sale(Camera ... cameras)
    {
	for (int i = 0; i < cameras.length(); i++)
	    {
		remCamera(cameras[i]);
	    }
    }
    /* Adds an entry */
    public void shipment()
    {}
    /* Returns info about an item
       Kind of like a getter for the inventory arrays*/
    public void reportCameras()
    {
	System.out.println("There are " + cameraInv.length() + " cameras in stock.");
	System.out.println("The cameras currently in stock are:");
	for (int i = 0; i < cameraInv.length(); i++)
	    {
		System.out.println("Camera: " + cameraInv[i].getBrand() + " " +cameraInv[i].getName());
		System.out.println("For only $" + cameraInv[i].getPrice() + "!!");
	    }
    }
    public void reportLenses()
    {
	System.out.println("There are " + lensInv.length() + " lenses in stock.");
	System.out.println("The lenses currently in stock are:");
	for (int i = 0; i < lensInv.length(); i++)
	    {
		System.out.println("Lens: " + lensInv[i].getBrand() + " " +lensInv[i].getName());
		System.out.println("For only $" + lensInv[i].getPrice() + "!!");
	    }
    }
    public void reportMedia()
    {
	System.out.println("There are " + mediaInv.length() + " media devices in stock.");
	System.out.println("The media currently in stock is:");
	for (int i = 0; i < mediaInv.length(); i++)
	    {
		System.out.println("Media Device: " + mediaInv[i].getBrand() + " " +mediaInv[i].getName());
		System.out.println("For only $" + mediaInv[i].getPrice() + "!!");
	    }
    }
}

public class photographyShop
{
    public static void main(String[] args)
    {
	/* Driver program goes here
	   However there is no point to a driver program
	   If the program it drives doesn't work yet...*/
	Inventory inv = new Inventory();
	inv.reportCameras();
	inv.reportLenses();
	inv.reportMedia();
    }
}
