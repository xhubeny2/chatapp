package cz.autocont.service;

import cz.autocont.entities.Message;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface MessageService {
    
    public Message create(Message m);
    
    public List<Message> getAllMessages();
    
    public boolean remove(Message m);
    
}
