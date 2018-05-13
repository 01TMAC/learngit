package com.mailian.mapper;

import java.util.List;

import com.mailian.pojo.BaseDict;



public interface BaseDictDao {

	
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
