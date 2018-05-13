package com.mailian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mailian.pojo.BaseDict;
import com.mailian.pojo.Customer;
import com.mailian.pojo.QueryVo;
import com.mailian.service.BaseDictService;
import com.mailian.service.CustomerService;
import com.mailian.utils.Page;



@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	@Autowired
	private CustomerService customerService;
	/**
	 * 显示用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value="/customer/list")
	public String queryCustomerList(QueryVo vo,Model model) {
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过vo查询分页
		Page<Customer> page =  customerService.selectPageByQueryVo(vo);
		model.addAttribute("page",page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
		//修改页面
		@RequestMapping(value = "/customer/edit")
		public @ResponseBody
		Customer edit(Integer id){
			return customerService.selectCustomerById(id);
		}
		//保存修改页面
		@RequestMapping(value = "/customer/update")
		public @ResponseBody
		String update(Customer customer){
			//修改
			customerService.updateCustomerById(customer);
			return "OK";
		}
		//删除条目
		@RequestMapping(value = "/customer/delete.action")
		public @ResponseBody
		String delete(Integer id){
			//删除
			customerService.deleteCustomerById(id);
			return "OK";
		}

}
