package Q1;

public class SumThread implements Runnable { 	

	RandomNumbersStack stack; 
		
	public SumThread (RandomNumbersStack stack) {
		this.stack = stack;
	}
	
	public void run() {
		
		while (true) {
			TwoNumbers twoNumbers = stack.getTwoNumbersFromStack();
		
			// null returned means stop the thread 
			if (twoNumbers==null)
				break; 			

			int summedNum = twoNumbers.addNumbers(); 
			
			stack.addSummedNumberToStack(summedNum);
						
		}
		
		
	} // end run
	
} 