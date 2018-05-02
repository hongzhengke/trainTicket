package trainTicket.service;

import trainTicket.po.User;

public interface UserService {
	public User findUserByTelAndPassword(String tel,String password);
	public boolean registerUser(User user);
}
