package com.sys.spring.min.dao;

import java.util.ArrayList;
import java.util.List;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.min.domain.Message;
import com.sys.util.Logs;

public class MinDaoImpl extends AbstractDBDao implements MinDao {
	private String table = "member" ;
	
	private static Message msg  ;
	@Override
	public int insertMessage(Message msg) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("insertKind") ;
		
		String sql = "insert into "+table+" (uid,title,note,parentId) values(?,?,?,?)" ;
		ArrayList<Object> params = new ArrayList<Object>() ;
//		params.add(kind.getUid()) ;
//		params.add(kind.getTitle()) ;
//		params.add(kind.getNote()) ;
//		params.add(kind.getParentId()) ;
		
//		this.msg = msg ;
		int result = this.update(sql, params.toArray()) ;
//		int result =0;
		
		buf.append("|").append(sql)
		.append("|").append(this.list2String(params))
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis() - start) ;
		Logs.info(buf) ;
		return result ;
	}

	@Override
	public List<Message> searchList(Message msg) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("searchList") ;
		
		String sql = "select * from "+table+" where cardid = ? ";
		List<Message> list = new ArrayList<Message>() ;
		list = this.selectList(sql, new Object[] {msg.getCardid()}, Message.class) ;
//		list.add(this.msg) ;
		
		buf.append("|").append(sql)
		.append("|").append("")
		.append("|").append(list.size())
		.append("|").append(System.currentTimeMillis() - start) ;
		Logs.info(buf) ;
		
		if(list==null || list.size()==0){
			return new ArrayList<Message>() ;
		} else {
			return list ;
		}
	}

}
