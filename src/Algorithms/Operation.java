package Algorithms;

import java.math.BigInteger;

public interface Operation {
	public BigInteger execute(BigInteger element1 , BigInteger element2);
	public boolean isOperator(char operator);
	public Operation clone();
}
