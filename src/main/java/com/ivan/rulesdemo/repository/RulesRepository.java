package com.ivan.rulesdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivan.rulesdemo.entity.Rules;

@Repository
public interface RulesRepository extends JpaRepository<Rules, Integer> {
	
	//custom queries declarations

}
