package com.ultrapower.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultrapower.domain.Girl;
import com.ultrapower.exception.GirlException;
import com.ultrapower.exception.ResultEnum;
import com.ultrapower.repository.GirlRepository;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void inertTwo() {
		
		Girl girl1 = new Girl();
		girl1.setAge(14);
		girl1.setCupSize("B");
		
		Girl girl2 = new Girl();
		girl2.setAge(15);
		girl2.setCupSize("BB");
		
		girlRepository.save(girl1);
		girlRepository.save(girl2);
	}
	
	public void getAge(Integer id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if(age < 10 ) {
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age > 10 && age < 16) {
			//你可能还在上初中
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
	/**
	 * 根据ID查询一个人的信息
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id) {
		return girlRepository.findOne(id);
	}
}
