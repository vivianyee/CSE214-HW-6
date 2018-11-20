/**
 * 
 * The <code>ClosedAuctionException</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class ClosedAuctionException extends Exception {
	public ClosedAuctionException()
    {  //Default message
        super("Invalid element used as method parameter.");
    }

    public ClosedAuctionException(String message)
    {   //Passed message
        super(message);
    }	
}