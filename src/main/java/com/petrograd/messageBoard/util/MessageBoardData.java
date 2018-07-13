package com.petrograd.messageBoard.util;

import java.util.Map;

import com.petrograd.messageBoard.entity.MessageBoard;

public class MessageBoardData {
	private Integer pageIndex;
	private Integer totalRecord;
	private Map<String, MessageBoard> row;
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Map<String, MessageBoard> getRow() {
		return row;
	}
	public void setRow(Map<String, MessageBoard> row) {
		this.row = row;
	}
	
	
}
