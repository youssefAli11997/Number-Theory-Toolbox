package Operations;

public class ExtendedEuclid {
	private static int x = 0 , y = 0 , d = 0;
	public static void extendedEcuildean(int a , int b) {
		if (b == 0) { x = 1; y = 0; d = a; return; }
		extendedEcuildean(b, a%b);
		int x1 = y ;
		int y1 = x - (a /b) *y ;
		x = x1;
		y = y1;
		return ;
	}
	
	public static int moduleInverse(int a , int n) {
		extendedEcuildean(a, n);
		return x ;
	}
	
	public static void main (String [] args) {
		System.out.println("The Module Inverse of 13 mod 15 is "  + moduleInverse(13, 15) +  "\nAs 13 * " + moduleInverse(13, 15) + " mod 15 = 1");
	}
}
