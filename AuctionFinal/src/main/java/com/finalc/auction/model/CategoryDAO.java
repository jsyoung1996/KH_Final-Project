package com.finalc.auction.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO implements InterCategoryDAO {

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	
}
