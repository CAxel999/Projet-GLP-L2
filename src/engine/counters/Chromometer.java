package engine.counters;

public class Chromometer {
	private Counting hour;
	private Counting minute;
	private Counting second;

	public Chromometer() {
		hour = new CyclicCounter(0, 23);
		minute = new CyclicCounter(0, 59);
		second = new CyclicCounter(0, 59);
	}

	public Counting getHour() {
		return hour;
	}

	public Counting getMinute() {
		return minute;
	}

	public Counting getSecond() {
		return second;
	}

	public void increment() {
		try {
			second.increment();
		} catch (LimitReachedException e) {
			if (second.getValue() == 0) {
				try {
					minute.increment();
				} catch (LimitReachedException e1) {
					if (minute.getValue() == 0) {
						try {
							hour.increment();
						} catch (LimitReachedException e2) {
							System.err.println("Chronometer's limit has been reached !");
						}
					}
				}
			}
		}
	}

	public void decrement() {
		try {
			second.decrement();
		} catch (LimitReachedException e) {
			if (second.getValue() == 59) {
				try {
					minute.decrement();
				} catch (LimitReachedException e1) {
					if (minute.getValue() == 59) {
						try {
							hour.decrement();
						} catch (LimitReachedException e2) {
							System.err.println("Chronometer's has been reset !");
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Chromometer [hour=" + hour.getValue() + ", minute=" + minute.getValue() + ", second="
				+ second.getValue() + "]";
	}

}
