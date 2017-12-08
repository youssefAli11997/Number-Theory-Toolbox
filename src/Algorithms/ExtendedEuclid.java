package Algorithms;

import java.math.BigInteger;

public class ExtendedEuclid {
	private static BigInteger x = new BigInteger("0") , y = new BigInteger("0") , d =new BigInteger("0");
	public static void extendedEcuildean(BigInteger a , BigInteger b) {
		if (b.intValue() == 0) { x = new BigInteger("1"); y = new BigInteger("0"); d = new BigInteger(a.toString()); return; }
		extendedEcuildean(new BigInteger(b.toString()), a.mod(b));
		BigInteger x1 = y ;
		BigInteger y1 = x.subtract(a.divide(b).multiply(y)) ;
		x = x1;
		y = y1;
		return ;
	}
	
	public static BigInteger moduleInverse(BigInteger a , BigInteger n) {
		extendedEcuildean(a, n);
		return x ;
	}
	
	public static void main (String [] args) {
		BigInteger a = new BigInteger("4");
		BigInteger n = new BigInteger("15");
		System.out.println("The Module Inverse of " + a + " mod " + n +" is "  + moduleInverse(a, n) +  "\nAs " + a + " * " + moduleInverse(a, n) + " mod " + n + " = 1");
	}
}
