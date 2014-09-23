package exercise_1;

/* 
 * Computer Modelling, Exercise 1: 
 * 
 * Simple example class to show how to print a function for
 * plotting using xmgrace.
 *
 * A. Hermann, ICMCS, August 2014
 *
 * (Originally A. R. Turner, EPCC, August 2012)
 */

// The IO package is needed to write files
import java.io.*;

public class CosinePlotter {

    /* 
     * This is the main method where all programs begin in Java
     *
     * If we are writing files we need to let this method throw
     * IOException errors.
     */
    static public void main (String [] argv) throws IOException {

     // This number controls how many points we plot
     int nLoop = 100;

     // Open an output file called "cosine.dat"
     String outFile = "cosine.dat";
     PrintWriter output = new PrintWriter(new FileWriter(outFile));

     // Loop over the points computing the value of our function and
     // printing them out.
     for (int i=0; i<nLoop; i++) {

          /* 
           * Here we turn the integer loop counter into 
           * a double precision coordinate by using an expression
           * that maps [0,..,Nloop-1] to [-PI,PI]
          */
          double x = Math.PI * 2.0 * i/nLoop - Math.PI;

          // Calculate the value of the function, f(x)
          double f = Function(x);

          // Print x and f(x) to the file
          output.printf("%10.5f %10.5f\n", x, f);
	 }

     // Close the output file
     output.close();

    }

    // This static method does the real work and evaluates our function
    static double Function(double x) {
    // Call the maths library to evaluate cosine for us
    return Math.cos(x);
    }
}

