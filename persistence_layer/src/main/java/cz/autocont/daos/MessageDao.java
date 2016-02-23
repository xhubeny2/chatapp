package cz.autocont.daos;

import cz.autocont.entities.Message;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface MessageDao {
    
    public boolean create(Message m);
    public boolean remove(Message m);
    public Message update(Message m);
    public List<Message> findAll();
    
}
