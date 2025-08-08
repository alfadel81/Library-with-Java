package model;

/**
 * The Book class represents a book resource in a library. It extends the Item
 * class. Each book has an author, genre, page count
 */
public class Book extends Item {
	private String author;
	private Genre genre;
	private int pageCount;

	/**
	 * Constructs a Book with the specified details.
	 *
	 * resourceId      The unique identifier for the book.
	 * title           The title of the book.
	 * publicationDate The publication date of the book.
	 * author          The author of the book.
	 * genre           The genre of the book.
	 * pageCount       The page count of the book.
	 */
	public Book(int resourceId, String title, String publicationDate, String author, Genre genre, int pageCount) {
		super(resourceId, title, publicationDate);
		this.author = author;
		this.genre = genre;
		this.pageCount = pageCount;}
	

	/**
	 * Gets the author of the book.
	 *
	 *return The author of the book.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gets the genre of the book.
	 *
	 * return The genre of the book.
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Gets the page count of the book.
	 *
	 * return The page count of the book.
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * Overrides the toString method to provide a string representation of the book.
	 *
	 * return a string representation of the book.
	 */
	@Override
	public String toString() {
		return "Book - Title: " + getTitle() + ", Author: " + getAuthor() + ", Genre: " + getGenre() + ", Page Count: "
				+ getPageCount();}
	
}
