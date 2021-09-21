package tw.yayichen.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.yayichen.model.House;

@Controller
public class JsonCreateController {

	//方法一：需搭配組態設定
	@RequestMapping(path = "/housejson", method = RequestMethod.GET)
	public String processJsonAction1(Model m) {
		House hBean = new House();
		hBean.setHouseid(1001);
		hBean.setHousename("Pretty House");
		m.addAttribute("house", hBean);
		return "myHouseBean";		
	}
	
	//方法二：不搭配組態設定 -> 建議用此方法
	@RequestMapping(path = "/houseconvertjson.controller", method = RequestMethod.GET)
	@ResponseBody
	public House processJsonAction2(Model m) {
		House hBean = new House();
		hBean.setHouseid(1001);
		hBean.setHousename("Pretty House");
		return hBean;
	}
	
	//Ajax05_xml_json_get.html
	@RequestMapping(path = "/houseconvertjson2.controller", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<House> processJsonAction3(Model m) {
		ArrayList<House> lists = new ArrayList<House>();
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Pretty House");
		
		House hBean2 = new House();
		hBean2.setHouseid(1002);
		hBean2.setHousename("Ugly House");
		
		lists.add(hBean1);
		lists.add(hBean2);
		
		return lists;
	}
}
