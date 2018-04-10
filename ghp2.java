/*
  Written by Seth Sevier
  Takes 3 homework assignment names, scores, and total points
  Returns a table that displays those values and the total grade

  Formatting of the table will break if exercise names are too big or too small.
  However, it does work perfectly with the inputs given in the book's example.
*/

import java.util.Scanner;
import java.text.*;

class ghp2 {
    public static void main(String[] args) {
	double s1,s2,s3,t1,t2,t3 = 0;   // score and total point values
	double result = 0;           // final result
	String n1,n2,n3 = "";        // exercise names
	
	Scanner s = new Scanner(System.in);
	NumberFormat nf = new DecimalFormat("###.#");

	System.out.println("Name of exercise 1:");
	n1 = s.nextLine();
	System.out.println("Score received for exercise 1:");
	s1 = s.nextInt();
	System.out.println("Total points possible for exercise 1");
	t1 = s.nextInt();

	System.out.println("Name of exercise 2:");
	s.nextLine();
	n2 = s.nextLine();
	System.out.println("Score received for exercise 2:");
	s2 = s.nextInt();
	System.out.println("Total points possible for exercise 2");
	t2 = s.nextInt();

	System.out.println("Name of exercise 3:");
	s.nextLine();
	n3 = s.nextLine();
	System.out.println("Score received for exercise 3:");
	s3 = s.nextInt();
	System.out.println("Total points possible for exercise 3");
	t3 = s.nextInt();

	result = (((s1 + s2 + s3) / (t1 + t2 + t3)) * 100);
	
	System.out.println("Exercise\tScore\t\tTotal Possible");
	System.out.println(n1 + "\t" + s1 + "\t\t" + t1);
	System.out.println(n2 + "\t" + s2 + "\t\t" + t2);
	System.out.println(n3 + "\t" + s3 + "\t\t" + t3);
	System.out.println("Total\t\t" + (s1 + s2 + s3) + "\t\t" + (t1 + t2 + t3));
	System.out.println("\nYour total is " + (s1 + s2 + s3) + " out of " + (t1 + t2 + t3) + ", or " + nf.format(result) + "%\n");
	
    }
}
