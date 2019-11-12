package com.data.model;

import java.sql.Date;

public class Message {
	int id;
	int sender_id;
	int receiver_id;
	String content;
	Date read_at;
	Date created_at;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the sender_id
	 */
	public int getSender_id() {
		return sender_id;
	}

	/**
	 * @param sender_id the sender_id to set
	 */
	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	/**
	 * @return the receiver_id
	 */
	public int getReceiver_id() {
		return receiver_id;
	}

	/**
	 * @param receiver_id the receiver_id to set
	 */
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the read_at
	 */
	public Date getRead_at() {
		return read_at;
	}

	/**
	 * @param read_at the read_at to set
	 */
	public void setRead_at(Date read_at) {
		this.read_at = read_at;
	}

	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [id=" + id + ", sender_id=" + sender_id + ", receiver_id=" + receiver_id + ", content="
				+ content + ", read_at=" + read_at + ", created_at=" + created_at + "]";
	}
	
	
}
