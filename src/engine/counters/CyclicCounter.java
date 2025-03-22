package engine.counters;

import config.CarConfiguration;

public class CyclicCounter extends BoundedCounter implements Counting {

	public CyclicCounter(double value, double max) {
		super(value, max);
	}

	@Override
	public void increment() throws LimitReachedException {
		if (getValue() < getMax()- CarConfiguration.CAR_ROTATION) {
			super.increment();
		} else {
			setValue((CarConfiguration.CAR_ROTATION - (getMax() - getValue())));
			throw new LimitReachedException();
		}
	}

	@Override
	public void decrement() throws LimitReachedException {
		if (getValue() > CarConfiguration.CAR_ROTATION) {
			super.decrement();
		} else {
			setValue(getMax()-(CarConfiguration.CAR_ROTATION - getValue()));
			throw new LimitReachedException();
		}
	}

}
