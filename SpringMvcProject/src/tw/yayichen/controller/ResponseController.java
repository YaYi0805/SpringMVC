package tw.yayichen.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@RequestMapping(path = "/responsebody.controller", method = RequestMethod.GET)
	@ResponseBody
	public String processResponseAction1() {
		return "This Message is From Server.";
	}
	
	@RequestMapping(path = "/responsebodycharset.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody  																					  //application/xml, application/json, text/html ...
	public String processResponseAction2() {
		return "This Message is From Server:你好";
	}
	
	@RequestMapping(path = "/responseentity.controller", method = RequestMethod.GET)
	public ResponseEntity<String> processResponseEntity(){
		return new ResponseEntity<String>("Custom Message 403(Forbidden)", HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(path = "/responsebodybyteimage.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8") 																					 
	public void processResponseByteImsgeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/banner-01.jpg");
		IOUtils.copy(is1, response.getOutputStream());
	}

}
