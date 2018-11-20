/**
 * 
 * The <code>IllegalArgumentException</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class IllegalArugmentException extends Exception {
	public IllegalArugmentException()
    {  //Default message
        super("Invalid element used as method parameter.");
    }

    public IllegalArugmentException(String message)
    {   //Passed message
        super(message);
    }	
}