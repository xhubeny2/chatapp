package cz.autocont.service.config;

import cz.autocont.dtos.MessageDTO;
import cz.autocont.entities.Message;
import org.dozer.loader.api.BeanMappingBuilder;

/**
 *
 * @author Michael
 */
public class EntityDTOMapping extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(Message.class, MessageDTO.class);
    }

}