/**
 * 
 */
package com.classes;

/**
 * @author Allianz3076
 *
 */
public class Date {

	protected int date, month, year;

	/**
	 * @param date
	 * @param month
	 * @param year
	 */
	public Date(int date, int month, int year) {
		setDate(date);
		setMonth(month);
		setYear(year);
	}

	/**
	 * @return the date
	 */
	public int getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	public boolean isAfter(Date date) {
		if (this.getYear() > date.getYear())
			return true;
		else if (this.getYear() == date.getYear() && this.getMonth() > date.getMonth())
			return true;
		else if (this.getMonth() == date.getMonth() && this.getDate() > date.getDate())
			return true;
		else
			return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Date) || this == obj)
			return false;

		Date date = (Date) obj;
		return (this.getYear() == date.getYear() && this.getMonth() == date.getMonth()
				&& this.getDate() == date.getDate());
	}

	public boolean isBefore(Date date) {
		return (!this.isAfter(date) && !this.equals(date));
	}
}
