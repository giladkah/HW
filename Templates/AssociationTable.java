import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;



public class AssociationTable <K extends Comparable<K>,V> {

	private TreeMap<K, V> tm = new TreeMap<K, V>();
	
	public AssociationTable() {
		
		
	}
		
	public AssociationTable(K[] keyArray, V[] valueArray) {
		
		if (keyArray == null || valueArray ==null || keyArray.length != valueArray.length ) {
			System.out.println("Wrong Arguments");
			System.exit(0);
		}
		
		for (int i=0;i<keyArray.length;i++) {
			tm.put(keyArray[i], valueArray[i]);
			
		}
		
	}
	
	
	public void add(K key, V value) {
		
		if (contains(key))
			tm.replace(key, value);
			
			tm.put(key, value);
		
	}
	
	public V get(K key) {
		
		return tm.get(key);
	}
	
	public boolean contains(K key) {
		
		if (tm.containsKey(key))
			return true;
		
		return false; 
		
	}
	
	public boolean remove(K key) {

		if (contains(key)) {
			tm.remove(key);
			return true; 
		}
			
		return false; 
	}
	
	public int size() {
		
		return tm.size(); 
	}
	
	public Iterator<K> keyIterator() {
		
	    Collection<K> c = tm.keySet();
	    Iterator<K> itr = c.iterator();
	    
	    return itr; 
	     
	}
	
	
	
	
//	
//	/**
//	 * List the authors. Sort them by name so it will look good.
//	 */
//	public List<Book> listAuthors(){
//	    List<Book> authors = readAuthorsFromFileOrSomething();
//	    Collections.sort(authors);
//	    return authors;
//	}
//
//	/**
//	 * List unique authors. Sort them by name so it will look good.
//	 */
//	public SortedSet<Book> listUniqueAuthors(){
//	    List<Book> authors = readAuthorsFromFileOrSomething();
//	    return new TreeSet<Book>(authors);
//	}
//	
//	
}
