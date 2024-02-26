/**
 * 
 */
package lzp;
import java.util.Random;
import java.util.Scanner;

/** Tester for the AirBnbListing Class
 * @author Lucas Paul
 */
public class TestAirBnbListing {

	//creating variables for imported utilities for the program
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create three Airbnb listings with different information
        AirBnbListing listing1 = new AirBnbListing("Spotlight Studio", "22 N Main St., Normal", "Studio", 50);
        AirBnbListing listing2 = new AirBnbListing("RedBird Apartment", "200 College Ave., Normal", "Apartment", 85);
        AirBnbListing listing3 = new AirBnbListing("TownHouse near Rivian", "13 Mulberry St., Bloomington", "Town House", 250);

        // Display a welcome message
        System.out.println("Welcome to AirBnb Booking!");
        System.out.println(" ");

        // Initialize a loop to display the menu and handle user input
        int e = 0;
        while (e != 10000) {
            // Display the menu options
            displayMenu();
            System.out.print("\nEnter your choice: ");
            String input = scan.next();

            // Use a switch statement to handle the user's choice
            switch (input) {
                case "L":
                    // List all available listings
                    System.out.println(listing1.toString());
                    System.out.println(" ");
                    System.out.println(listing2.toString());
                    System.out.println(" ");
                    System.out.println(listing3.toString());
                    System.out.println(" ");
                    break;
                case "LC":
                    // List available listings by location
                    System.out.print("Enter the location: ");
                    String location = scan.next();
                    if (location.equals("Normal")) {
                        System.out.println(listing1.toString());
                        System.out.println(listing2.toString());
                        System.out.println(" ");
                    }
                    if (location.equals("Bloomington")) {
                        System.out.println(listing3.toString());
                        System.out.println(" ");
                    }
                    break;
                case "LT":
                    // List available listings by type
                    System.out.println("What type of unit are you looking for?");
                    System.out.print("\n 1- Private room");
                    System.out.print("\n 2- Studio");
                    System.out.print("\n 3- TownHouse");

                    System.out.print("\nEnter your choice: ");
                    int choice = scan.nextInt();

                    if (choice == 2) {
                        System.out.println(listing1.toString());
                        System.out.println(" ");
                    }
                    if (choice == 1) {
                        System.out.println(listing2.toString());
                        System.out.println(" ");
                    }
                    if (choice == 3) {
                        System.out.println(listing3.toString());
                        System.out.println(" ");
                    }
                    break;
                case "LR":
                    // List available listings by rating
                    System.out.print("What minimum rating are you looking for? ");
                    double rating = scan.nextDouble();
                    if (listing1.getAvgRating() >= rating) {
                        System.out.println(listing1.toString());
                    }
                    if (listing2.getAvgRating() >= rating) {
                        System.out.println(listing2.toString());
                    }
                    if (listing3.getAvgRating() >= rating) {
                        System.out.println(listing3.toString());
                    } else {
                        System.out.print("Sorry, no listing has that rating.");
                    }
                    break;
                case "B":
                    // Book a listing
                    System.out.print("For which listing? ");
                    String book = scan.next();

                    if (book.equals(listing1.getcCode())) {
                        System.out.print("\nHow many nights? ");
                        int nights = scan.nextInt();
                        if (nights >= 1) {
                            System.out.println("Booking successful!");
                            listing1.bookListing(nights);
                        }
                    }
                    if (book.equals(listing2.getcCode())) {
                        System.out.print("\nHow many nights? ");
                        int nights2 = scan.nextInt();
                        if (nights2 >= 3) {
                            System.out.println("Booking successful!");
                            listing2.bookListing(nights2);
                        }
                    }
                    if (book.equals(listing3.getcCode())) {
                        System.out.print("\nHow many nights? ");
                        int nights3 = scan.nextInt();
                        if (nights3 >= 7) {
                            System.out.println("Booking successful!");
                            listing3.bookListing(nights3);
                        }
                    }
                    break;
                case "Q":
                    // Quit the program
                    System.out.println(" ");
                    System.out.println("Goodbye!");
                    break;
                default:
                    // Handle invalid input
                    System.out.println(" ");
                    System.out.println("Invalid Input.");
                    break;
            }
        }
    }
	/** Method that displays a format for the user to input their information
	 * @param displayMenu
	 * Return- None
	 */
    public static void displayMenu() {
        System.out.println(" ");
        System.out.println("Please choose one of the following:");
        System.out.println("L - List available listings");
        System.out.println("LC - List available listings by location");
        System.out.println("LT - List available listings by type");
        System.out.println("LR - List available listings by rating");
        System.out.println("B - Book a listing");
        System.out.println("Q - Quit");
    }
}
