import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import big.data.DataSource;

/**
 * 
 * The <code>AuctionTable</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class AuctionTable extends Hashtable<String,Auction> implements Serializable{
	static AuctionTable table = new AuctionTable();
	static String[] auctionID;

	public static AuctionTable buildFromURL(String URL) throws IllegalArgumentException{
		DataSource ds = DataSource.connect(URL).load();
		if(ds == null) {
			throw new IllegalArgumentException("wtf");
		}else {
			String[] sellerName = ds.fetchStringArray("listing/seller_info/seller_name");
			double[] currentBid = ds.fetchDoubleArray("listing/auction_info/current_bid");
			int[] timeLeft = ds.fetchIntArray("listing/auction_info/time_left");
			auctionID = ds.fetchStringArray("listing/auction_info/id_num");
			String[] buyerName = ds.fetchStringArray("listing/auction_info/high_bidder/bidder_name");
			String[] info = ds.fetchStringArray("listing/item_info/memory");
			String[] info1 = ds.fetchStringArray("listing/item_info/hard_drive");
			String[] info2 = ds.fetchStringArray("listing/item_info/cpu");
			String[] infoItem = null;
			for(int i = 0;i < info.length; i++) {
				infoItem[i] = info[i] + info1[i] + info2[i];
			}
			for(int i = 0;i < sellerName.length; i++) {
				table.put(auctionID[i],new Auction(timeLeft[i],currentBid[i],auctionID[i],sellerName[i],buyerName[i],infoItem[i]));
			}
			System.out.println("Loading...\r\n" + 
					"Auction data loaded successfully!");
			return table;
		}
	}
	
	public void putAuction(String auctionID, Auction auction) throws IllegalArugmentException{
		
	}
	
	public Auction getAuction(String auctionID) {
		
	}
	
	public void letTimePass(int numHours) throws IllegalArgumentException{
		
	}
	
	public void removeExpiredAuctions() {
		
	}
	
	public void printTable() {
		System.out.println(" Auction ID |      Bid   |        Seller         |          Buyer          |"+
				"    Time   |  Item Info // truncated to fit on one line\r\n" + 
				"========================================================================================"+
				"===========================================");
		for(int i = 0; i < auctionID.length;i++) {
			Auction x = table.get(auctionID[i]);
			System.out.printf("%-10s %-10s %-10s %10s %n",x.getAuctionID(),x.getCurrentBid(),x.getSellerName(),x.getBuyerName(),x.getTimeRemaining(),x.getItemInfo());
		}
	}
}
