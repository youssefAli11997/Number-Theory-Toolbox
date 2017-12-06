package Algorithms;

public interface Operation {
	public int execute(int element1 , int element2);
	public boolean isOperator(char operator);
	public Operation clone();
}
