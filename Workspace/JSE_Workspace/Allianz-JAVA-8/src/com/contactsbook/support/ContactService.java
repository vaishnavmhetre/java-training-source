/**
 * 
 */
package com.contactsbook.support;

import java.util.List;

import com.contactsbook.contract.ContactServiceContract;
import com.contactsbook.model.Contact;
import com.contactsbook.model.ContactList;

/**
 * @author Allianz3076
 *
 */
public class ContactService implements ContactServiceContract {

	protected ContactList listContact;

	public ContactService(int capacity) {
		setContacts(new ContactList());
	}

	/**
	 * @return the contacts
	 */
	public ContactList getContacts() {
		return listContact;
	}

	/**
	 * @param contacts
	 *            the contacts to set
	 */
	public void setContacts(ContactList contacts) {
		this.listContact = contacts;
	}

	@Override
	public boolean addContact(Contact contact) {
		return listContact.add(contact);
	}

	@Override
	public Contact deleteContact(int phoneNumber) {
		for (int iter = 0; iter <= listContact.size(); iter++)
			if (listContact.get(iter).getPhoneNumber() == phoneNumber)
				return listContact.remove(iter);
		return null;
		// return listContact.removeIf((Contact contact) -> (contact.getPhoneNumber() ==
		// phoneNumber));
	}

	@Override
	public Contact findContact(int phoneNumber) {
		for (Contact contact : listContact)
			if (contact.getPhoneNumber() == phoneNumber) {
				return contact;
			}

		return null;
	}

	@Override
	public List<Contact> listAll() {
		return listContact;
	}

}
