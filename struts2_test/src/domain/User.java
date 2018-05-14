package domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	/**
	 *  userID INT  NOT NULL AUTO_INCREMENT, #主键ID
		username VARCHAR(50)   NULL,  #用户姓名
		password VARCHAR(50)  NULL,   #密码#
		sex VARCHAR(10)  NULL,        #性别（例如：男，女）
		birthday VARCHAR(50) NULL,       #出生日期
		education VARCHAR(20)  NULL,    #学历（例如：研究生、本科、专科、高中）
		telephone VARCHAR(50)  NULL,  #电话 
		interest VARCHAR(20)  NULL,      #兴趣爱好（例如：体育、旅游、逛街）
		path VARCHAR(500)  NULL,     #上传路径（path路径）
		filename VARCHAR(100)  NULL,     #上传文件名称（文件名）
		remark VARCHAR(500)  NULL,   #备注
	 */
	private Long userID;
	private String username;
	private String password;
	private String sex;
	private Date birthday;
	private String education;
	private String telephone;
	private String interest;
	private String path;
	private String filename;
	private String remark;
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	
}
