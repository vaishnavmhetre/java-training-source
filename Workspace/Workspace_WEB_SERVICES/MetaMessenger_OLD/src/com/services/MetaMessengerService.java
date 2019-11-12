/**
 * 
 */
package com.services;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.data.dao.MessageDao;
import com.data.dao.UserDAO;
import com.data.model.Message;
import com.data.model.User;
import com.support.auth.AuthenticationManager;
import com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;

/**
 * @author Allianz3076
 *
 */
public class MetaMessengerService {

	public String login(String username, String password)
			throws ClassNotFoundException, SQLException, InvalidQueryBuilderParameter {
		return new AuthenticationManager().login(username, password);
	}

	public boolean register(String name, String username, String password)
			throws ClassNotFoundException, InvalidQueryBuilderParameter, SQLException {

		User user = new User();

		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);

		int status = new UserDAO().createUser(user);

		return status > 0;

	}

	public String[] getAllMessages(String token)
			throws ClassNotFoundException, SQLException, InvalidQueryBuilderParameter {

		User user = new UserDAO().findUserByToken(token);

		List<Message> messages = new MessageDao().getMessagesForUserId(user.getId());

		for (Message message : messages)
			new MessageDao().markAsRead(message);

		return Arrays.stream(messages.toArray()).map(Object::toString).
                toArray(String[]::new);
//		return Arrays.copyOf(messages.toArray(), messages.toArray().length, String[].class);
	}

	public String[] getUnreadMessages(String token)
			throws ClassNotFoundException, SQLException, InvalidQueryBuilderParameter {

		User user = new UserDAO().findUserByToken(token);

		List<Message> messages = new MessageDao().getUnreadMessagesForUserId(user.getId());

		for (Message message : messages)
			new MessageDao().markAsRead(message);

		
		return Arrays.stream(messages.toArray()).map(Object::toString).
                toArray(String[]::new);
//		return Arrays.copyOf(messages.toArray(), messages.toArray().length, String[].class);
	}

	public boolean sendMessage(String token, int userId, String content)
			throws ClassNotFoundException, SQLException, InvalidQueryBuilderParameter {

		User sender = new UserDAO().findUserByToken(token);
		User receiver = new UserDAO().findUserById(userId);
		Message message = new Message();
		message.setContent(content);

		int status = new MessageDao().createMesssageBetweenUser(sender, receiver, message);

		return status > 0;
	}

	
	public String getRandomUser() {
		
		return null;
	}
}
