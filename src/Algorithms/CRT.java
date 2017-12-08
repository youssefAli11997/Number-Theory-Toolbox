package Algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CRT {
	static {
		initSupportedOperations();
	}
	private static List <Operation> supportedOperations ;
	private static void initSupportedOperations() {
		supportedOperations = new ArrayList<>();
		supportedOperations.add(new Add());
		supportedOperations.add(new Subtract());
		supportedOperations.add(new Multiply());
	}
	public static BigInteger execute(BigInteger number1 , BigInteger number2  , List<BigInteger> mi_s , char operation) {
		Operation currentOperation = getOperation(operation);
		List<BigInteger> map_number1 = getMapping(number1 , mi_s);
		List<BigInteger> map_number2 = getMapping(number2, mi_s);
		List<BigInteger> result = new ArrayList<>();
		for(int i = 0 ; i < mi_s.size() ; i ++)
			result.add(currentOperation.execute(map_number1.get(i), map_number2.get(i)).mod(mi_s.get(i)));
		BigInteger finalResult = deMap(result , mi_s);
		return finalResult ;
	}
	
	public static BigInteger deMap(List<BigInteger> result, List<BigInteger> mi_s) {
		BigInteger M = new BigInteger("1") ;
		for(BigInteger mi : mi_s) {
			M = M.multiply(mi);
		}
		List<BigInteger> Mi_s = new ArrayList<>();
		for(BigInteger mi : mi_s) {
			Mi_s.add(M.divide(mi));
		}
		List<BigInteger> Mi_s_Inverse = new ArrayList<>();
		for(int i = 0 ; i < Mi_s.size() ; i ++) {
			Mi_s_Inverse.add(ExtendedEuclid.moduleInverse(Mi_s.get(i),mi_s.get(i)));
		}
		BigInteger finalResult = new BigInteger("0") ;
		for(int i = 0 ; i < result.size() ; i ++) {
			finalResult = finalResult.add(result.get(i).multiply(Mi_s.get(i).multiply(Mi_s_Inverse.get(i))));
		}
		return finalResult.mod(M);
	}
	public static List<BigInteger> getMapping(BigInteger number1, List<BigInteger> mi_s) {
		List<BigInteger> mapped = new ArrayList<>();
		for(int i = 0 ; i < mi_s.size() ; i ++)
			mapped.add(number1.mod(mi_s.get(i)));
		return mapped;
	}
	public static BigInteger execute(BigInteger number1 , BigInteger number2  , BigInteger M , char operation) {
		return getOperation(operation).execute(number1, number2).mod(M) ;
	}
	
	private static Operation getOperation (char operation) {
		for(Operation supported : supportedOperations)
			if(supported.isOperator(operation))
				return supported.clone();
		return null ;
	} 
}
