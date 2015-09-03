package Q1;

import java.util.ArrayList;
import java.util.Scanner;

public class SumWithThreads {	

	static private RandomNumbersStack randomNumbersStack;
	private ArrayList<Thread> threadArr; 


	public SumWithThreads(int numberOfElements, int numberOfThreads) { 

		randomNumbersStack = new RandomNumbersStack(numberOfElements);
		threadArr = new ArrayList<Thread>(numberOfThreads); 

		for (int i=0; i<numberOfThreads; i++) {
			threadArr.add(new Thread( new SumThread(randomNumbersStack)));
			//SumThread sumThread = new SumThread(randomNumbersStack);; 
		}	


		for (int i=0; i<numberOfThreads; i++) {
			threadArr.get(i).start(); 
		}
			

	}


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int numberOfElements, numberOfThreads;
		System.out.println("Enter a Positive number for Elements size");
		numberOfElements = in.nextInt();
		
		if (numberOfElements<1) {
			System.out.println("Not a Positive number!");
			System.exit(0);
		}
		
		System.out.println("Enter a Positive number for Thread Number");
		numberOfThreads = in.nextInt();
		
		if (numberOfThreads<1) {
			System.out.println("Not a Positive number!");
			System.exit(0);
		}
		
		new SumWithThreads(numberOfElements, numberOfThreads); 

	}




}



