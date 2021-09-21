package tw.yayichen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.yayichen.model.Profiles;
import tw.yayichen.model.ProfilesDao;

@Controller
public class DemoRestCrudController {
	
	@Autowired
	private ProfilesDao pDao;
	
	@PostMapping(path = "/profiles")
	@ResponseBody
	public String processRestInsertAction(@RequestParam("userName") String userName,
										     @RequestParam("userAddress") String userAdderss,
										     @RequestParam("userPhone") String userPhone) {
		Profiles profiles = new Profiles();
		profiles.setName(userName);
		profiles.setAddress(userAdderss);
		profiles.setPhone(userPhone);
		
		pDao.insert(profiles);
		
		return "Insert OK";
	}
	
	@GetMapping(path = "/profiles/{profilesid}")
	@ResponseBody
	public String processRestQueryAction(@PathVariable("profilesid") int profilesid) {
		Profiles result = pDao.findById(profilesid);
		
		return "Result:" + result.getId() + " " + result.getName() + " " + result.getAddress() + " " + result.getPhone();
	}
	
	@PutMapping(path = "/profiles/{profilesid}")
	@ResponseBody
	public String processRestUpdateAction(@PathVariable("profilesid") int profilesid, 
										  @RequestParam("userName") String userName,
										  @RequestParam("userAddress") String userAdderss,
										  @RequestParam("userPhone") String userPhone) {
		Profiles profiles = new Profiles();
		profiles.setId(profilesid);
		profiles.setName(userName);
		profiles.setAddress(userAdderss);
		profiles.setPhone(userPhone);
		
		pDao.update(profiles);
		
		return "Update OK";
	}
	
	
	@DeleteMapping(path = "/profiles/{profilesid}")
	@ResponseBody
	public String processRestDeleteAction(@PathVariable("profilesid") int profilesid, 
			  							  @RequestParam("userName") String userName,
			  							  @RequestParam("userAddress") String userAdderss,
			  							  @RequestParam("userPhone") String userPhone) {
		Profiles profiles = new Profiles();
		profiles.setId(profilesid);
		profiles.setName(userName);
		profiles.setAddress(userAdderss);
		profiles.setPhone(userPhone);
		
		pDao.delete(profiles);
		
		return "Delete OK";
	}

}
