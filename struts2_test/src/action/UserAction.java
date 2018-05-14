package action;



import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Education;
import domain.Hobby;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService = new UserServiceImpl();
	private User model = new User();
	private Long[] hids;//接受页面上的选中的爱好的id值     回显
	
	public Long[] getHids() {
		return hids;
	}


	public void setHids(Long[] hids) {
		this.hids = hids;
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	
	
	public String showAllUser(){
		List<User> userList = this.userService.getAllUser();
		//userList放入到map栈中
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	
	public String updateUI(){
		/**
		 * 把学历的下拉列表框填充
		 * 把爱好的checkbox框填充
		 */
		//学位
		List<Education> educations = new ArrayList<Education>();
		Education education1 = new Education();
		education1.setEid(1L);
		education1.setName("博士");
		Education education2 = new Education();
		education2.setEid(2L);
		education2.setName("烈士");
		Education education3 = new Education();
		education3.setEid(3L);
		education3.setName("幼儿园");
		educations.add(education1);
		educations.add(education2);
		educations.add(education3);
		
		ActionContext.getContext().put("educations", educations);
		
		//爱好
		List<Hobby> hobbies = new ArrayList<Hobby>();
		Hobby hobby1 = new Hobby();
		hobby1.setHid(1L);
		hobby1.setName("看电影");
		Hobby hobby2 = new Hobby();
		hobby2.setHid(2L);
		hobby2.setName("睡觉");
		Hobby hobby3 = new Hobby();
		hobby3.setHid(3L);
		hobby3.setName("打篮球");
		hobbies.add(hobby1);
		hobbies.add(hobby2);
		hobbies.add(hobby3);
		ActionContext.getContext().put("hobbies", hobbies);
		
		/**
		 * 因为user对象中的属性要回显，所以user应该放入到对象栈中
		 */
		User user =this.userService.getUserById(this.getModel().getUserID());
		ActionContext.getContext().getValueStack().push(user);
		
		/**
		 * 爱好的回显
		 */
		String[] strings = user.getInterest().split(",");
		this.hids = new Long[strings.length];
		int index = 0;
		for(String s:strings){
			this.hids[index] = Long.parseLong(s);
			index++;
		}
		return "updateUI";
	}
	
	public String update(){
		/**
		 * 那hids中的内容赋值给model
		 * hids = [1,2,3]
		 * temp = "1,2,3";
		 */
		String temp = "";
		for(int i=0;i<this.hids.length;i++){
			if(i<this.hids.length-1){
				temp = temp+this.hids[i]+",";
			}else{
				temp = temp+this.hids[i];
			}
		}
		//把爱好的id的值赋值给Interest
		this.getModel().setInterest(temp);
		this.userService.updateUser(this.getModel());
		return null;
	}
}
