package tw.yayichen.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.yayichen.model.Picture;
import tw.yayichen.model.PictureService;

@Controller
public class UploadFileController {
	
	@RequestMapping(path = "/uploadentry.controller", method = RequestMethod.GET)
	public String processEntry() {
		return "uploadFile";
	}
	
	@RequestMapping(path = "/uploadfile.controller", method = RequestMethod.POST)
	@ResponseBody
	public String processFileUploadAction(@RequestParam("myFiles") MultipartFile multipartFile, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = multipartFile.getOriginalFilename();
		System.out.println("fileName:" + fileName);
		
		String saveDir = request.getSession().getServletContext().getRealPath("/") + "uploadTempDir\\";
		System.out.println("saveDir:" + saveDir);
		
		//建立資料夾
		File saveDirFile = new File(saveDir);
		//File saveDirFile = new File("C:/"); 可自己指定路徑
		saveDirFile.mkdirs();
		//java.io.File.mkdir()：只能創建一級目錄，且父目錄必須存在，否則無法成功創建一個目錄。
		//java.io.File.mkdirs()：可以創建多級目錄，父目錄不一定存在。
		
		//儲存檔案
		String saveFilePath = saveDir + fileName;
		File saveFile = new File(saveFilePath);
		multipartFile.transferTo(saveFile);
		
		System.out.println("saveFilePath:" + saveFilePath);
		
		//上傳檔案
		if(fileName!=null && fileName.length()!=0) {
			savePicture(fileName, saveFilePath);
		}
		
		return "OK:\nfileName:" + fileName + "\nSaveDir:" + saveDir + "\nSaveFilePath:" + saveFilePath;
	}
	
	@Autowired
	private PictureService pService;
	
	private void savePicture(String fileName, String saveFilePath) throws IOException {
		Picture picture = new Picture();
		picture.setFilename(fileName);

		InputStream is1 = new FileInputStream(saveFilePath);
		byte[] b = new byte[is1.available()];
		is1.read(b);
		is1.close();
		
		picture.setPicture(b);
		
		pService.insert(picture);
	}
}
