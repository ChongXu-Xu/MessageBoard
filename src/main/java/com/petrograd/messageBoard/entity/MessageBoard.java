package com.petrograd.messageBoard.entity;

import java.util.Date;

public class MessageBoard {
	private Integer id;
	private String headline;
	private String content;
	private String messagePerson;
	private Date messageDate;
	
	public MessageBoard() {
		super();
	}
	public MessageBoard(String headline, String content, String messagePerson, Date messageDate) {
		super();
		this.headline = headline;
		this.content = content;
		this.messagePerson = messagePerson;
		this.messageDate = messageDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMessagePerson() {
		return messagePerson;
	}
	public void setMessagePerson(String messagePerson) {
		this.messagePerson = messagePerson;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
}
