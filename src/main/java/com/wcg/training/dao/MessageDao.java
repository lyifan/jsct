package com.wcg.training.dao;

import org.springframework.stereotype.Repository;

import com.wcg.training.domain.Message;

@Repository
public class MessageDao extends GenericDao<Message> {

	public MessageDao() {
		super(Message.class);
	}

}
