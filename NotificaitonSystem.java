/*
  Seth Sevier
  CS 249
  Final Exam
  1) Java Application Programming - Notification System

  Create a notifier object:
  - Implements a tick counter object that increments a tick count by one when it recieves a tick message from the driver object.
  When a new object is created, it must tell the notifier object their wake up interval in # of ticks with Set Alarm.
  When an object recieves a Do Alarm message, it must perform an object-specific function.

  This program both compiles and works as intended.  However, it does not utilize a SetAlarm function.
  By far this is the most complicated version of FizzBuzz I have ever written!
 */


class Notifier
{
    private int tick;
    private int numberOfObjects;

    private Trackable[] alarms = new Trackable[numberOfObjects];

    public Notifier(Trackable[] a)
    {
	tick = 0;
	numberOfObjects = a.length;
	alarms = a;
    }

    public void incrementTick()
    {
	tick++;
	checkForTicks();
    }

    private void checkForTicks() /* Important after going outside! */
    {
	for (int i = 0; i < numberOfObjects; i++)
	    {
		if (tick % alarms[i].getWhenToCheck() == 0)
		    {
			alarms[i].DoAlarm();
		    }
	    }
    }
    
    public void SetAlarm(Trackable object)
    {
	
    }
}

abstract class Trackable
{
    private int when;
    public int getWhenToCheck()       { return when; }
    public void setWhenToCheck(int w) { when = w;    }
    abstract public void DoAlarm();
    public Trackable(int w)
    {
	setWhenToCheck(w);
    }
}

class Student extends Trackable
{
    private double xCoord = 45.104375;
    private double yCoord = 36.193857;

    public Student(int w)
    {
	super(w);
    }
    
    public void DoAlarm()
    {
	printGPSCoordinates();
    }
    public void printGPSCoordinates()
    {
	System.out.println("Student's Coordinates:");
	System.out.println(xCoord);
	System.out.println(yCoord);
	System.out.println();
    }
}

class BookStore extends Trackable
{
    private int booksSold = 24;

    public BookStore(int w)
    {
	super(w);
    }
    
    public void DoAlarm()
    {
	printBooksSold();
    }

    public void printBooksSold()
    {
	System.out.println("Number of books sold:");
	System.out.println(booksSold);
	System.out.println();
    }
}

class Faculty extends Trackable
{
    private int phoneCalls = 15;

    public Faculty(int w)
    {
	super(w);
    }
    
    public void DoAlarm()
    {
	printPhoneCalls();
    }

    public void printPhoneCalls()
    {
	System.out.println("Number of phone calls received by Faculty:");
	System.out.println(phoneCalls);
	System.out.println();
    }
}

public class NotificationSystem
{
    public static void main(String[] args)
    {
	int i = 3;
	Trackable[] t = new Trackable[i];
	t[0] = new Student(2);
	t[1] = new BookStore(3);
	t[2] = new Faculty(5);
	Notifier n = new Notifier(t);
	
	while (true)
	    {
		try {
		    Thread.sleep(1000);
		    n.incrementTick();
		} catch (Exception e) { System.out.println("Something broke..."); }
	    }
    }
}
