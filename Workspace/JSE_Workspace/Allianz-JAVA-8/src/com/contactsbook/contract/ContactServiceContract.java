/**
 * 
 */
package com.contactsbook.contract;

import java.util.List;

import com.contactsbook.model.Contact;

/**
 * @author Allianz3076
 *
 */
public interface ContactServiceContract {
	boolean addContact(Contact contact);

	Contact deleteContact(int phoneNumber);

	Contact findContact(int phoneNumber);

	List<Contact> listAll();
}
