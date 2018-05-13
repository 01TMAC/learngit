package com.mailian.service;

import java.util.List;

import com.mailian.pojo.BaseDict;



public interface BaseDictService {

	
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
