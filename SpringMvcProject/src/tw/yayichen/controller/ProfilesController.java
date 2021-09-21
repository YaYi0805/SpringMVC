package tw.yayichen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfilesController {
	
	@RequestMapping(path = "/profilesentry.controller", method = RequestMethod.GET)
	public String processMainAction() {
		return "profiles";
	}
	
	@RequestMapping(path = "/profiles.controller", method = RequestMethod.GET)
	public String processProfilesAction(@RequestParam(name="userName") String userName,
										@RequestParam(name="userAddress") String userAddress, Model m) {
		m.addAttribute("user",userName);
		m.addAttribute("address",userAddress);
		return "profilesresult";
	}
	
	@RequestMapping(path = "/profiles.controller", method = RequestMethod.POST)
	public String processProfilesAction2(@RequestParam(name="userName") String userName,
									     @RequestParam(name="userAddress") String userAddress, Model m) {
		m.addAttribute("user",userName);
		m.addAttribute("address",userAddress);
		return "profilesresult";
	}
	
	//ajax03_xmlhttp_post.html XMLHttpRequest POST應用 - 非同步
	@PostMapping(path = "/ajaxprofiles.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processAjaxProfilesAction(@RequestParam(name="userName") String userName,
											@RequestParam(name="userAddress") String userAddress, 
											@RequestParam(name="userPhone") String userPhone) {
		return "message:" + userName + "-" + userAddress + "-" + userPhone;
	}
	
	//ajax07_formData.html
	@PostMapping(path = "/formDataProfiles.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processAjaxFormDataAction(@RequestParam(name="userName") String userName) {
		return "message:" + userName;
	}
}
