package Algorithms;

import java.math.BigInteger;

public class Subtract implements Operation{
	private final static char REPRESENTATION = '-';
	@Override
	public BigInteger execute(BigInteger element1, BigInteger element2) {
		return element1.subtract(element2);
	}

	@Override
	public boolean isOperator(char operator) {
		return operator == REPRESENTATION;
	}

	@Override
	public Operation clone() {
		return new Subtract();
	}

}
