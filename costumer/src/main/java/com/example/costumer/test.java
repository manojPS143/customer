package com.example.costumer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
@Autowired
c_application ca;

@PostMapping("/saveCostumer")
public Costumer saveCostumer_Bean(@RequestBody Costumer c) {
	Costumer c1=ca.save(c);
	return c1;
}
@GetMapping("/retriveCostumer")
public List<Costumer>getCostumer_Beans(){
	return ca.findAll();
}
@PostMapping("/updateCostumer")
public Costumer updateCostumer_BeanById(@RequestParam int id,@RequestBody Costumer c ) {
	Optional<Costumer>co=ca.findById(id);
		if(co.isEmpty()) {
			return null;
		}else {
			return ca.save(c);
		}
	}
@DeleteMapping("/deleteCostumer")
public String DeleteCostumer_beanById(@RequestParam int id) {
	Optional<Costumer>co=ca.findById(id);
	if(co.isEmpty()) {
		return "not deleted";
	}else {
		Costumer c= co.get();
		ca.delete(c);
		return "data deleted";
	}
}

}
