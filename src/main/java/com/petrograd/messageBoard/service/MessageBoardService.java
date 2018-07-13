package com.petrograd.messageBoard.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.petrograd.messageBoard.entity.MessageBoard;

public interface MessageBoardService {
	List<MessageBoard> getMessageBoards(Integer start, Integer pageMax, String orderByField, String orderByWay,
			String headlineOrContentFuzzyQuery) throws UnsupportedEncodingException;

	Integer getMessageBoardsCount(String headlineOrContentFuzzyQuery) throws UnsupportedEncodingException;
	
	Integer deleteMessageBoardById(Integer deleteId);
	
	Integer operateMessageBoard(MessageBoard messageBoard);
}
