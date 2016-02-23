/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.autocont.springmvc.controllers;

import cz.autocont.facade.MessageFacade;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Michael
 */
@Controller
@RequestMapping("/")
public class indexController {
    
   
    @Autowired
    private MessageFacade messageFacade;
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        model.addAttribute("messages", messageFacade.getAllMessages());   
        
        return "home";
    }

    /*@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("employee") EmployeeDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, HttpServletRequest request) {
        
        //Long id = null;
            //create message
            try{
                id = employeeFacade.createEmployee(formBean);  
            } catch (ConstraintViolationException ex){
                log.warn("Error");
                redirectAttributes.addFlashAttribute("alert_error", "Employee with this e-mail already exists. ");
                return "redirect:" + uriBuilder.path("/employee/detail/").toUriString();
            } catch (MappingException ex){
                log.warn("Error");
                redirectAttributes.addFlashAttribute("alert_error", "You have to fill all fields. ");
                return "redirect:" + uriBuilder.path("/employee/detail/").toUriString();
            } catch (IllegalArgumentException ex){
                log.warn("Error");
                redirectAttributes.addFlashAttribute("alert_error", "You have to fill all fields. " + ex);
                return "redirect:" + uriBuilder.path("/employee/detail/").toUriString();
            }
        } else {
            //update employee
            try{
                id = formBean.getId();
                employeeFacade.updateEmployeeName(id, formBean.getName());
                employeeFacade.updateEmployeeBirth(id, formBean.getBirth());
                employeeFacade.updateEmployeeIdCardNumber(id, formBean.getIdCardNumber());
                employeeFacade.updateEmployeeEmail(id, formBean.getEmail());
                employeeFacade.updateEmployeePassword(id, formBean.getPassword());
                updateOrCreate = "updated";
            } catch (MappingException ex){
                log.warn("Error");
                redirectAttributes.addFlashAttribute("alert_error", "You have to fill all fields. ");
                return "redirect:" + uriBuilder.path("/employee/detail/{id}").buildAndExpand(id).encode().toUriString();
            }
        }
        //report success
        redirectAttributes.addFlashAttribute("alert_success", "Employee \"" + formBean.getName() + "\" was " + updateOrCreate);
        return "redirect:" + uriBuilder.path("/employee/list").toUriString();
    }*/
    
}