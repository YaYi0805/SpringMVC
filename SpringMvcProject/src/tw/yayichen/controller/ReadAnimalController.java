package tw.yayichen.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.yayichen.model.Animal;

@Controller
public class ReadAnimalController {

	ArrayList<Animal> animals = new ArrayList<Animal>();
	
	public ReadAnimalController() {
		animals.add(new Animal(1,"monkey"));
		animals.add(new Animal(2,"rabbit"));
		animals.add(new Animal(3,"tiger"));
		animals.add(new Animal(4,"bird"));
		animals.add(new Animal(5,"elephant"));
		animals.add(new Animal(6,"cat"));
		animals.add(new Animal(7,"hipo"));
		animals.add(new Animal(8,"zebra"));
		animals.add(new Animal(9,"lion"));
	}
	
	@PostMapping(path = "/animalreader.controller")
	@ResponseBody
	public ArrayList<Animal> processSearchAction(@RequestParam("keyword") String animalName){
		return SearchResult(animalName);
	}

	private ArrayList<Animal> SearchResult(String animalName) {
		ArrayList<Animal> result = new ArrayList<Animal>();
		
		for(Animal a: animals) {
			if(a.getAname().contains(animalName) && animalName.length()!=0) {
				result.add(a);
			}
		}
		return result;
	}

}
