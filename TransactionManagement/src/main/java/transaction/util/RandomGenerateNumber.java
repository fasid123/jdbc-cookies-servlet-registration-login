package transaction.util;


public class RandomGenerateNumber {

	public static  String generateRandom() {
		//12 digit number 
		//100000000000 - 999999999999
		long accNum = 100000000000L + (long)(Math.random() * 900000000000L);
		return String.valueOf(accNum);
		
	}
}
