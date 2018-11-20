import java.io.Serializable;

/**
 * 
 * The <code>Auction</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class Auction implements Serializable{
	private int timeRemaining;
	private double currentBid;
	private String auctionID;
	private String sellerName;
	private String buyerName;
	private String itemInfo;
	
	public Auction(int timeRemaining,double currentBid,String auctionID,String sellerName,String buyerName,String itemInfo) {
		this.timeRemaining = timeRemaining;
		this.currentBid = currentBid;
		this.auctionID = auctionID;
		this.sellerName = sellerName;
		this.buyerName = buyerName;
		this.itemInfo = itemInfo;
	}
	
	public void decrementTimeRemaining(int time) {
		
	}
	
	public void newBid(String bidderName, double bidAmt) throws ClosedAuctionException{
		if(timeRemaining == 0) {
			throw new ClosedAuctionException("Auction " + bidderName + "is CLOSED" +
					"\n   Current Bid: $" + getCurrentBid()+ "\n" +
					"You can no longer bid on this item.");
		}
		
	}
	
	public String toString() {
		
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public double getCurrentBid() {
		return currentBid;
	}

	public String getAuctionID() {
		return auctionID;
	}

	public String getSellerName() {
		return sellerName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public String getItemInfo() {
		return itemInfo;
	}
	
}
