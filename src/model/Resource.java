package model;

import java.io.Serializable;

/**
 * The Resource class represents a general resource in a library.
 */
public abstract class Resource implements Reservable, Serializable {

	/**
	 * The unique identifier for the resource.
	 */
	private int resourceId;

	/**
	 * Boolean indicating whether the resource is currently reserved.
	 */
	private boolean reserved;

	/**
	 * Constructs a new Resource with the specified resource ID.
	 *
	 * resourceId The unique identifier for the resource.
	 */
	public Resource(int resourceId) {
		this.resourceId = resourceId;
		this.reserved = false;}//All resources will have uniqe id + defalt reserved state = false
	

	/**
	 * Gets the resource ID.
	 *
	 * Method return the unique identifier for the resource.
	 */
	public int getResourceId() {
		return resourceId;}
	

	/**
	 * Sets the resource ID.
	 *
	 * Set new resourceId for the resource.
	 */
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;}
	

	/**
	 * Checks if the resource is currently reserved.
	 *
	 * return {true} if the resource is reserved, {false} otherwise.
	 */
	public boolean isReserved() {
		return reserved;}
	

	/**
	 * Sets the reserved status of the resource.
	 *
	 * set reserved to { true} to mark the resource as reserved, {false} otherwise.
	 *                 
	 */
	public void setReserved(boolean reserved) {
		this.reserved = reserved;}
	

	/**
	 * Reserves the resource, marking it as reserved.
	 */
	public void reserve() {
		if (!reserved) {//if false
			reserved = true;
			System.out.println("Resource reserved: " + getResourceId());
		} else {
			System.out.println("Resource is already reserved: " + getResourceId());}
		
	}

	/**
	 * Releases the resource, marking it as not reserved.
	 */
	public void unreserve() {
		if (reserved) {//if true
			reserved = false;
			System.out.println("Resource released: " + getResourceId());
		} else {
			System.out.println("Resource is not reserved: " + getResourceId());}
		
	}
}
