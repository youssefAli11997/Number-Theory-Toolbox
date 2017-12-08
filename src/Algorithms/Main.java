package Algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import Algorithms.CRT;

public class Main {
	public static void main(String [] args) {
		BigInteger A = new BigInteger("973");
		BigInteger B = new BigInteger("678");
		List<BigInteger> mi_s = new ArrayList<BigInteger>();
		System.out.println("A1 : " + A);
		System.out.println("A2 : " + B);
		mi_s.add(new BigInteger("37"));
		mi_s.add(new BigInteger("49"));
		System.out.print("mi_s : ");
		for(BigInteger x : mi_s)
			System.out.print(x+ " , ");
		System.out.println();
		List<BigInteger> mapping = CRT.getMapping(A, mi_s);
		List<BigInteger> mapping_1 = CRT.getMapping(B, mi_s);
		BigInteger res = CRT.execute(A, B, mi_s, '+');
		List<BigInteger> mapping_2 = CRT.getMapping(res, mi_s);
		System.out.print("A1 : ");
		for(BigInteger x : mapping)
			System.out.print(x + " , ");
		System.out.println();
		System.out.print("A2 : ");
		for(BigInteger x : mapping_1)
			System.out.print(x + " , ");
		System.out.println();
		System.out.print("A_Res : ");
		for(BigInteger x : mapping_2)
			System.out.print(x + " , ");
		System.out.println();
		System.out.println("Result : " + res);
	}
}
