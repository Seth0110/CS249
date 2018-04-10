/*
  Seth Sevier
  CS 249
  Homework 7
  V4_Problem_9_page_698

  "
  Use the sorting pattern to implement insertion sort.
  In insertion sort the split method always returns the value
  (end - 1).  This results in splitting the array into two pieces,
  one with a single value at the end, and the other with with everything
  else.  The join method does more work. A precondition for entry into
  join is that the elements from a[begin] to a[end] in sorted order.
  The method should insert a[end] into the correct spot from a[begin]
  to a[end] such that sorted order is maintained.  For example, if array
  a contains [2,4,6,8,5] where begin = 0 and end = 4 then a[end] = 5 and
  the method should insert the value 5 between 4 and 6 resulting in 
  [2,4,5,6,8].  This entails copying the 6 and the 8 one element to the
  right and then copying the value 5 to index 2.
  "

  This program takes an array of integers and applies the insertion sort
  algorithm to it.  Then it returns the unsorted and sorted arrays.
*/

public class Ghp7
{
    }
    public static int[] sort(int[] a)
    {
	int value, j;
	for (int i = 1; i < a.length; i++)
	    {
		value = a[i];
		j = i;
		while (j > 0 && a[j - 1] > value)
		    {
			a[j] = a[j - 1];
			j--;
		    }
		a[j] = value;
	    }
	return a;
    }
    public static void main(String[] args)
    {
	int[] pre = { 8, 7, 6, 5, 5, 4, 3, 2, 1 };
	int[] post = sort(pre);
	for (int i = 0; i < post.length; i++)
	    System.out.print(post[i]);
	System.out.println("");
    }
}
