/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.autocont.facade;

import cz.autocont.dtos.MessageDTO;
import cz.autocont.entities.Message;
import cz.autocont.service.MappingService;
import cz.autocont.service.MessageService;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
@Transactional
public class MessageFacadeImpl implements MessageFacade{
    
    @Inject
    private MappingService mappingService;
    
    @Inject
    MessageService messageService;

    @Override
    public Long createMessage(MessageDTO m) {
        Message mappedMessage = mappingService.mapTo(m, Message.class);
        return messageService.create(mappedMessage).getId();
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        return mappingService.mapToCollection(messageService.getAllMessages(), 
                MessageDTO.class);
    }
    
}
