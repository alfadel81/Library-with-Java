package model;

/**
 * The Magazine class represents a magazine resource in a library. It extends
 * the Item class. It provides methods to access and manipulate
 * magazine-specific attributes.
 */
public class Magazine extends Item {
	private String publisher;
	private int issueNumber;
	private Periodicity periodicity;

	/**
	 * Constructs a Magazine with the specified attributes.
	 *
	 * resourceId      The unique identifier of the magazine.
	 * title           The title of the magazine.
	 * publicationDate The publication date of the magazine.
	 * publisher       The publisher of the magazine.
	 * issueNumber     The issue number of the magazine.
	 * periodicity     The periodicity of the magazine.
	 */
	public Magazine(int resourceId, String title, String publicationDate, String publisher, int issueNumber,
			Periodicity periodicity) {
		super(resourceId, title, publicationDate);
		this.publisher = publisher;
		this.issueNumber = issueNumber;
		this.periodicity = periodicity;}
	

	/**
	 * Gets the publisher of the magazine.
	 *
	 * return The publisher of the magazine.
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Gets the issue number of the magazine.
	 *
	 * return The issue number of the magazine.
	 */
	public int getIssueNumber() {
		return issueNumber;
	}

	/**
	 * Gets the periodicity of the magazine.
	 *
	 * return The periodicity of the magazine.
	 */
	public Periodicity getPeriodicity() {
		return periodicity;
	}

	/**
	 * Returns a string representation of the Magazine object.
	 *
	 * return a string containing information about the magazine.
	 */
	@Override
	public String toString() {
		return "Magazine - Title: " + getTitle() + ", Publisher: " + getPublisher() + ", Issue Number: "
				+ getIssueNumber() + ", Periodicity: " + getPeriodicity();}
	
}
