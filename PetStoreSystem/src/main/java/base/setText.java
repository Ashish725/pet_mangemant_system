package base;




class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}


public class setText {
 
 public static void main(String args[])
 {
     try {
         // any block of code 
         throw new MyException();
     }
     catch (MyException ex) {
         System.out.println("Caught");
         System.out.println(ex.getMessage());
     }
 }
}
