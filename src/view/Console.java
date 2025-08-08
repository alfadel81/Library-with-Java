package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import java.io.*;

/**
 * The Console class provides a simple console-based user interface for
 * interacting with a library management system. It allows users to create,
 * display, and search for resources such as books, magazines, newspapers, and
 * services. Users can also reserve and unreserve resources, as well as save the
 * data to a file before exiting the program.
 */
public class Console {
	private Scanner scanner, scanner2;
	Library library = new Library();//object of library to call its methods

	public Console() {
		this.scanner = new Scanner(System.in);
		this.scanner2 = new Scanner(System.in);}
	

	/**
	 * Starts the library management system console. Displays the main menu and
	 * handles user input until the user chooses to exit.
	 */
	public void start() {
		loadData();//take data from the file and save it in the ArraList resources in the Librry
		int selection;//initialized out for while
		do {
			printMenu();//just print the menu
			selection = getUserInput(0, 4);//handel user input
			switch (selection) {
			case 1:
				createNewResource();
				break;
			case 2:
				displayAvailableResources();
				break;
			case 3:
				displayReservedResources();
				break;
			case 4:
				searchResources();
				break;
			case 0:
				saveAndExit();
				break;
			default:
				System.out.println("Invalid selection. Please try again.");
			}

		} while (selection != 0);
	}

	/**
	 * Print the main menu options for the library system
	 */
	private void printMenu() {
		System.out.println("Select an option:");
		System.out.println("(1) Create a new resource");
		System.out.println("(2) Display available resources");
		System.out.println("(3) Display reserved resources");
		System.out.println("(4) Search resources");
		System.out.println("(0) Save / Exit");
		System.out.print("Selection: ");}
	

	/**
	 * Gets user input within a specified range.
	 *
	 *  min The minimum allowed input value.
	 *  max The maximum allowed input value.
	 * return The user's input within the specified range.
	 */
	private int getUserInput(int min, int max) {
		int input;//should be initialized out the loop for the return
		while (true) {//user will enter the loop and get out if inter valid number
			try {
				input = scanner2.nextInt();
				if (input >= min && input <= max) {//if achived terminate loop
					break;
				} else {//tell user to enter valid number then go back to loop to check entered number
					System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
				}
			} catch (NumberFormatException e) {//specific type of exception
				System.out.println("Invalid input. Please enter a valid number.");}
			
		}
		return input;//if done return valid number
	}

	/**
	 * Creates a new resource based on user input. Allow user to choose between
	 * creating a new item (book, magazine, newspaper,media) or a service.
	 */
	private void createNewResource() {
		System.out.println("Select a resource type:");//opptions
		System.out.println("(1) Item");
		System.out.println("(2) Service");
		System.out.println("(0) Cancel / Main menu");
		int resourceType = getUserInput(0, 2);//handel input
		switch (resourceType) {
		case 1:
			createNewItem();
			break;
		case 2:
			createNewService();
			break;
		case 0:
			// Cancel / Return to Main Menu
			return;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	/**
	 * Creates a new item based on user input. Users can choose between creating a
	 * new book, magazine, or newspaper,media.
	 */
	private void createNewItem() {
		int itemType;
		do {
			System.out.println("Enter item details:");
			System.out.print("Resource ID: ");
			int resourceId = getUserInput(0, Integer.MAX_VALUE);//maximum integer can be writen 
			System.out.print("Title: ");
			String title = scanner.nextLine();
			System.out.print("Publication Date: ");
			String publicationDate = scanner.nextLine();
			System.out.println("Select item type:");
			System.out.println("(1) Book");
			System.out.println("(2) Magazine");
			System.out.println("(3) Newspaper");
			System.out.println("(4) media");
			System.out.println("(0) Return to Main Menu");
			itemType = getUserInput(0, 4);//handel input
			switch (itemType) {
			case 1:
				createNewBook(resourceId, title, publicationDate);
				break;
			case 2:
				createNewMagazine(resourceId, title, publicationDate);
				break;
			case 3:
				createNewNewspaper(resourceId, title, publicationDate);
				break;
			case 4:
				createMedia(resourceId, title, publicationDate);
				break;
			case 0:
				return; // Return to the main menu
			default:
				System.out.println("Invalid option. Please try again.");
			}
			// After creating the item, ask the user if they want to reserve or release it
			System.out.println("Do you want to:");
			System.out.println("(1) Reserve this resource");
			System.out.println("(2) unreserve resource");
			System.out.println("(0) Return to Main Menu");
			int reserveOrUnreserve = getUserInput(0, 2);
			switch (reserveOrUnreserve) {
			case 1:
				reserveResource();
				return;
			case 2:
				unreserveResource();
				return;
			case 0:
				return; // Return to the main menu
			default:
				System.out.println("Invalid option. Resource not reserved or released.");
			}

		} while (itemType != 0);
	}

	/**
	 * Creates a new book with the specified details.
	 *
	 *  resourceId      The ID of the book.
	 *  title           The title of the book.
	 *  publicationDate The publication date of the book.
	 */
	private void createNewBook(int resourceId, String title, String publicationDate) {
		System.out.print("Author: ");
		String author = scanner.nextLine();
		System.out.print("Genre (History,Travel,Biography,Photography): ");
		String genre = scanner.nextLine();
		Genre enumGenre = Genre.valueOf(genre);//take string vale and return cooresponding enum save in enumGenre
		System.out.print("Page Count: ");
		int pageCount = getUserInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
		Book newBook = new Book(resourceId, title, publicationDate, author, enumGenre, pageCount);
		library.addResource(newBook);//save the book in the resources ArrayList
		System.out.println("Book created successfully: " + title);
	}

	/**
	 * Creates a new magazine with the specified details
	 *
	 *  resourceId      The ID of the magazine.
	 *  title           The title of the magazine.
	 *  publicationDate The publication date of the magazine.
	 */
	private void createNewMagazine(int resourceId, String title, String publicationDate) {
		System.out.print("Publisher: ");
		String publisher = scanner.nextLine();
		System.out.print("Issue Number: ");
		int issueNumber = getUserInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.print("Periodicity (DAILY, WEEKLY, MONTHLY, ANNUALLY): ");
		String periodicity = scanner.nextLine();
		Periodicity enumPeriodicity = Periodicity.valueOf(periodicity);
		Magazine newMagazine = new Magazine(resourceId, title, publicationDate, publisher, issueNumber,
				enumPeriodicity);
		library.addResource(newMagazine);
		System.out.println("Magazine created successfully: " + title);
	}

	/**
	 * Creates a new newspaper with the specified details.
	 *
	 *  resourceId      The ID of the newspaper.
	 *  title           The title of the newspaper.
	 *  publicationDate The publication date of the newspaper.
	 */
	private void createNewNewspaper(int resourceId, String title, String publicationDate) {
		System.out.print("Publisher: ");
		String publisher = scanner.nextLine();
		System.out.print("Country: ");
		String country = scanner.nextLine();

		Newspaper newNewspaper = new Newspaper(resourceId, title, publicationDate, publisher, country);
		library.addResource(newNewspaper);
		System.out.println("Newspaper created successfully: " + title);
	}

	/**
	 * Creates a  media with the specified details.
	 *
	 *  resourceId      The ID of the newspaper.
	 *  title           The title of the newspaper.
	 *  publicationDate The publication date of the newspaper.
	 */
	private void createMedia(int resourceId, String title, String publicationDate) {
		System.out.print("Publisher: ");
		String format = scanner.nextLine();
		System.out.print("Size: ");
		double size = scanner.nextDouble();

		Media media = new Media(resourceId, title, publicationDate, format, size);
		library.addResource(media);
		System.out.println("Newspaper created successfully: " + title);
	}

	/**
	 * Creates a new service based on user input.
	 */
	private void createNewService() {
		System.out.println("Enter service details:");
		System.out.print("Resource ID: ");
		int resourceId = getUserInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Cost: ");
		double cost = scanner.nextDouble(); 
		Service newService = new Service(resourceId, name, cost);
		library.addResource(newService);
		System.out.println("Service created successfully: " + name);
		return;
	}

	/**
	 * Displays the available resources in the library.
	 */
	private void displayAvailableResources() {
		System.out.println("Available Resources:");
		for (Resource resource : library.getResources()) {// getResources() method in library return resources ArrayList
			if (resource.isReserved()==false) {//if the resource is reserved will not be shown
				System.out.println(resource);
			}
		}
	}

	/**
	 * Displays the reserved resources in the library.
	 */
	private void displayReservedResources() {
		System.out.println("Reserved Resources:");
		for (Resource resource : library.getResources()) {
			if (resource.isReserved()) {//if true
				System.out.println(resource);
			}
		}
	}

	/**
	 * reserve a resource based on user input.
	 */
	private void reserveResource() {
		System.out.print("Enter resource ID to reserve: ");
		int resourceId = getUserInput(0, Integer.MAX_VALUE);
		// Find the resource with the specified ID
		Resource resource = library.findResourceById(resourceId);//use the method findResourceById in library to find the resource
		if (resource != null) {
			// Check if the resource is not reserved by isReserved method in Resource
			if (resource.isReserved() == false) {
				resource.reserve();//method to make it reserved
				System.out.println("Resource reserved successfully: " + resource);
			} else {//if it Already reserved
				System.out.println("Resource already reserved: " + resource);}
			
		} else {
			System.out.println("Resource not found with ID: " + resourceId);}
		
	}

	/**
	 * Releases a reserved resource based on user input.
	 */
	private void unreserveResource() {
		System.out.print("Enter resource ID to release: ");
		int resourceId = getUserInput(0, Integer.MAX_VALUE);//check if id out of java range
		// Find the resource with the specified ID
		Resource resource = library.findResourceById(resourceId);
		if (resource != null) {
			// Check if the resource is reserved
			if (resource.isReserved()) {//if true
				resource.unreserve();//make it un reserved by unreserve() method in Resource
				System.out.println("Resource released successfully: " + resource);
			} else {
				System.out.println("Resource is not reserved: " + resource);
			}
		} else {
			System.out.println("Resource not found with ID: " + resourceId);
		}
	}

	/**
	 * Searches for resources based on user-specified criteria such as title,
	 * author, genre, or publication date.
	 */
	private void searchResources() {
		System.out.println("Search resources by:");
		System.out.println("(1) Title");
		System.out.println("(2) Author");
		System.out.println("(3) Genre");
		System.out.println("(4) Publication Date");
		System.out.println("(0) Return to Main Menu");
		int searchOption = getUserInput(0, 4);
		switch (searchOption) {
		case 1:
			System.out.print("Enter title to search: ");
			String title = scanner.nextLine();
			ArrayList<Resource> list = library.searchByTitle(title);//will return ArrayList then it will saved in List
			for (Resource resource : list) {//show items with specific title
				System.out.println(resource);
			}
			break;
		case 2:
			System.out.print("Enter author to search: ");
			String author = scanner.nextLine();
			list = library.searchByAuthor(author);//return arraylist with book have specific auther then save in list
			for (Resource resource : list) {
				System.out.println(resource);
			}
			break;
		case 3:
			System.out.print("Enter genre to search: ");
			String genre = scanner.nextLine();
			Genre genreValue = Genre.valueOf(genre);
			list = library.searchByGenre(genreValue);
			for (Resource resource : list) {
				System.out.println(resource);
			}
			break;
		case 4:
			System.out.print("Enter Publication Date to search: ");
			String date = scanner.nextLine();
			list = library.searchByPublicationDate(date);
			for (Resource resource : list) {
				System.out.println(resource);
			}
			break;
		case 0:
			return;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	/**
	 * Saves the current list of resources to a file and exits the program.
	 */
	private void saveAndExit() {
		System.out.println("Saving data and exiting. Goodbye!");
		// Save the data to the "collection.dat" file
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/collection.dat"));
			// Write the list of resources to the file
			oos.writeObject(library.getResources());//will save All resources in the file 
		} catch (IOException e) {
			System.out.println("Error saving data: " + e.getMessage());
		}
	}

	private void loadData() {
		// load the data from the "collection.dat" file
		//will open collection.dat and read the ArrayList saved in it then will set the resources ArrayLisyt
		//in the Library to the readed ArrayList after cast it to ArrayList<Resource>.
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("data/collection.dat"));
			library.setResources((ArrayList<Resource>) oos.readObject());//get all resources in file at 
			oos.close();                                      //once then cast it to ArrayList<Resource>
			                                                  //then save it in resources in library
		} catch (IOException e) {
			System.out.println("Error loading data: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading data: " + e.getMessage());}
		
	}

	/**
	 * The main entry point for the library management system console application.
	 *
	 */
	public static void main(String[] args) {
		Console libraryConsole = new Console();
		libraryConsole.start();}
	
}
