package com.ultrapower.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ultrapower.domain.Girl;
import com.ultrapower.domain.Result;
import com.ultrapower.repository.GirlRepository;
import com.ultrapower.service.GirlService;
import com.ultrapower.utils.ResultUtil;

@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;
	@Autowired
	private GirlService girlService;

	@GetMapping(value="/girls")
	public List<Girl> girlList(){
		return girlRepository.findAll();
	}
	
	@PostMapping(value="/girls")
	public Result<Girl> girlAdd(@Valid Girl girl,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return null;
		//	return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(girlRepository.save(girl));
	}
	
	@GetMapping(value="/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id);
	}
	@PutMapping(value="/girls/{id}")
	public Girl updateOne(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}
	@DeleteMapping(value="/girls/{id}")
	public void deleteGirl(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}
	@GetMapping(value="/girls/age/{age}")
	public List<Girl> girlFindOneByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}
	
	@PostMapping(value="/girls/insert")
	public void insertTwo() {
		girlService.inertTwo();
	}
	
	@GetMapping(value="girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception {
		girlService.getAge(id);
	}
}
