package com.petrograd.messageBoard.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.petrograd.messageBoard.dao.MessageBoardMapper;
import com.petrograd.messageBoard.entity.MessageBoard;
import com.petrograd.messageBoard.service.MessageBoardService;
import com.petrograd.messageBoard.util.Iso_8859_1_to_Utf_8_Util;

@Transactional(rollbackFor = Exception.class)
@Service("messageBoardService")
public class MessageBoardServiceImpl implements MessageBoardService {

	@Autowired
	MessageBoardMapper messageBoardMapper;

	@Override
	public List<MessageBoard> getMessageBoards(Integer pageIndex, Integer pageMax, String orderByField,
			String orderByWay, String headlineOrContentFuzzyQuery) throws UnsupportedEncodingException {
		Integer start = (pageIndex - 1) * pageMax;
		if ("MessageDate".equals(orderByField)) {
			orderByField = "message_Date";
		}
		if(null!=headlineOrContentFuzzyQuery && !StringUtils.isEmpty(headlineOrContentFuzzyQuery.trim())) {
			headlineOrContentFuzzyQuery = "%"+ Iso_8859_1_to_Utf_8_Util.Iso_8859_1_to_Utf_8(headlineOrContentFuzzyQuery) + "%";
		}else {
			headlineOrContentFuzzyQuery = null;
		}
		
		return messageBoardMapper.getMessageBoards(start, pageMax, orderByField, orderByWay, headlineOrContentFuzzyQuery);
	}

	@Override
	public Integer getMessageBoardsCount(String headlineOrContentFuzzyQuery) throws UnsupportedEncodingException {
		if(null!=headlineOrContentFuzzyQuery && !StringUtils.isEmpty(headlineOrContentFuzzyQuery.trim())) {
			headlineOrContentFuzzyQuery = "%"+ Iso_8859_1_to_Utf_8_Util.Iso_8859_1_to_Utf_8(headlineOrContentFuzzyQuery) + "%";
		}else {
			headlineOrContentFuzzyQuery = null;
		}
		return messageBoardMapper.getMessageBoardsCount(headlineOrContentFuzzyQuery);
	}

	@Override
	public Integer deleteMessageBoardById(Integer deleteId) {
		MessageBoard messageBoard = messageBoardMapper.getMessageBoardById(deleteId);
		if(null==messageBoard) {
			return -1;
		}
		Integer deleteResult = messageBoardMapper.deleteMessageBoardById(deleteId);
		return deleteResult;
	}

	@Override
	public Integer operateMessageBoard(MessageBoard messageBoard) {
		messageBoard.setMessageDate(new Date());
		if(null == messageBoard.getId()) {
			int addResult = messageBoardMapper.addMessageBoard(messageBoard);
			return addResult;
		} else {
			int updateResult = messageBoardMapper.updateMessageBoard(messageBoard);
			return updateResult;
		}
	}
}
