/**
 * 
 */
package com.data.model;

/**
 * @author Allianz3076
 *
 */
public class User {
	protected int id;
	protected String name;
	protected String address;
	protected long contact;

	public User(int id, String name, String address, long contact) {
		setId(id);
		setName(name);
		setAddress(address);
		setContact(contact);
	}
	
	public User(String name, String address, long contact) {
		setName(name);
		setAddress(address);
		setContact(contact);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

}
