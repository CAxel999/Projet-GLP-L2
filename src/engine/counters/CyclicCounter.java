package engine.counters;

import config.GameConfiguration;

public class CyclicCounter extends BoundedCounter implements Counting {

	public CyclicCounter(double value, double max) {
		super(value, max);
	}

	@Override
	public void increment() throws LimitReachedException {
		if (getValue() < getMax()- GameConfiguration.CAR_ROTATION) {
			super.increment();
		} else {
			setValue((GameConfiguration.CAR_ROTATION - (getMax() - getValue())));
			throw new LimitReachedException();
		}
	}

	@Override
	public void decrement() throws LimitReachedException {
		if (getValue() > GameConfiguration.CAR_ROTATION) {
			super.decrement();
		} else {
			setValue(getMax()-(GameConfiguration.CAR_ROTATION - getValue()));
			throw new LimitReachedException();
		}
	}

}
