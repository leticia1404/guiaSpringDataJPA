package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class CustomerController {

	private final CustomerRepository customers;
	
	public CustomerController(CustomerRepository customers) {
		super();
		this.customers = customers;
	}
		
    @GetMapping("/customers")
    public String listAllCustomers(Model model) {
		List<Customer> lista = customers.findAll();
		model.addAttribute("cs", lista);
        return "customersList";
    }
    
    @GetMapping("/customers/{id}")
    public String listAllCustomers(@PathVariable Long id, Model model) {
        //ModelAndView mav = new ModelAndView("customerDetails");
        //mav.addObject(this.customers.findById(id));
        //return mav;		
    	Optional<Customer> c = customers.findById(id);
    	model.addAttribute("customers", c);
        return "customersDetails";
    }
    
	
    
    

}