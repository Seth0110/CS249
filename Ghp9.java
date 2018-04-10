/*
  Seth Sevier
  CS 249
  GHP 9
  
  V4_Problem_4_page_788

  "
  Write a generic class, MyMathClass, with a type parameter T where T is
  a numeric object type.  Add a method named standardDeviation that takes an
  ArrayList of type T and returns as a double the standard deviation of the val
  ues in ArrayList.  Use the doubleValue() method in the Number class to
  retrieve the value of of each number as a double.  Refer to Programming Project
  6.2 for the definition of computing standard deviation.  Test your method
  with suitable data.  Your program should generate a compile-time error if your
  standard deviation method is invoked on an ArrayList that is defined for
  non-numeric elements (e.g., Strings).
  "
*/

import java.lang.Math;

class MyMathClass<T>
{
    private T t;

    public MyMathClass()
    {}
    
    public void sett(T t){ this.t = t; }
    public T gett(){ return t; }

    public double sum(double[] n)
    {
	double total = 0;
	for (int i = 0; i < n.length; i++)
	    total = total + n[i];
	return total;
    }
    public double standardDeviation(T[] numbers)
    {
	double[] convertedNumbers = new double[numbers.length];
	for (int i = 0; i < numbers.length; i++)
		convertedNumbers[i] = (Double) numbers[i];
	double mean = (sum(convertedNumbers) / numbers.length);
	double[] squareDiff = new double[convertedNumbers.length];
	for (int i = 0; i < numbers.length; i++)
		squareDiff[i] = Math.pow((convertedNumbers[i] - mean),2);
	double variance = (sum(squareDiff) / (numbers.length - 1));
	return Math.sqrt(variance);
    }
}

public class Ghp9
{
    public static void main(String[] args)
    {
	MyMathClass<Double> m = new MyMathClass();
	Double[] test = new Double[5];
	test[0] = 5d;
	test[1] = 5d;
	test[2] = 6d;
	test[3] = 5d;
	test[4] = 8d;
	double result = m.standardDeviation(test);
	System.out.println("Standard Deviation: " + result);
    }
}
