/**
 * 
 */
package lzp;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

/** This program is an AirBnb reservation page, it takes the input from the user for what they are specifically looking for in a short term rental. The type, location, rating, etc. This program will take their input and give them their options and a receipt when they are ready to book.  
 * @author Lucas Paul
 */
public class AirBnbListing {
// initiating instance variables 
public int totalListings = 0;
private double CLEANING_FEE = 30.00;
private double SERVICE_FEE = 13.84;
private double TAX_RATE = 0.14;
private String lCode;
private String location;
private String lName;
private String lType;
private int minNight;
private String wName;
private String wPassword;
private String cCode;
private double pricePerNight;
private double avgRating;

//creating variables for imported utilities for the program
static Random rand = new Random();
static Scanner scan = new Scanner(System.in);
static DecimalFormat df = new DecimalFormat("#.##");


/** Method that initializes wName, wPassword, and totalListings
 * @param AirBnbnListing
 * Return- None
 */
	public AirBnbListing()
{
	wName = "Guest";
	wPassword = "BeMyGuest23";
	totalListings++ ;
	
}

	/** Method that initializes lName, location, lType, pricePerNight
	 * @param AirBnbListing
	 * Return- lName, location, lType, pricePerNight
	 */ 
public AirBnbListing (String lName, String location, String lType, double pricePerNight)
{
	this();
	this.lName = lName;
	this.location = location;
	this.lType = lType;
	this.pricePerNight = pricePerNight;
	this.avgRating = 1 + (new Random().nextDouble() * 4);
	calcMinimumNights();
	generateListingCode();
}

/** Method that calculates the minimum nights depending on the type of listing
 * @param calcMinimumNights
 * Return- None
 */
private void calcMinimumNights()
{
	switch (lType) {
    case "Studio":
        minNight = 1;
        break;
    case "Entire Apartment":
        minNight = 3;
        break;
    case "Private room":
        minNight = 1;
        break;
    case "Town House":
        minNight = 7;
        break;
}
}

/** Method that generates the listing code
 * @param generateListingCode
 * Return- None
 */
private void generateListingCode()
{
	char char1 = this.lName.charAt(0);
	char char2 = this.location.charAt(this.location.lastIndexOf(",")+2);
	char char3 = this.lType.charAt(0);
	lCode = ("" + char1 + char2 + char3 + this.totalListings);
}

/** Method that generates a confirmation code
 * @param generateConfirmationCode
 * Retrun- None
 */
private void generateConfirmationCode()
{
	int randomNum = rand.nextInt(9000)+ 1000;
	char char1 = this.lName.charAt(0);
	char char2 = this.location.charAt(this.location.lastIndexOf(",")+2);
	char char3 = this.lType.charAt(0);
	cCode = ("" + char1 + char2 + char3) + randomNum;
}

/** Method that created the format for the TestAirBnbListing class
 * @param toString
 * Return- None
 */
public String toString()
{
		generateConfirmationCode();
		String toString = ("Code" + "      Listing Name    " + "     City " + "                    Type " + "           Rating ");
		String toStringInformation = (cCode + "   " + lName + "    " + location + "   " + lType + "  " + df.format(this.avgRating) + " Stars");
		String returntoStringInformation = (toString + "\n" + toStringInformation);
		return returntoStringInformation;
}

/** Method that calculates the total price for the reservation
 * @param calcTotalPrice
 * Return- calcTotalPrice
 */ 
private double calcTotalPrice(double calcTotalPrice)
{
	
	double result = (pricePerNight * minNight) + CLEANING_FEE + SERVICE_FEE + (pricePerNight * minNight * TAX_RATE);;
	return result;
}

/** Method that creates a format when the user books a reservation
 * @param bookListing
 * Return- numNights
 */ 
public void bookListing(int numNights) {
    if (numNights < minNight) {
        System.out.println("Sorry, we require a minimum of " + minNight + " nights for this listing.");
    } else {
        generateConfirmationCode();
        double totalPrice = calcTotalPrice(numNights);
        System.out.println("Summary of your trip:");
        System.out.println("Your Wifi username: " + wName + ", password: " + wPassword);
        System.out.println("Address: " + location);
        System.out.println("Check-in: after 3:00pm");
        System.out.println("Check-out: by 10:00am");
        System.out.println("Total (USD)" + " $" + totalPrice);
        System.out.println(" ");
        System.out.print("Do you want a copy of your receipt (y/n)? ");
        char choice = scan.next().charAt(0);
        if (Character.toLowerCase(choice) == 'y') {
            displayReceipt();
        }
    }
}
/** Method that displays their receipt of their booking
 * @param displayReceipt
 * Return- None
 */
	private void displayReceipt(){
		String priceBreak = "Price Breakdown: ";
		String nightFee;
		
		if (minNight == 1)
		{
			nightFee = pricePerNight + " X " + minNight + " night" + "  $" + (minNight * pricePerNight);
		}
		else 
		{
			nightFee = pricePerNight + " X " + minNight + " nights" + "  $" + (minNight * pricePerNight);
		}
		
		String cleaning = "Cleaning fee  " + "$" + CLEANING_FEE;
		String service = "Service fee  " + "$" + SERVICE_FEE;
		String taxes = "Taxes  " + "$" + df.format((pricePerNight * minNight + CLEANING_FEE + SERVICE_FEE) * TAX_RATE);
		String total = "Total (USD)  " + "$" + (calcTotalPrice(minNight));
		System.out.print(priceBreak + "\n" + nightFee + "\n" + cleaning + "\n" + service + "\n" + (taxes) + "\n" + total);
	
	}

/**
 * @return the totalListings
 */
public int getTotalListings() {
	return totalListings;
}
/**
 * @param totalListings the totalListings to set
 */


/**
 * @return the cLEANING_FEE
 */
public double getCLEANING_FEE() {
	return CLEANING_FEE;
}
/**
 * @param cLEANING_FEE the cLEANING_FEE to set
 */
public void setCLEANING_FEE(double cLEANING_FEE) {
	CLEANING_FEE = cLEANING_FEE;
}
/**
 * @return the sERVICE_FEE
 */
public double getSERVICE_FEE() {
	return SERVICE_FEE;
}
/**
 * @param sERVICE_FEE the sERVICE_FEE to set
 */
public void setSERVICE_FEE(double sERVICE_FEE) {
	SERVICE_FEE = sERVICE_FEE;
}
/**
 * @return the tAX_RATE
 */
public double getTAX_RATE() {
	return TAX_RATE;
}
/**
 * @param tAX_RATE the tAX_RATE to set
 */
public void setTAX_RATE(double tAX_RATE) {
	TAX_RATE = tAX_RATE;
}
/**
 * @return the lCode
 */
public String getlCode() {
	return lCode;
}
/**
 * @param lCode the lCode to set
 */
public void setlCode(String lCode) {
	this.lCode = lCode;
}
/**
 * @return the location
 */
public String getLocation() {
	return location;
}
/**
 * @param location the location to set
 */
public void setLocation(String location) {
	this.location = location;
}
/**
 * @return the lName
 */
public String getlName() {
	return lName;
}
/**
 * @param lName the lName to set
 */
public void setlName(String lName) {
	this.lName = lName;
}
/**
 * @return the lType
 */
public String getlType() {
	return lType;
}
/**
 * @param lType the lType to set
 */
public void setlType(String lType) {
	this.lType = lType;
}
/**
 * @return the minNight
 */
public int getMinNight() {
	return minNight;
}
/**
 * @param minNight the minNight to set
 */
public void setMinNight(int minNight) {
	this.minNight = minNight;
}
/**
 * @return the wName
 */
public String getwName() {
	return wName;
}
/**
 * @param wName the wName to set
 */
public void setwName(String wName) {
	this.wName = wName;
}
/**
 * @return the wPassword
 */
public String getwPassword() {
	return wPassword;
}
/**
 * @param wPassword the wPassword to set
 */
public void setwPassword(String wPassword) {
	this.wPassword = wPassword;
}
/**
 * @return the cCode
 */
public String getcCode() {
	return cCode;
}
/**
 * @param cCode the cCode to set
 */
public void setcCode(String cCode) {
	this.cCode = cCode;
}
/**
 * @return the pricePerNight
 */
public double getPricePerNight() {
	return pricePerNight;
}
/**
 * @param pricePerNight the pricePerNight to set
 */
public void setPricePerNight(double pricePerNight) {
	this.pricePerNight = pricePerNight;
}
/**
 * @return the avgRating
 */
public double getAvgRating() {
	return avgRating;
}
/**
 * @param avgRating the avgRating to set
 */
public void setAvgRating(double avgRating) {
	this.avgRating = avgRating;
}
public String getToString() {
	return toString();
}

}
