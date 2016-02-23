package cz.autocont.facade;

import cz.autocont.dtos.MessageDTO;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface MessageFacade {
    public Long createMessage(MessageDTO m);
    public boolean deleteMessage(Long id);
    public List<MessageDTO> getAllMessages();
    
}
