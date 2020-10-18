package com.wellsfargo.fsd.itsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.itsa.dao.UserRepository;
import com.wellsfargo.fsd.itsa.entity.Users;
import com.wellsfargo.fsd.itsa.exception.ImsException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Users add(Users users) throws ImsException {
		if(users!=null) {
			//Users userdb = userRepo.existsByUserId(users.getUserId());
			if(userRepo.existsByUserId(users.getUserId())) {
				throw new ImsException("Users id already exists!");
			}
			
			userRepo.save(users);
		}
		return users;
	}

	@Override
	public Users save(Users users) throws ImsException {
		if(users!=null) {
			//Users userdb = userRepo.existsByUserId(users.getUserId());
			if(userRepo.existsByUserId(users.getUserId())) {
				throw new ImsException("User id already exists");
			}
			
			userRepo.save(users);
		}
		return users;
	}

	@Override
	public boolean deleteUser(int userId) throws ImsException {
		//Users userdb = userRepo.existsByUserId(userId);
		if(!userRepo.existsByUserId(userId)) {
			throw new ImsException("User id Not Found");
		}
	
		userRepo.deleteByUserId(userId);
		return true;
	}

//	@Override
//	public Item getItemById(int icode) throws ImsException {
//		return itemRepo.findById(icode).orElse(null);		
//	}

	@Override
	public List<Users> getAllUsers() throws ImsException {
		return userRepo.findAll();
	}

}
