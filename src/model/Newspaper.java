package model; 
/**
 * The Newspaper class represents a newspaper resource in a library. It extends
 * the Item class, providing specific attributes for newspapers such as
 * publisher, country.
 */
public class Newspaper extends Item {
	private String publisher;
	private String country;

	/**
	 * Constructs a Newspaper object with the specified attributes.
	 *
	 *  resourceId      The unique identifier of the newspaper resource.
	 *  title           The title of the newspaper resource.
	 *  publicationDate The publication date of the newspaper resource.
	 *  publisher       The publisher of the newspaper.
	 *  country         The country of publication for the newspaper.
	 */
	public Newspaper(int resourceId, String title, String publicationDate, String publisher, String country) {
		super(resourceId, title, publicationDate);
		this.publisher = publisher;
		this.country = country;}
	

	/**
	 * Gets the publisher of the newspaper.
	 *
	 * return The publisher of the newspaper.
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Gets the country of publication for the newspaper.
	 *
	 * return The country of publication for the newspaper.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Returns a string representation of the newspaper.
	 *
	 * return A string containing information about the newspaper.
	 */
	@Override
	public String toString() {
		return "Newspaper - Title: " + getTitle() + ", Publisher: " + getPublisher() + ", Country: " + getCountry();
	}
}
