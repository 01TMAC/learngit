package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class LoginAction extends ActionSupport  implements ModelDriven<User>{
	
	private User model = new User();
	private UserService userService = new UserServiceImpl();
	public String login(){
		
		boolean flag = this.userService.login(this.getModel().getUsername(), this.getModel().getPassword());
		if(flag){//用户名或者密码验证成功
			return "home";
		}else{
			this.addActionError("用户名或者密码错误");
			return "login";
		}
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	
	@Override
	public void validate() {
		/**
		 * 针对表单验证
		 */
		if("".equals(this.model.getUsername())||"".equals(this.model.getPassword())){
			this.addActionError("用户名或者密码不能为空");
			this.addActionMessage("用户名或者密码不能为空");
		}
		
		/**
		 * 字段验证
		 */
		if("".equals(this.model.getUsername())){
			this.addFieldError("username", "用户名不能为空");
		}
		if("".equals(this.model.getPassword())){
			this.addFieldError("password", "密码不能为空");
		}else if(this.model.getPassword().length()<3){
			this.addFieldError("password", "密码的长度不能小于6");
		}
	}

}
