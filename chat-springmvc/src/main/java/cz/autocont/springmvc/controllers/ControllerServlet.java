package cz.autocont.springmvc.controllers;

import cz.autocont.dtos.MessageDTO;
import cz.autocont.facade.MessageFacade;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author xhubeny2
 */
@Controller
@RequestMapping("/chat")
public class ControllerServlet {
    
    @Autowired
    private MessageFacade messageFacade;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("chat") MessageDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, HttpServletRequest request) {
        
        
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        
        MessageDTO m = new MessageDTO();
        m.setUser(name);
        m.setText(message);
        m.setDateAndTime(d);
        
        messageFacade.createMessage(m);

        //redirectAttributes.addFlashAttribute("alert_success", "Car \"" + formBean.getName() + "\" was " + updateOrCreate);
        return "redirect:" + uriBuilder.path("/");
    }
}
