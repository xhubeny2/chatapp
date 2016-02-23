/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.autocont.service;

import cz.autocont.daos.MessageDao;
import cz.autocont.entities.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class MessageServiceImpl implements MessageService {
    
    @Autowired
    private MessageDao messageDao;

    @Override
    public Message create(Message m) {
        if (messageDao.create(m)){
            return m;
        }
        return null;
    }

    @Override
    public List<Message> getAllMessages() {
        List<Message> messages = messageDao.findAll();
        return messages;
    }

    @Override
    public boolean remove(Message m) {
        return messageDao.remove(m);
    }
    
}
