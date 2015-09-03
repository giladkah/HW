package Q1;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.*; 
	
public class RandomNumbersStack {

	private Stack<Integer> stack; 
	
	private int elementNum =0 ;
	 private Lock lock = new ReentrantLock(); 
	 
	 	
	public RandomNumbersStack(int elementNum) {
		
		stack = new Stack<Integer>(); 
		
		for(int i=0; i<elementNum; i++){
			stack.push(randInt(1,100));
       }		
		
		int sum=0;
		for(int i=stack.size()-1; i>=0; i--){
			System.out.println("START: " + stack.get(i)) ;
			sum+=stack.get(i); 
       }
		
		System.out.println("SUM IS : " + sum) ;

		
		this.elementNum = elementNum;

	}
	
	public static int randInt(int min, int max) {	

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public TwoNumbers getTwoNumbersFromStack() {

		// lock the object
		lock.lock(); 

		try {
			
			long threadId = Thread.currentThread().getId();
			System.out.println("THREAD : " + threadId + " Getting 2 Numbers. Element Num: " + elementNum) ;
			printStack(); 

			// if elements in stack is smaller than 2 (1 or zero) return null and thread will stop
			if (elementNum<2) 
				return null; 
			
			// return 2 numbers and decrease elements number by 2.  
			elementNum-=2;
			return new TwoNumbers(stack.pop(), stack.pop());

		} finally {
			lock.unlock();
		} 


	}

	public void addSummedNumberToStack(int summedNum) {
		
		// lock the object
		lock.lock(); 

		try {
			long threadId = Thread.currentThread().getId();
			System.out.println("THREAD : " + threadId + " Adding Summed Number. Element Num: " + elementNum) ;
			
			elementNum++;
			
			// return 2 numbers and decrease elements number by 2.  
			stack.push(summedNum);

		} finally {
			lock.unlock();
		} 
	}
	
	public void printStack() {
		long threadId = Thread.currentThread().getId();
		System.out.println(" THREAD ::: " + threadId) ;

		for(int i=stack.size()-1; i>=0; i--){
			System.out.println("threadId: " + threadId + " num is: " + stack.get(i)) ;
       }	
	}
	

	
}
