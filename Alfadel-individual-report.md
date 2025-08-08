# Individual Report
 
 
## Worklog



###2023-11-22

Created inetrface "Searchable" that defines methods to search for resources by different criteria.
- Methods: searchByTitle( String ), searchByAuthor( String ), searchByGenre( Genre ), searchByPublicationDate( String )

###2023-11-23

Created class "Library" that represents a collection of resources, it has methods to add Resources to the Library 
and retrieve the list of Resources and it implements Searchable.

- Attributes: ArrayList of resources
- methods: searchByTitle( String ), searchByAuthor( String ), searchByGenre( Genre ), searchByPublicationDate( String ), 
addResource( Resource ), getResource(), setResource( ArrayList<Resource> ), findResourceById( int )
- implements searchable interface 

###2023-11-24

Created class "Service" represents a service that can be reserved and unreserved.
- Attributes: name,cost
- Methods: getName(), getCost(), toString()
- extends Resources

###Advantage

Advantage 1: Many options to search for the resource through multiple criteria.

###Disadvantages

Disadvantage 2: There were too many functions to add, and a lot of downcasting was required.
