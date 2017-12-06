package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class CRT {
	private static List <Operation> supportedOperations ;
	public CRT() {
		initSupportedOperations();
	}
	private void initSupportedOperations() {
		supportedOperations = new ArrayList<>();
		supportedOperations.add(new Add());
		supportedOperations.add(new Subtract());
		supportedOperations.add(new Multiply());
	}
	public static int execute(int number1 , int number2  , List<Integer> mi_s , char operation) {
		Operation currentOperation = getOperation(operation);
		List<Integer> map_number1 = getMapping(number1 , mi_s);
		List<Integer> map_number2 = getMapping(number2, mi_s);
		List<Integer> result = new ArrayList<>();
		for(int i = 0 ; i < mi_s.size() ; i ++)
			result.add(currentOperation.execute(map_number1.get(i), map_number2.get(i) % mi_s.get(i)));
		int finalResult = deMap(result , mi_s);
		return finalResult ;
	}
	
	private static int deMap(List<Integer> result, List<Integer> mi_s) {
		int M = 1 ;
		for(Integer mi : mi_s) {
			M *= mi;
		}
		List<Integer> Mi_s = new ArrayList<>();
		for(Integer mi : mi_s) {
			Mi_s.add(M/mi);
		}
		List<Integer> Mi_s_Inverse = new ArrayList<>();
		for(int i = 0 ; i < Mi_s.size() ; i ++) {
			Mi_s_Inverse.add(ExtendedEuclid.moduleInverse(Mi_s.get(i),mi_s.get(i)));
		}
		int finalResult = 0 ;
		for(int i = 0 ; i < result.size() ; i ++) {
			finalResult += (result.get(i) * Mi_s.get(i) * Mi_s_Inverse.get(i));
		}
		return finalResult % M;
	}
	private static List<Integer> getMapping(int number1, List<Integer> mi_s) {
		List<Integer> mapped = new ArrayList<>();
		for(int i = 0 ; i < mi_s.size() ; i ++)
			mapped.add(number1 % mi_s.get(i));
		return mapped;
	}
	public static int execute(int number1 , int number2  , int M , char operation) {
		return getOperation(operation).execute(number1, number2) % M ;
	}
	
	private static Operation getOperation (char operation) {
		for(Operation supported : supportedOperations)
			if(supported.isOperator(operation))
				return supported.clone();
		return null ;
	} 
}
