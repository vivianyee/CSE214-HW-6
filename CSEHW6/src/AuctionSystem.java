import java.io.Serializable;
import java.util.Scanner;
import big.data.DataSource;

/**
 * 
 * The <code>AuctionSystem</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class AuctionSystem implements Serializable{
	private static AuctionTable auctionTable;
	private static String username;
	
	public static void main(String[] args) throws IllegalArugmentException, ClosedAuctionException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select a username: ");
		username = scan.nextLine();
		System.out.println("(D) - Import Data from URL\r\n" + 
				"(A) - Create a New Auction\r\n" + 
				"(B) - Bid on an Item\r\n" + 
				"(I) - Get Info on Auction\r\n" + 
				"(P) - Print All Auctions\r\n" + 
				"(R) - Remove Expired Auctions\r\n" + 
				"(T) - Let Time Pass\r\n" + 
				"(Q) - Quit");
		String x = scan.nextLine();
		if(x.equalsIgnoreCase("d")) { // Import Data from URL
			System.out.println("Please enter a URL: ");
			String y = scan.nextLine();
		}
			//importData(y);
//		}else if(x.equalsIgnoreCase("a")) { // Create a New Auction
//			createAuction();
//		}else if(x.equalsIgnoreCase("b")) { // Bid on an Item
//			bidItem();
//		}else if(x.equalsIgnoreCase("i")) { // Get Info on Auction
//			infoAuction();
//		}else if(x.equalsIgnoreCase("p")) { // Print All Auctions
//			printAuctions();
//		}else if(x.equalsIgnoreCase("r")) { // Remove Expired Auctions
//			removeExpired();
//		}else if(x.equalsIgnoreCase("t")) { // Let Time Pass
//			timePass();
//		}else if(x.equalsIgnoreCase("q")) { // Quit
//			System.out.println("Writing Auction Table to file...\r\n" + 
//					"Done!");
//			System.exit(0);
//		}
	}
	
	public static void importData(String x) { // Import Data from URL - D
		try {
			auctionTable = AuctionTable.buildFromURL(x);
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	public static void createAuction() throws IllegalArugmentException { // Create a New Auction - A
		Scanner scan = new Scanner(System.in);
		Auction auc = new Auction();
		System.out.println("Creating new Auction as student@stonybrook.edu.");
		System.out.println("Please enter an Auction ID: ");
		String ID = scan.nextLine();
		System.out.println("Please enter an Auction time (hours): ");
		int aTime = scan.nextInt();
		System.out.println("Please enter some Item Info: ");
		String info = scan.nextLine();
		try {
			auctionTable.putAuction(ID, auc);
		}catch(IllegalArgumentException e) {
			System.out.print(e);
		}
	}
	
	public static void bidItem() throws ClosedAuctionException { // Bid on an Item - B
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an Auction ID: ");
		String ID = scan.nextLine();
		try {
			Auction auc = auctionTable.getAuction(ID);
			System.out.println("\nAuction "+auc.getAuctionID() + " is OPEN" +
					"\n   Current Bid: $" + auc.getCurrentBid() + "\n" + 
					"What would you like to bid?: ");
			double bid = scan.nextDouble();
			auc.newBid(ID, bid);
			System.out.println("Bid accepted.");
		}catch(ClosedAuctionException e) {
			System.out.println(e);
		}
	}
	
	public static void infoAuction() { // Get Info on Auction - I
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an Auction ID: ");
		String auc = scan.nextLine();
		Auction bam = auctionTable.getAuction(auc);
		System.out.println("Auction " + auc +
				"\n   Seller: " + bam.getSellerName() +
				"\n   Buyer: " + bam.getBuyerName() +
				"\n   Time: " + bam.getTimeRemaining() +
				"\n   Info: " + bam.getItemInfo());
	}
	
	public static void printAuctions() { // Print All Auctions - P
		auctionTable.printTable();
	}
	
	public static void removeExpired() { // Remove Expired Auctions - R
		auctionTable.removeExpiredAuctions();
		System.out.println("Removing expired auctions...\r\n" + 
				"All expired auctions removed.");
	}
	
	public static void timePass() { // Let Time Pass - T
		Scanner scan = new Scanner(System.in);
		System.out.println("How many hours should pass: ");
		int hours = scan.nextInt();
		auctionTable.letTimePass(hours);
		System.out.println("\nTime passing...\r\n" + 
				"Auction times updated.");
	}
}
