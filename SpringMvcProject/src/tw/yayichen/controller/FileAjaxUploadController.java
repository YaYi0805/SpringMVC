package tw.yayichen.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileAjaxUploadController {
	
	@PostMapping(path = "/ajaxupload.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processAjaxFileUploadAction(@RequestParam("myfile") MultipartFile multipartFile) throws IllegalStateException, IOException {
		String fileName = multipartFile.getOriginalFilename();
		System.out.println("fileName:" + fileName);
		
		File saveFileDir = new File("c:/upload/test");
		saveFileDir.mkdirs();
		
		File saveFilePath = new File(saveFileDir, fileName);
		multipartFile.transferTo(saveFilePath);
		System.out.println("saveFilePath:" + saveFilePath);
		
		return "Success";
	}
}
