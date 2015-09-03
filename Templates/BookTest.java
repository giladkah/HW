import java.util.Iterator;


public class BookTest {

	public static void main(String[] args) {

		Book book3 = new Book("you", "choofa", new Double(18), 1984);
		Book book2 = new Book("to", "tal", new Double(15), 1988);
		Book book1 = new Book("hello", "mami", new Double(12.3), 2000);
		Book book4 = new Book("hello", "mami", new Double(16), 2004);


		AssociationTable<Book, Double>  associationTable = new AssociationTable<Book, Double>(); 

		associationTable.add(book1, book1.price);
		associationTable.add(book2, book2.price);
		associationTable.add(book3, book3.price);
		associationTable.add(book4, book4.price);

		Iterator<Book> it = associationTable.keyIterator(); 
		
		while (it.hasNext()) {
			Book book = it.next(); 
			System.out.println(book.name + " " + associationTable.get(book) );
			
		}
		
		
	}
	
}
