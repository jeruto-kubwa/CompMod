package exercise_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HarmonicPlotter {

    /* 
     * This is the main method where all programs begin in Java
     *
     * If we are writing files we need to let this method throw
     * IOException errors.
     */
    static public void main (String [] args) throws IOException {

     // This number controls how many points we plot
     int nLoop = 100;

     // Open an output file specified by a command line argument.
     String outFile = args[0];
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
          double f = SquareWaveFourierSeries(x);

          // Print x and f(x) to the file
          output.printf("%10.5f\t%10.5f\n", x, f);
	 }

     // Close the output file
     output.close();

    }

    // This static method does the real work and evaluates our function
    static double SquareWaveFourierSeries(double x) {
    // Call the maths library to evaluate the lowest terms in the Fourier series for a square wave.
    return (Math.sin(x) + Math.sin(3.0*x)/3.0 + Math.sin(5.0*x)/5.0 + Math.sin(7.0*x)/7.0);
    }
}