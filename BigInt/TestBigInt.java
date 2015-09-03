import java.util.Scanner;

class TestBigInt {
   public static void main(String args[]) {

      String str,str2;
 
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
 
      System.out.println("Enter a string");
      str = in.nextLine();
      System.out.println("You entered string "+ str);
 
      System.out.println("Enter a string");
      str2 = in.nextLine();
      System.out.println("You entered string "+ str2);
      
      BigInt bigInt = new BigInt(str);
      BigInt bigInt2 = new BigInt(str2);
      
      //BigInt result = bigInt.plus(bigInt2);
      
      System.out.println(str + " + " + str2 + " = " + bigInt.plus(bigInt2).toString());
      System.out.println(str + " - " + str2 + " = " + bigInt.minus(bigInt2).toString());
      System.out.println(str + " * " + str2 + " = " + bigInt.multiply(bigInt2).toString());
      System.out.println(str + " / " + str2 + " = " + bigInt.divide(bigInt2).toString());
      //System.out.println(str + " - " + str2 + " = " + bigInt.minus(bigInt2).toString());

      
   }
}
