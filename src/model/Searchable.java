package model;

import java.util.ArrayList; 

/**
 * The Searchable interface defines methods for searching resources by different
 * criteria.
 */
public interface Searchable {

	/**
	 * Searches for resources by title.
	 *
	 * title The title to search for.
	 * return A list of resources matching the specified title.
	 */
	ArrayList<Resource> searchByTitle(String title);

	/**
	 * Searches for resources by author.
	 *
	 *  author The author to search for.
	 * return a list of resources matching the specified author.
	 */
	ArrayList<Resource> searchByAuthor(String author);

	/**
	 * Searches for resources by publication date.
	 *
	 *  publicationDate The publication date to search for.
	 * return a list of resources matching the specified publication date.
	 */
	ArrayList<Resource> searchByPublicationDate(String publicationDate);

	/**
	 * Searches for resources by genre
	 *
	 *  genre The genre to search for.
	 * return A list of resources matching the specified genre.
	 */
	ArrayList<Resource> searchByGenre(Genre genre);
}
