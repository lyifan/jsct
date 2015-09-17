package com.wcg.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wcg.training.dao.MessageDao;
import com.wcg.training.domain.Message;
import com.wcg.training.web.model.MessageModel;

@Service
@Transactional
public class MessageService {

	@Autowired
	private MessageDao messageDao;
	
	public List<MessageModel> getMessages() {
		
		List<MessageModel> result = new ArrayList<MessageModel>();
		
		List<Message> messages = messageDao.getAll();
		for(Message msg : messages) {
			MessageModel row = new MessageModel();
			row.setMessageId(msg.getId());
			row.setMessage(msg.getMesssage());
			row.setUser(msg.getUser().getLoginName());
			result.add(row);
		}
		
		return result;
	}
	
	public void addMessage(String message, int userId) {
		Message m = new Message();
		m.setMesssage(message);
		m.setUserId(userId);
		
		messageDao.save(m);
	}
	
	public void deleteMessage(int messageId) {
		messageDao.deleteById(messageId);
	}
	
}
