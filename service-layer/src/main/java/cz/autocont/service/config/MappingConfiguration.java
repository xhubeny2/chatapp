package cz.autocont.service.config;

import cz.autocont.db.PersistenceSampleApplicationContext;
import cz.autocont.facade.MessageFacadeImpl;
import cz.autocont.service.MessageServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Michael
 */
@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(basePackageClasses = { MessageServiceImpl.class, MessageFacadeImpl.class })
public class MappingConfiguration {

    @Bean
    public Mapper dozer() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(new EntityDTOMapping());
        return mapper;
    }
}
