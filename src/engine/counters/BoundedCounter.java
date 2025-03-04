package engine.counters;

public class BoundedCounter extends Counter implements Counting {
	private double max;

	public BoundedCounter(double value, double max) {
		super(value);
		this.max = max;
	}

	@Override
	public void increment() throws LimitReachedException{
		if (getValue() < max) {
			super.increment();
		} else {
			throw new LimitReachedException();
		}
	}

	public double getMax() throws LimitReachedException{
		return max;
	}

}
