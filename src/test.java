
/**
 * ---------------------------------------------------------------------
*Written by: (YeeHo Chow (40032218) and Tayyab Qureshi (40093089))
*For COMP 249 Section (U) - Winter 2019
*Assignment 1
*Question: Part 2
*Due Date: Friday,February 1, 2019
*---------------------------------------------------------------------
*This class is to help to keep track of the books. The information of the book, find books with certain author name and price range.
*/

import java.util.Scanner;

public class test {

	static int p, i, count = 0;
	static int input;
	static int maxBooks;
	static book[] inventory;;

	static Scanner sc = new Scanner(System.in);

	/**
	 * This method verifies if all user input is correct then initializes a book to
	 * the author, title, price, and ISBN entered
	 * 
	 * @return This return the book that was initialized
	 */

	public static book initializeBook() {
		System.out.println("Enter the author's name");
		String bookAuthor = sc.nextLine();
		System.out.println("Enter the title of the book");
		String bookTitle = sc.nextLine();
		double bookPrice = -1;
		do {
			System.out.println("Enter the price of the book");
			if (!sc.hasNextDouble()) {
				sc.next();
				continue;
			}
			bookPrice = sc.nextDouble();
		} while (bookPrice < 0);
		sc.nextLine();
		long bookISBN = -1;
		do {
			System.out.println("Enter the ISBN of the book");
			if (!sc.hasNextLong()) {
				sc.next();
				continue;
			}
			bookISBN = sc.nextLong();
		} while (bookISBN < 0);
		sc.nextLine();
		book b1 = new book(bookTitle, bookAuthor, bookISBN, bookPrice);
		return b1;
	}

	/**
	 * This method is to get the number of total books created while subtracting the
	 * books that were created in this method
	 * 
	 * @return The total number of books
	 */

	public static int getNumberOfBooks() {
		book b1 = new book();
		count++;
		int bookNb = b1.findNumberOfCreatedBooks() - count;
		return bookNb;
	}

	/**
	 * This method displays the 4 attributes the user can change and option to quit
	 * and go back to the main menu. Once the user chooses an option, it makes the
	 * change the user asked for and then shows the 5 options again until they quit
	 * to the main menu
	 */

	public static void changeInfo() {
		System.out.print(
				"What information would you like to change?\n\t1. Author\n\t2. Title\n\t3. ISBN\n\t4. Price\n\t5. Quit\n");
		input = 6;
		do {
			System.out.println("Please enter a number between 1-5 inclusively");
			if (!sc.hasNextInt()) {
				sc.next();
				continue;
			}
			input = sc.nextInt();
			sc.nextLine();
		} while (input < 1 || input > 5);
		switch (input) {
		case 1:
			System.out.println("Enter the new name of the author");
			String authorName = sc.nextLine();
			inventory[p].setAuthor(authorName);
			System.out.println("The author of this book is now " + inventory[p].getAuthor());
			changeInfo();
			break;
		case 2:
			System.out.println("Enter the new title of the book");
			String titleName = sc.nextLine();
			inventory[p].setTitle(titleName);
			System.out.println("The title of this book is now " + inventory[p].getTitle());
			changeInfo();
			break;
		case 3:
			long bookISBN = -1;
			do {
				System.out.println("Enter the ISBN of the book");
				if (!sc.hasNextLong()) {
					sc.next();
					continue;
				}
				bookISBN = sc.nextLong();
			} while (bookISBN < 0);
			sc.nextLine();
			inventory[p].setISBN(bookISBN);
			System.out.println("The ISBN of this book is now " + inventory[p].getISBN());
			changeInfo();
			break;
		case 4:
			System.out.println("Enter the new price of the book");
			double bookPrice = -1;
			do {
				System.out.println("Enter the price of the book");
				if (!sc.hasNextDouble()) {
					sc.next();
					continue;
				}
				bookPrice = sc.nextDouble();
			} while (bookPrice < 0);
			sc.nextLine();
			inventory[p].setPrice(bookPrice);
			System.out.println("The price of this book is now " + inventory[p].getPrice());
			changeInfo();
			break;
		case 5:
			break;
		}
	}

	/**
	 * This method is to return all books by a certain author. It loops the entire
	 * array of books and if they are not null, it checks if the author name input
	 * by the user is the same as the book's author and if so, it prints the book's
	 * information
	 * 
	 */

	public static void findBooksBy() {
		System.out.println("Enter the name of the author:");
		String authorName = sc.nextLine();
		System.out.println("");
		for (int i = 0; i < maxBooks; i++) {
			if (inventory[i] == null)
				continue;
			if (authorName.equalsIgnoreCase(inventory[i].getAuthor())) {
				System.out.println("Book: #" + i + inventory[i]);
			}
		}
	}

	/**
	 * This method asks the user for a certain price and loops through all the books
	 * to return books of the same value or books that are cheaper than that price
	 */

	public static String findCheaperThan() {
		double priceOfBook = -1;
		do {
			System.out.println(
					"Please enter the price of the book. We will find all books cheaper or of the same price.");
			if (!sc.hasNextDouble()) {
				sc.next();
				continue;
			}
			priceOfBook = sc.nextDouble();
		} while (priceOfBook < 0);
		sc.nextLine();
		for (int i = 0; i < maxBooks; i++) {
			if (inventory[i] == null)
				continue;
			if (inventory[i].getPrice() <= priceOfBook) {
				System.out.println(inventory[i]);
			}
		}
		return "";
	}

	/**
	 * This method takes the input from the menu() method and uses to choose which
	 * of the 5 options the user has made. From there, it does what the user has
	 * asked to do.
	 * 
	 * @param input this refers to the choice from 1 to 5 the user has made in the
	 *              menu method
	 */

	public static void choices(int input) {
		switch (input) {
		case 1:
			String pw = "password";
			int k;
			for (k = 0; k < 4; k++) {
				for (int j = 0; j < 3; j++) {
					System.out.println("Enter the password");
					String pw1 = sc.next();
					if (pw1.equals(pw)) {
						j = 4;
						k = 5;
						break;
					}
				}
				if (k == 5)
					break;
				i++;
				if (i == 4) {
					break;
				}
				menu();
			}
			if (k == 5) {
				System.out.println("How many books would you like to enter?");
				int bookInput = -1;
				int booksAllowed;
				do {
					booksAllowed = maxBooks - getNumberOfBooks();
					System.out.println("Please enter a valid number!");
					System.out.println("There are " + booksAllowed + " books allowed.");
					if (!sc.hasNextInt()) {
						sc.next();
						continue;
					}
					bookInput = sc.nextInt();
				} while (bookInput > booksAllowed || bookInput <= 0);
				sc.nextLine();

				for (int j = maxBooks - booksAllowed; j < maxBooks - booksAllowed + bookInput; j++) {
					inventory[j] = initializeBook();
				}
			}

			else if (i == 4) {
				System.out.print(
						"Suspicious activity detected!\nYou have attempted this too many times. Program will now self-destruct!");
				System.exit(0);
			}
			menu();
			break;
		case 2: {
			pw = "password";
			int w = 0;

			for (w = 0; w < 3; w++) {
				System.out.println("Enter the password");
				String pw1 = sc.next();
				if (pw1.equals(pw)) {
					w = 4;
					break;
				}
			}
			if (w == 3)
				menu();
			if (w == 4) {
				int numOfThisBook = -1;
				do {
					System.out.println("Please enter the number of the book you want to edit. Make sure it is valid");
					if(!sc.hasNextInt()) {
						sc.next();
						continue;
					}
					numOfThisBook = sc.nextInt();
					if (numOfThisBook < 0 || numOfThisBook >= maxBooks)
						continue;
					if (inventory[numOfThisBook] == null)
						continue;
				} while (numOfThisBook < 0 || numOfThisBook >= maxBooks || inventory[numOfThisBook] == null);
				sc.nextLine();
				p = numOfThisBook;
				changeInfo();
				menu();
			}
		}
			break;
		case 3:
			findBooksBy();
			menu();
			break;
		case 4:
			findCheaperThan();
			menu();
			break;
		case 5:
			System.out.println("Thank you for using our program, until next time! BuhBye!");
			break;
		}
	}

	/**
	 * This method shows the 5 options the user can make and stores their choice in
	 * the variable input that the choices() method uses to execute the option the
	 * user has chosen
	 */

	public static void menu() {
		System.out.print(
				"What do you want to do?\n\t1. Enter new books (Password required)\n\t2. Change information of a book (Password required)\n\t3. Display all books by a specific author\n\t4. Display all books under a certain price\n\t5. Quit\n");
		input = 6;
		do {
			System.out.println("Please enter a number between 1-5 inclusively");
			if (!sc.hasNextInt()) {
				sc.next();
				continue;
			}
			input = sc.nextInt();
			sc.nextLine();
		} while (input < 1 || input > 5);
		choices(input);
	}

	/**
	 * Displays welcome message
	 */
	
	public static void welcome() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"Welcome to our inventory tracker for your books! This program is written by Yee-Ho Chow and Tayyab Qureshi!");
		System.out.println(
				"This will assist your bookstore in keeping up with high amounts of books and make it easy to change information");
		System.out.println("and add new ones. Thank you for using our software!");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------");
	}
	
	public static void main(String[] args) {
		welcome();
		do {
			System.out.println("Please enter the number of books in your inventory");
			if (!sc.hasNextInt()) {
				sc.next();
				continue;
			}
			maxBooks = sc.nextInt();
		} while (maxBooks < 1);
		sc.nextLine();
		inventory = new book[maxBooks];
		menu();
	}

}
