package stack;

public interface IStack1 <T> {
	void push(T e);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
}
