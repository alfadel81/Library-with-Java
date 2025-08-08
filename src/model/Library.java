package model;

import java.util.ArrayList;

/**
 * The Library class represents a collection of resources. It provides methods
 * to add resources to the library and retrieve the list of resources.
 */
public class Library implements Searchable {
	private ArrayList<Resource> resources = new ArrayList<>();

	/**
	 * Method to adds a resource to the library.
	 */
	public void addResource(Resource resource) {
		resources.add(resource);}
	

	/**
	 * Retrieves the list of resources in the library.
	 *
	 * Return a list containing all the resources in the library.
	 */
	public ArrayList<Resource> getResources() {
		return resources;}
	
//set the list of resources
	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;}
	

	@Override//Method return list conains items with specific title 
	public ArrayList<Resource> searchByTitle(String title) {
		ArrayList<Resource> list = new ArrayList<Resource>();
		for (Resource resource : resources) {
			if (resource instanceof Item) {
				Item item = (Item) resource;//down cast
				if (item.getTitle().equalsIgnoreCase(title)) {
					list.add(item);}
				
			}
		}
		return list;}
	

	@Override
	public ArrayList<Resource> searchByAuthor(String author) {
		ArrayList<Resource> list = new ArrayList<Resource>();
		for (Resource resource : resources) {
			if (resource instanceof Item) {
				Book book = (Book) resource;//down cast to Book 
				if (book.getAuthor().equals(author)) {
					list.add(book);}
				
			}
		}
		return list;
	}

	@Override
	public ArrayList<Resource> searchByPublicationDate(String publicationDate) {
		ArrayList<Resource> list = new ArrayList<Resource>();
		for (Resource resource : resources) {
			if (resource instanceof Item) {
				Item item = (Item) resource;
				if (item.getPublicationDate().equalsIgnoreCase(publicationDate)) {
					list.add(item);}
				
			}
		}
		return list;
	}

	@Override
	public ArrayList<Resource> searchByGenre(Genre genre) {
		ArrayList<Resource> list = new ArrayList<Resource>();
		for (Resource resource : resources) {
			if (resource instanceof Item) {
				Book book = (Book) resource;
				if (book.getGenre().equals(genre)) {
					list.add(book);}
				
			}
		}
		return list;
	}

	/**
	 * Method that find a resource by its ID.
	 *
	 * Each resource has resourceId we are going to search about.
	 * Return The found resource, or null if not found.
	 */ 
	public  Resource findResourceById(int resourceId) {
		for (Resource resource : resources) {//search in the ArrayList resources
			if (resource.getResourceId() == resourceId) {// return resourceid and check if =
				return resource;}
			
		}System.out.println("Opps Not found resource!!!")  ;
		return null;
	}

}
