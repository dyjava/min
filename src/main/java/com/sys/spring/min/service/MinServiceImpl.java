package com.sys.spring.min.service;

import java.util.List;

import com.sys.spring.min.dao.MinDao;
import com.sys.spring.min.domain.Message;

public class MinServiceImpl implements MinService {
	private MinDao dao ;

	public MinDao getDao() {
		return dao;
	}

	public void setDao(MinDao dao) {
		this.dao = dao;
	}

	@Override
	public int addMessage(Message msg) {
		// TODO Auto-generated method stub
		return dao.insertMessage(msg) ;
	}

	@Override
	public List<Message> findMessageByMessage(Message msg) {
		// TODO Auto-generated method stub
		return dao.searchList(msg) ;
	}
	
}
