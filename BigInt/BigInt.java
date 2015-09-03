import java.util.ArrayList;


public class BigInt  implements Comparable<BigInt>{

	private ArrayList<Integer> num = new  ArrayList<Integer>();
	private Boolean sign;
	private String numString;

	public boolean getSign(){
		return sign;
	}
	
	private BigInt(ArrayList<Integer> num, Boolean sign ) {
		
		String numString = ""; 
		
		if (sign){
			numString+="+";
		}
		else {
			numString+="-";
		}
		
		//System.out.println("You entered char: "+ num.toString());

		
		if (num.size()>0)
			num = removeLeadingZeros(num); 
		
		for (int i = num.size()-1; i >=0; i--) {
			numString+=num.get(i).toString();
			
		}

		this.num = num; 
		this.sign = sign; 
		this.numString = numString; 
		
	}
	
	private ArrayList<Integer> removeLeadingZeros(ArrayList<Integer> num) {
				
		
		while ( (num.get(num.size()-1)==0) && (num.size()>1)) {

			num = removeLeadingZero(num);
		}
	
		return num; 
	}
	
	private ArrayList<Integer> removeLeadingZero(ArrayList<Integer> num) {
		
		num.remove(num.size()-1);
		
		return new ArrayList<Integer>(num);
		
	}

	public BigInt(String str) {
				
		// check null
		if (str ==null) {
			// error message
			throw new IllegalArgumentException("Null number");		
		}

		// check if there is a sign and a number 
		if (str.length()<2) {
			// error message
			throw new IllegalArgumentException("Number has to have a sign and number");		
		}


		getSign(str.charAt(0));


		for (int i=str.length()-1; i>=1; i--) {
			Character digitChar = str.charAt(i);
		   
			
			if (Character.isDigit(digitChar)) {
				num.add(Integer.parseInt(digitChar.toString()));
				//System.out.println("You entered char: "+ digitChar);
			}
			else 
				throw new IllegalArgumentException("A number can only be composed from digits.");		
		}

		//System.out.println("You entered char: "+ num.toString());
		//  save the string 
		numString = str; 
	}

	@Override public String toString() {
		return numString; 
	}

	@Override
	public boolean equals(Object obj) {	

		if (obj==null)
			return false;

		if (!(obj instanceof BigInt)) 
			return false; 

		BigInt bigInt = (BigInt) obj; 

		if (bigInt.numString.equals(numString))
			return true;
		else 
			return false; 	
	}

	private int absCompareTo(BigInt bigInt1, BigInt bigInt2) {
		
		if (bigInt1.num.size()!=bigInt2.num.size())
			return ((Integer)bigInt1.num.size()).compareTo((Integer)bigInt2.num.size());
		else {
			for (int i=bigInt1.num.size()-1;i>=0;i--) {
				if (!bigInt1.num.get(i).equals(bigInt2.num.get(i))) {
					return bigInt1.num.get(i).compareTo(bigInt2.num.get(i));
				}
			}
			// equals
			return 0;
		}	
	}
	
	
	
	@Override
	public int compareTo(BigInt bigInt) {

		// if both are equal 
		if (this.equals(bigInt))
			return 0;

		// if they have different sign, one is different than the other 
		if (sign!=bigInt.sign) 
			// TBD: check zero 
			return sign.compareTo(bigInt.sign);

		// if both are positive sign 
		if (sign) {
			return absCompareTo(this,bigInt);

		}	
		// if both are positive sign 
		else {

			return absCompareTo(bigInt,this);
		}

	}

	private void getSign(char c) {

		if (c == '+') {
			sign= true; 	
		}
		else if (c == '-') {
			sign =false; 

		}
		else {
			throw new IllegalArgumentException("Please use a + or minus sign");		
		}
	}

	public BigInt plus(BigInt bigInt) {
		
		ArrayList<Integer> newNum;
		boolean newSign;
		int thisBigIntGreater = absCompareTo(this,bigInt);
		
		
		if (sign==bigInt.sign) {
			
			newNum = plus2BigInts(this, bigInt);
			newSign = sign; 
		}
		else {
			if (thisBigIntGreater==0) {
				return new BigInt("+0");
			}
			else if (thisBigIntGreater==1) {
				newSign=sign; 
			}
			else {
				newSign = bigInt.sign;
			}
			
			newNum = minus2BigInts(this, bigInt);
			
		}
		
		return new BigInt(newNum,newSign); 
		
	}
	
	
	
	public BigInt minus(BigInt bigInt) {
		
		ArrayList<Integer> newNum;
		boolean newSign;
		int thisBigIntGreater = absCompareTo(this,bigInt);

		if (sign!=bigInt.sign) {
			
			newNum = plus2BigInts(this, bigInt);
			newSign = sign; 
		}
		else {
			
			if (thisBigIntGreater==0) {
				return new BigInt("+0");
			}
			else if (thisBigIntGreater==1) {
				newSign=sign; 
			}
			else {
				newSign = !sign;
			}
			newNum = minus2BigInts(this, bigInt);

		}
		
		return new BigInt(newNum,newSign); 

	}
	
	
	
	private ArrayList<Integer> plus2BigInts(BigInt bigInt1,BigInt bigInt2) {

		int carry=0; 
		int digit1;
		int digit2;
		int sum; 
		ArrayList<Integer> newNum = new ArrayList<Integer>();

		for (int i=0; i<Math.min(bigInt1.num.size(), bigInt2.num.size()); i++) {

			digit1=bigInt1.num.get(i);
			digit2=bigInt2.num.get(i);
			sum=digit1+digit2+carry;	

			if (sum<10) {
				newNum.add(sum);
				carry=0;
			}
			else {
				newNum.add(sum%10);
				carry=1;
			}

		}		

		// numbers with same length should not get to here. e.g: (i=5 and i<5) 
		for (int i=Math.min(bigInt1.num.size(), bigInt2.num.size()); i<Math.max(bigInt1.num.size(), bigInt2.num.size()); i++) {

			digit1=(bigInt1.num.size()>bigInt2.num.size())?bigInt1.num.get(i):bigInt2.num.get(i);


			sum=digit1+carry;	

			if (sum<10) {
				newNum.add(sum);
				carry=0;
			}
			else {	
				newNum.add(sum%10);
				carry=1;
			}
		}		

		if (carry>0)
			newNum.add(carry);
		
		return newNum;
	}


	private ArrayList<Integer> minus2BigInts(BigInt bigInt1,BigInt bigInt2) {

		int carry=0; 
		int digit1;
		int digit2;
		int sum;
		int bigIntIsGreater = absCompareTo(bigInt1,bigInt2);
		ArrayList<Integer> newNum = new ArrayList<Integer>();

		for (int i=0; i<Math.min(bigInt1.num.size(), bigInt2.num.size()); i++) {

			digit1 = (bigIntIsGreater==1)?bigInt1.num.get(i):bigInt2.num.get(i);
			digit2 = (bigIntIsGreater==1)?bigInt2.num.get(i):bigInt1.num.get(i);

			sum=digit1-digit2-carry;	

			if (sum>=0) {
				newNum.add(sum);
				carry=0;
			}
			else {
				newNum.add(sum+10);
				carry=1;
			}

		}		

		for (int i=Math.min(bigInt1.num.size(), bigInt2.num.size()); i<Math.max(bigInt1.num.size(), bigInt2.num.size()); i++) {

			digit1=(bigInt1.num.size()>bigInt2.num.size())?bigInt1.num.get(i):bigInt2.num.get(i);


			sum=digit1-carry;	

			if (sum>=0) {
				newNum.add(sum);
				carry=0;
			}
			else {
				newNum.add(sum+10);
				carry=1;
			}
		}

		//TBD: remove a zero from the start (end) of the number 
		return newNum;
	}

	private boolean isZero() {
		
		if ((num.size()==1) && (num.get(0)==0))
			return true;
		else 
			return false; 
			
	}
	
	public BigInt multiply(BigInt bigInt){
		boolean newSign; 
		
		//BigInt bigIntMul = new BigInt("+0"); 
		BigInt bigIntMul = new BigInt("+0"); 
		BigInt bigIntTemp = new BigInt("+0"); 
		// TBD: check zero 
		if (isZero() || bigInt.isZero())
			return new BigInt("+0");
		
		if (sign==bigInt.sign) 
			newSign = true;
		else
			newSign = false;

		
		for (int i=0; i<num.size(); i++) {
			for (int j=0; j<bigInt.num.size(); j++) {
				ArrayList<Integer> newNumMul = new ArrayList<Integer>();
				for (int k=0;k<i+j;k++){
					newNumMul.add(0);
				}
				
				bigIntTemp = multiplyDigit(newNumMul,num.get(i),bigInt.num.get(j));
				bigIntMul = bigIntMul.plus(bigIntTemp);
				
			}	
		}
		
		return new BigInt(bigIntMul.num,newSign);
		
	}
	
	
	private BigInt multiplyDigit(ArrayList<Integer> newNumMul, Integer digit1, Integer digit2) {
		
		int result = digit1*digit2;
		
		while (result>0) {
			newNumMul.add(result%10);
			result=result/10;
		}
		
		return new BigInt(newNumMul,true);
	}
	
	
	public BigInt divide(BigInt bigInt){
		
		if  (bigInt.isZero()) 
			throw new IllegalArgumentException("Can't Divide In ZERO!");		

		
		boolean newSign; 
		
		BigInt bigIntDiv1 = new BigInt(num, true); 
		BigInt bigIntDiv2 = new BigInt(bigInt.num, true); 
		BigInt bigIntOne = new BigInt("+1");
		BigInt bigIntResult = new  BigInt("-1");
		
		int bigIntIsGreater = absCompareTo(this,bigInt);

		// TBD: check zero 
		if (isZero())
			return new BigInt("+0");
		
		if (sign==bigInt.sign) 
			newSign = true;
		else
			newSign = false;
		
		if (bigIntIsGreater==-1)
			return new BigInt("+0");
	
		else if (bigIntIsGreater==-1) {
			ArrayList<Integer> one = new ArrayList<Integer>();
			one.add(1);
			return new BigInt(one,newSign);
		}
		

		while (bigIntDiv1.sign){
			bigIntDiv1 = bigIntDiv1.minus(bigIntDiv2);
			bigIntResult = bigIntResult.plus(bigIntOne);
			
		} 
		
		
		
		return new BigInt(bigIntResult.num,newSign);
		
	}
		
	
}
