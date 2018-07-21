package com.ultrapower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultrapower.domain.Girl;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

	/**
	 * 根据年龄查询，名字必须按照格式写
	 * @param age
	 * @return
	 */
	public List<Girl> findByAge(Integer age);
}
