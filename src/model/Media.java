package model;

/**
 * The Media class that represents a media resource in a
 * library. It extends the Item class, providing a common base for various types
 * of media resources. It includes attributes such as format and size.
 */
public class Media extends Item { 
    private String format;
    private double size;

    /**
     * Constructs a Media object with the specified attributes.
     *
     * resourceId The unique identifier of the media resource.
     *  title The title of the media resource.
     *  publicationDate The publication date of the media resource.
     *  format The format of the media resource.
     *  size The size of the media resource.
     */
    public Media(int resourceId, String title, String publicationDate, String format, double size) {
        super(resourceId, title, publicationDate);
        this.format = format;
        this.size = size;}
    

    /**
     * Gets the format of the media resource.
     *
     * return The format of the media resource.
     */
    public String getFormat() {
        return format;}
    

    /**
     * Gets the size of the media resource.
     *
     * return The size of the media resource.
     */
    public double getSize() {
        return size;}


	@Override
	public String toString() {
		return "Media [format=" + format + ", size=" + size + "]";
	}
    
    
}
