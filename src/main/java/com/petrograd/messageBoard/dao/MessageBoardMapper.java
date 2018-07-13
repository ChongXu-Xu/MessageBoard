package com.petrograd.messageBoard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.petrograd.messageBoard.entity.MessageBoard;

@Repository
public interface MessageBoardMapper {
	List<MessageBoard> getMessageBoards(@Param("start") Integer start, @Param("pageMax") Integer pageMax,
			@Param("orderByField") String orderByField, @Param("orderByWay") String orderByWay,
			@Param("headlineOrContentFuzzyQuery") String headlineOrContentFuzzyQuery);

	Integer getMessageBoardsCount(@Param("headlineOrContentFuzzyQuery") String headlineOrContentFuzzyQuery);

	MessageBoard getMessageBoardById(@Param("id") Integer id);

	Integer deleteMessageBoardById(@Param("deleteId") Integer deleteId);
	
	Integer addMessageBoard(MessageBoard messageBoard);
	
	Integer updateMessageBoard(MessageBoard messageBoard);
}
