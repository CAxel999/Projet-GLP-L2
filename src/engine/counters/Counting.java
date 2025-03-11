package engine.counters;

public interface Counting {
	void increment() throws LimitReachedException;

	void decrement() throws LimitReachedException;

	double getValue();
}
