package service.impl;

import java.io.Serializable;
import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;



public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean login(String username, String password) {
		User user = this.userDao.getUserByUAndP(username, password);
		if(user == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<User> getAllUser() {
		return this.userDao.getAllUser();
	}

	@Override
	public User getUserById(Serializable uid) {
		return this.userDao.getUserById(uid);
	}

	@Override
	public void deleteUser(Serializable uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateUser(user);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.saveUser(user);
	}
	
}
