
import cz.autocont.dtos.MessageDTO;
import cz.autocont.entities.Message;
import cz.autocont.service.MappingService;
import cz.autocont.service.config.MappingConfiguration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
@ContextConfiguration(classes = MappingConfiguration.class)
public class MappingTest extends AbstractTestNGSpringContextTests{
    
    @Autowired
    private MappingService mappingService;
    
    private Message m1;
    private Message m2;
    private List<Message> messages;
    //private Date date1;
    
    @BeforeMethod
    public void createContext(){
        m1 = new Message();
        m1.setText("abc");
        m1.setUser("John");
        Calendar cal = Calendar.getInstance();
	m1.setDateAndTime(cal.getTime());
        
        m2 = new Message();
        m2.setText("xyz");
        m2.setUser("Jack");
        m2.setDateAndTime(cal.getTime());
        
        messages = new ArrayList<>();
        messages.add(m1);
        messages.add(m2);
        
        
    }
    
    @Test
    public void mapRentalToRentalDto() {
        MessageDTO mDTO = mappingService.mapTo(m1, MessageDTO.class);
        Assert.assertEquals(m1, mappingService.mapTo(mDTO, Message.class),
                "Rental and RentalDTO are different.");
    }

    @Test
    public void mapRentalList() {
        List<MessageDTO> mDtos = mappingService.mapToCollection(messages, MessageDTO.class);
        Assert.assertEquals(messages.size(), mDtos.size(), "Different sizes of lists.");
    }

    
}
