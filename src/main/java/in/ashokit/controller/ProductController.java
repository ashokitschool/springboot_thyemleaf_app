package in.ashokit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.binding.Product;

@Controller
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	private Map<Integer, Product> map = new HashMap<>();
	
	int pid = 1;

	// method to display form

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		logger.info("product view page loaded....");
		model.addAttribute("products", map.values());
		return "data";
	}

	@PostMapping("/product")
	public String handleSubmitBtn(@Valid Product p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			logger.warn("Product form validations failed...");
			return "index";
		} else {
			logger.info("Product saved...");
			p.setPid(pid);
			map.put(pid, p);
			model.addAttribute("msg", "Product Saved");
			pid ++;
		}
		return "index";
	}
	
	@GetMapping("/product")
	public String delete(@RequestParam("pid") Integer pid, Model model) {
		map.remove(pid);
		model.addAttribute("msg", "Product Deleted");
		model.addAttribute("products", map.values());
		logger.info("Product Deleted...");
		return "data";
	}
}
