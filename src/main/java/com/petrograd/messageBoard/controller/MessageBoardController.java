package com.petrograd.messageBoard.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petrograd.messageBoard.entity.MessageBoard;
import com.petrograd.messageBoard.service.MessageBoardService;

@Controller
public class MessageBoardController {

	@Autowired
	MessageBoardService messageBoardService;

	@RequestMapping(value = "getMessageBoards")
	@ResponseBody
	public Map<String, Object> getMessageBoards(@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "5") Integer pageMax,
			@RequestParam(defaultValue = "sortCreateDate desc") String orderBy,
			@RequestParam(required = false) String headlineOrContentFuzzyQuery) throws UnsupportedEncodingException {

		int index = orderBy.indexOf(" ");
		String orderByField = orderBy.substring(4, index);
		String orderByWay = orderBy.substring(index + 1);

		Map<String, Object> data = new HashMap<>();
		data.put("pageIndex", pageIndex);
		Integer totalRecord = messageBoardService.getMessageBoardsCount(headlineOrContentFuzzyQuery);
		data.put("totalRecord", totalRecord);
		List<MessageBoard> messageBoards = messageBoardService.getMessageBoards(pageIndex, pageMax, orderByField,
				orderByWay, headlineOrContentFuzzyQuery);
		data.put("rows", messageBoards);

		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("data", data);
		jsonData.put("errorMsg", null);
		jsonData.put("logId", 0);
		jsonData.put("result", "SUCCESS");

		return jsonData;
	}

	@RequestMapping(value = "deleteMessageBoard", method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteMessageBoard(@RequestParam Integer deleteId) {
		Integer results = messageBoardService.deleteMessageBoardById(deleteId);
		return results;
	}

	@RequestMapping(value = "operateMessageBoard", method = RequestMethod.POST)
	@ResponseBody
	public Boolean addMessageBoard(MessageBoard messageBoard/*Integer id, String headline, String content, String messagePerson*/) {
		Integer operateResult = messageBoardService.operateMessageBoard(messageBoard);
		if (1 == operateResult) {
			return true;
		} else {
			return false;
		}
	}
}
