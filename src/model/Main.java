package model;

public class Main {

	public static void main(String[] args) {
		Library library=new Library();//resources
		
		
		Book b1=new Book(0, null, null, null, null, 0);
		library.addResource(b1);

	}

}
