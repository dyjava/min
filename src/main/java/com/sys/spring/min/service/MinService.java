package com.sys.spring.min.service;

import java.util.List;

import com.sys.spring.min.domain.Message;

public interface MinService {

	public int addMessage(Message msg) ;
	
	public List<Message> findMessageByMessage(Message msg) ;
}
