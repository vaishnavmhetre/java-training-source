package com.classes;

public class DateTime {
	protected Date date;
	protected Time time;

	/**
	 * @param date
	 * @param time
	 */
	public DateTime(Date date, Time time) {
		setDate(date);
		setTime(time);
	}

	/**
	 * @param date
	 * @param time
	 */
	public DateTime(int date, int month, int year, int hour, int minute, int second) {
		setDate(new Date(date, month, year));
		setTime(new Time(hour, minute, second));
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	public boolean isAfter(DateTime dateTime) {
		if (this.getDate().isAfter(dateTime.getDate()))
			return true;
		else if (this.getDate().equals(dateTime.getDate()) && this.getTime().isAfter(dateTime.getTime()))
			return true;
		else
			return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof DateTime) || this == obj)
			return false;
		DateTime datetime = (DateTime) obj;
		return (this.getDate().equals(datetime.getDate()) && this.getTime().equals(datetime.getTime()));
	}
	
	public boolean isBefore(DateTime dateTime) {
		return (!this.isAfter(dateTime) && !this.equals(dateTime));
	}

	public static void main(String[] args) {
		DateTime dateTimeOld = new DateTime(2, 5, 2004, 20, 54, 32);
		DateTime dateTimeNew = new DateTime(new Date(2, 5, 2004), new Time(21, 43, 12));

		System.out.println(dateTimeNew.isAfter(dateTimeOld));
		System.out.println(dateTimeOld.isBefore(dateTimeNew));
		System.out.println(dateTimeOld.equals(dateTimeNew));
	}

}
