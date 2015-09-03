import java.util.Iterator;



class Book implements Comparable<Book>{
	String name,authorName;
	int year; 
	Double price; 


	public Book(String name, String authorName, Double price, int year) {

		this.name=name;
		this.authorName=authorName;
		this.year=year; 
		this.price=price;
	}

	@Override
	public int compareTo(Book other){
		int last = this.name.compareTo(other.name);
		return last == 0 ? this.authorName.compareTo(other.authorName) : last;
	}

}