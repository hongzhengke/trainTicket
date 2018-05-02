package trainTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trainTicket.mapper.UserMapper;
import trainTicket.po.User;
import trainTicket.po.UserExample;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Transactional(readOnly=true)
	public User findUserByTelAndPassword(String tel, String password) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andTelEqualTo(tel);
		criteria.andPasswordEqualTo(password);
		List<User>list = userMapper.selectByExample(userExample);
		return list.size() == 0 ? null : list.get(0);
	}

	/**
	 * 注册用户，先判断手机号码是否已经被注册，若已注册，返回false,否则，插入user并返回true
	 */
	@Transactional
	public boolean registerUser(User user) {
		//先判断手机号码是否存在
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andTelEqualTo(user.getTel());
		List<User>list = userMapper.selectByExample(userExample);
		if(list.size() != 0)
			return false;
		
		user.setId(null);
		userMapper.insert(user);
		return true;
	}
	
	
}
