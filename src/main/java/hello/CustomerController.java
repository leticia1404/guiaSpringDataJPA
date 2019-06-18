package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@Controller
public class CustomerController {

    @GetMapping("/customers")
    public String listAllCustomers(Model model) {
		model.addAttribute("cs", new ArrayList<Customer>());
        return "customersList";
    }

}