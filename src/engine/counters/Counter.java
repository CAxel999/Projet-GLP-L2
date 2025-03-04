package engine.counters;

import config.GameConfiguration;

public class Counter implements Counting {
	private double value;

	public Counter(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Counter [value=" + value + "]";
	}

	public void reset() {
		value = 0;
	}

	public double getValue() {
		return value;
	}

	protected void setValue(double value) {
		this.value = value;
	}

	public void increment() throws LimitReachedException {
		value += GameConfiguration.CAR_ROTATION;
	}

	public void decrement() throws LimitReachedException {
		if (value > 0) {
			value -= GameConfiguration.CAR_ROTATION;
		} else {
			throw new LimitReachedException();
		}
	}

	public void init() {
		value = 0;
	}

}
