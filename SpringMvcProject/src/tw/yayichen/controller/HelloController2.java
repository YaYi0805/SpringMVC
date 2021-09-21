package tw.yayichen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"name"})
public class HelloController2 {
	
	@RequestMapping(path = "/helloentry.controller", method = RequestMethod.GET)
	public String processMainAction() {
		return "form";
	}
	
	@RequestMapping(path="/hello.controller2", method = RequestMethod.GET)
	public String processHelloAction(HttpServletRequest request, Model m) {
		String userName = request.getParameter("userName");
		
		Map<String, String> errors = new HashMap<String, String>();
		//request.setAttribute("errors", errors);
		m.addAttribute("errors", errors);

		if (userName == null || userName.length() == 0) {
			errors.put("userName", "name is required.");
		}

		if (errors != null && !errors.isEmpty()) {
			return "form";
		}
		
		//session.setAttribute("name", userName); -> session.setAttribute("name", userName);
		m.addAttribute("name", userName);
		return "success";
	}

}
