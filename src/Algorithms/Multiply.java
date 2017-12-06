package Algorithms;

public class Multiply  implements Operation{
	private final static char REPRESENTATION = '*';
	@Override
	public int execute(int element1, int element2) {
		return element1 * element2;
	}

	@Override
	public boolean isOperator(char operator) {
		return operator == REPRESENTATION;
	}

	@Override
	public Operation clone() {
		return new Multiply();
	}

}
