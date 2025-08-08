package model;

/**
 * The Item class represents  library items. It extends the Resource
 * class and implements the Borrowable interface. Each item has a title,
 * publication date
 */
public abstract class Item extends Resource implements Borrowable {
	private String title;
	private String publicationDate;
	private boolean checkedOut;

	/**
	 * Constructs an Item with the specified details.
	 *
	 * resourceId      The unique identifier for the item.
	 * title           The title of the item.
	 * publicationDate The publication date of the item.
	 */
	public Item(int resourceId, String title, String publicationDate) {
		super(resourceId);
		this.title = title;
		this.publicationDate = publicationDate;
		this.checkedOut = false;}
	

	/**
	 * Gets the title of the item.
	 *
	 * return The title of the item.
	 */
	public String getTitle() {
		return title;}
	

	/**
	 * Gets the publication date of the item.
	 *
	 * return The publication date of the item.
	 */
	public String getPublicationDate() {
		return publicationDate;}
	

	/**
	 * Overrides the checkout method in the Borrowable interface to handle
	 * item-specific checkout logic.
	 */
	@Override
	public void checkout() {
		if (!checkedOut&&!isReserved()) {
			System.out.println("Item checked out: " + title);
			checkedOut = true;
		} else {
			System.out.println("Item is already checked out or reserved: " + title);}
		
	}

	/**
	 * Overrides the returnItem method in the Borrowable interface to handle
	 * item-specific return logic.
	 */
	@Override
	public void returnItem() {
		if (checkedOut) {//if true 
			System.out.println("Item returned: " + title);
			checkedOut = false;
		} else {
			System.out.println("Item is not checked out: " + title);
		}
	}
}
