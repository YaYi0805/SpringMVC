package tw.yayichen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = { "sky" })
public class ModelAttributeController {

	@RequestMapping(path = "/modelattrmain.controller", method = RequestMethod.GET)
	public String processModelAttrAction(Model m) {
		m.addAttribute("sky", "blue");
		return "/modelattreceive.controller";
	}

	@RequestMapping(path = "/modelattreceive.controller", method = RequestMethod.GET)
	public void processModelAttrReceiveAction(@ModelAttribute(name = "sky") String result) {
		System.out.println("result:" + result);
	}

	@RequestMapping(path = "/pathvaribleTest/{memberid}", method = RequestMethod.GET)
	public void processPathVarible(@PathVariable(name = "memberid") String mid) {
		System.out.println("mid:" + mid);
	}

}
