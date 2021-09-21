package tw.yayichen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyExceptionController {

	@RequestMapping("/myexcept.controller")
	public String processAction() throws Exception {
		throw new Exception();
	}
}
