/**
 * 
 */
package com.data.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.data.dao.support.Dao;
import com.data.model.Message;
import com.data.model.User;
import com.support.database.querybuilder.SqlQueryBuilder;
import com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.support.database.querybuilder.sql.support.SqlQueryCondition;
import com.support.database.querybuilder.sql.support.flags.SqlQueryBuilderFlags;

/**
 * @author Allianz3076
 *
 */
public class MessageDao extends Dao {

	public MessageDao() throws ClassNotFoundException, SQLException {
		super();
		setTableName("messages");
	}

	public List<Message> getMessagesForUserId(int userId) throws SQLException {
		List<Message> messages = new ArrayList<Message>();

		List<SqlQueryCondition> conditions = Arrays.asList(
				new SqlQueryCondition("receiver_id", SqlQueryBuilderFlags.CONDITION_EQUAL, userId),
				new SqlQueryCondition(SqlQueryBuilderFlags.CONDITION_JOINER_OR),
				new SqlQueryCondition("sender_id", SqlQueryBuilderFlags.CONDITION_EQUAL, userId));

		String query = new SqlQueryBuilder(getTableName()).select(null, conditions);

		ResultSet rs = getDatabaseManager().createStatment().executeQuery(query);
		while (rs.next()) {
			Message message = new Message();
			message.setId(rs.getInt("id"));
			message.setSender_id(rs.getInt("sender_id"));
			message.setReceiver_id(rs.getInt("receiver_id"));
			message.setContent(rs.getString("content"));
			message.setCreated_at(rs.getDate("created_at"));
			message.setRead_at(rs.getDate("read_at"));
			messages.add(message);
		}

		return messages;
	}

	public List<Message> getUnreadMessagesForUserId(int userId) throws SQLException {
		List<Message> messages = new ArrayList<Message>();

		List<SqlQueryCondition> conditions = Arrays.asList(
				new SqlQueryCondition("receiver_id", SqlQueryBuilderFlags.CONDITION_EQUAL, userId),
				new SqlQueryCondition(SqlQueryBuilderFlags.CONDITION_JOINER_OR),
				new SqlQueryCondition("sender_id", SqlQueryBuilderFlags.CONDITION_EQUAL, userId),
				new SqlQueryCondition(SqlQueryBuilderFlags.CONDITION_JOINER_AND),
				new SqlQueryCondition("read_at", SqlQueryBuilderFlags.CONDITION_NOT_EQUAL, SqlQueryBuilderFlags.NULL));

		String query = new SqlQueryBuilder(getTableName()).select(null, conditions);

		ResultSet rs = getDatabaseManager().createStatment().executeQuery(query);
		while (rs.next()) {
			Message message = new Message();
			message.setId(rs.getInt("id"));
			message.setSender_id(rs.getInt("sender_id"));
			message.setReceiver_id(rs.getInt("receiver_id"));
			message.setContent(rs.getString("content"));
			message.setCreated_at(rs.getDate("created_at"));
			message.setRead_at(rs.getDate("read_at"));
			messages.add(message);
		}

		return messages;
	}

	public int createMesssageBetweenUser(User sender, User receiver, Message message) throws InvalidQueryBuilderParameter, SQLException {
		List<String> columns = Arrays.asList("sender_id", "receiver_id", "content", "created_at");
		List<Object> values = Arrays.asList(sender.getId(), receiver.getId(), message.getContent(),
				new Date(new java.util.Date().getTime()).toString());
		
		String query = new SqlQueryBuilder(getTableName()).insert(values, columns);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}
	
	public int markAsRead(Message message) throws InvalidQueryBuilderParameter, SQLException {
		
		  Map<String, Object> values = new HashMap<String, Object>();
		  
		  values.put("read_at", new Date(new java.util.Date().getTime()).toString());
		  
		  List<SqlQueryCondition> conditions = Arrays.asList(new
		  SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL,
		  message.getId()));
		  
		  String query = new SqlQueryBuilder(getTableName()).update(values,
		  conditions);
		 
		
		return getDatabaseManager().createStatment().executeUpdate(query);
	}

}