package com.sys.spring.min.dao;

import java.util.List;

import com.sys.spring.min.domain.Message;

public interface MinDao {

	public int insertMessage(Message msg) ;
	
	public List<Message> searchList(Message msg) ;
}
