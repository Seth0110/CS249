/*
  Seth Sevier
  CS 249
  GHP 10

  V4_Project_8_page_931

  "
  You have collected a file of movie ratings where each movie is rated from 1 (bad)
  to 5 (excellent).  The first line of the file is a number that identifies how many
  ratings are in the file.  Each rating then consists of two lines: the name of the
  movie followed by the numeric rating from 1 to 5.  Here is a sample rating file
  with four unique movies and seven ratings.

  7
  Harry Potter and the Half-Blood Prince
  4
  Harry Potter and the Half-Blood Prince
  5
  Army of the Dead
  1
  Harry Potter and the Half-Blood Prince
  4
  Army of the Dead
  2
  The Uninvited
  4
  Pandorium
  3

  Write a program that reads a file in this format, calculates the average rating for
  each movie, and outputs the average along with the number of reviews.  Here is
  the desired output for the sample data:

  Harry Potter and the Half-Blood Prince: 3 reviews, average of 4.3/5
  Army of the Dead: 2 reviews, average of 1.5 / 5
  The Uninvited: 1 review, average of 4 / 5
  Pandorium: 1 review, average of 3 / 5
  "
 */

import java.io.File;
import java.util.HashSet; 
import java.util.Scanner;

class Movie
{
    public String name;
    public int rating;

    public Movie(String n,int r)
    {
	name = n;
	rating = r;
    }
}

class Ghp10
{
    public static void main(String[] args)
    {
	try {
	    File f = new File("movies.dat");
	    Scanner i = new Scanner(f);
	    int numberOfEntries = Integer.parseInt(i.nextLine());
	    String name;
	    int rating;
	    Movie[] movieList = new Movie[numberOfEntries];
	    HashSet<String> movieIndex = new HashSet<String>();
	    for (int j = 0; j < numberOfEntries; j++)
		{
		    name = i.nextLine();
		    rating = Integer.parseInt(i.nextLine());
		    movieList[j] = new Movie(name,rating);
		    movieIndex.add(name);
		}
	    int rSum;
	    int count;
	    for (String s : movieIndex)
		{
		    rSum = 0;
		    count = 0;
		    for (int k = 0; k < numberOfEntries; k++)
			{
			    if (movieList[k].name.equals(s))
				{
				    rSum = rSum + movieList[k].rating;
				    count++;
				}
			}
		    System.out.println("Movie: " + s);
		    System.out.println("Average rating: " + rSum / (float) count);
		}
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
