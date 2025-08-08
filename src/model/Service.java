package model;

/**
 * The Service class represents a service that can be reserved and unreserved.
 */
public class Service extends Resource {
	private String name;
	private double cost;

	/**
	 * Constructs a new Service with the specified resource ID, name, and cost.
	 *
	 *  resourceId The unique identifier for the service.
	 *  name       The name of the service.
	 *  cost       The cost associated with the service.
	 */
	public Service(int resourceId, String name, double cost) {
		super(resourceId);
		this.name = name;
		this.cost = cost;}
	

	/**
	 * Gets the name of the service.
	 *
	 * return The name of the service.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the cost associated with the service.
	 *
	 * return The cost of the service.
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Returns a string representation of the service.
	 *
	 * return A string representation of the service.
	 */
	@Override
	public String toString() {
		return "Service{" + "resourceId=" + getResourceId() + ", name='" + name + '\'' + ", cost=" + cost
				+ ", reserved=" + isReserved() + '}';}
	
}
