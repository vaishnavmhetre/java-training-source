/**
 * 
 */
package com.classes;

/**
 * @author Allianz3076
 *
 */
public class Time {

	protected int hour, minute, second;

	public Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}

	public boolean isAfter(Time time) {
		if (this.getHour() > time.getHour())
			return true;
		else if (this.getHour() == time.getHour() && this.getMinute() > time.getMinute())
			return true;
		else if (this.getMinute() == time.getMinute() && this.getSecond() > time.getSecond())
			return true;
		else
			return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Time) || this == obj)
			return false;

		Time time = (Time) obj;
		return (this.getHour() == time.getHour() && this.getMinute() == time.getMinute()
				&& this.getSecond() == time.getSecond());
	}

	public boolean isBefore(Time time) {
		return (!this.isAfter(time) && !this.equals(time));
	}

}
