package engine.counters;

public class LimitReachedException extends Exception {
	private static final long serialVersionUID = 1L;

	public LimitReachedException() {
		super("The counter's limit has been reached");
	}

}
