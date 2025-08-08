package model;
/**
 * The Borrowable interface implemented by item so that item can be borrowed
 * and returned. All items implementing this interface must provide
 * implementations for the checkout and returnItem methods.
 */
public interface Borrowable {

    /**
     * checkout operation for a borrowable item. Implementing
     * classes should handle the logic for checking out the item.
     */
    void checkout();//item have taken

    /**
     * return operation for a borrowable item. Implementing classes
     * should handle the logic for returning the item.
     */
    void returnItem();
}
