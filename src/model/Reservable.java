package model;

/**
 * The Reservable interface defines the methods for reserving and unreserving a
 * resource in a library.
 */
public interface Reservable {

    /**
     * Reserves the resource, marking it as reserved.
     */
    void reserve();

    /**
     * Unreserves the resource, marking it as not reserved.
     */
    void unreserve();
}
