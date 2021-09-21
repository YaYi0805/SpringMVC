package tw.yayichen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tw.yayichen.model.Users;
import tw.yayichen.model.UsersDao;

@Controller
public class UserCheckController {
	
	@Autowired
	public UsersDao usersDao;
	
	@PostMapping(path = "/accountcheck.controller")
	public ResponseEntity<String> processAccountCheckAction(@RequestBody Users user){
		boolean status = usersDao.checkLogin(user);
		if(status) {
			return new ResponseEntity<String>("Y",HttpStatus.OK);
		}		
		return new ResponseEntity<String>("N",HttpStatus.OK);
	}
}
