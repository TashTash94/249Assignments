/**---------------------------------------------------------------------
*Written by: (YeeHo Chow (40032218) and Tayyab Qureshi (40093089))
*For COMP 249 Section (U) - Winter 2019
*Assignment 1
*Question: Part 1
*Due Date: Friday,February 1, 2019
*---------------------------------------------------------------------
*This class is to store information on the books such as the title, the author,the ISBN, the price and the total number of books.
*@author Yeeho Chow and Tayyab Qureshi
*@version 1.0
*/

public class book {
	
	private String title, author;
	private long ISBN;
	private double price;
	static int numberOfCreatedBook = 0;

	
	public book() {
		title = "title";
		author = "author";
		ISBN = 0;
		price = 0;
		numberOfCreatedBook++;
	}
	
	/**
	 * This is a constructor with a specified title, author, ISBN and price
	 * @param title the title of the book
	 * @param author the author of the book
	 * @param ISBN the ISBN of the book
	 * @param price the cost of the book
	 */

	public book(String title, String author, Long ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		numberOfCreatedBook++;
	}
	/**
	 *  This a copy constructor
	 * @param other this refers to a different book object that will be copied
	 */

	public book(book other) {
		title = other.title;
		author = other.author;
		ISBN = other.ISBN;
		price = other.price;
	}
	/**
	 *  This method gets the title of a copy of a book
	 * @return this book's title
	 */

	public String getTitle() {
		book b1 = new book(this);
		return b1.title;
	}
	
	/**
	 * This method sets the title a book to a specified title
	 * @param title this is the new title of the book
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method gets the author of the book
	 * @return this book's author
	 */
	
	public String getAuthor() {
		book b1 = new book(this);
		return b1.author;
	}
	
	/**
	 * This method sets the author of the book to a specified author
	 * @param author this is the new author of the book
	 */

	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * This method gets the ISBN of a book
	 * @return this book's ISBN
	 */

	public long getISBN() {
		book b1 = new book(this);
		return b1.ISBN;
	}
	
	/**
	 * This method sets the ISBN of a book to a specified ISBN
	 * @param ISBN This is the unique identifier of the book
	 */

	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
	/**
	 * This method gets the price of a book
	 * @return The cost of a book
	 */

	public double getPrice() {
		book b1 = new book(this);
		return b1.price;
	}
	
	/**
	 * This method sets the price of a book to a specified price
	 * @param price This is the new price of the book
	 */

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 */
	
	public String toString() {

		return "\nAuthor: " + author + "\nTitle: " + title + "\nISBN: " + ISBN + "\nPrice: " + price + "\n";
	}

	/**
	 *  This method gets the total number of books that were created
	 * @return The total number of books
	 */

	public int findNumberOfCreatedBooks() {

		return numberOfCreatedBook;
	}

	/**
	 *  This method checks if two books are the same by comparing their price and their ISBN.
	 * @param other This refers to a different book
	 * @return This returns either true if the books are the same or false if they are not
	 */

	public boolean equals(book other) {

		return ISBN == other.ISBN && price == other.price;
	}
}
