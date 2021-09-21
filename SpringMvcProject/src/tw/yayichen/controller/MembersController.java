package tw.yayichen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.yayichen.model.Members;

@Controller
public class MembersController {

	@RequestMapping(path = "/membersentry.contoller", method = RequestMethod.GET)
	public String processShowForm(Model m) {
		Members mem1 = new Members();
		//Members mem1 = new Members("jack","male",26);
		m.addAttribute("members", mem1);
		return "members";
	}
	
	@RequestMapping(path = "/addMembers", method = RequestMethod.POST)
	public String processFormAction(@ModelAttribute(name="members") Members mem2, BindingResult bind,Model m) {
		
		if(bind.hasErrors()) {
			return "membersError";
		}
		
		m.addAttribute("mName", mem2.getMemberName());
		m.addAttribute("mGender", mem2.getGender());
		m.addAttribute("mAge",mem2.getAge());
		
		return "membersResult";
	}
}
