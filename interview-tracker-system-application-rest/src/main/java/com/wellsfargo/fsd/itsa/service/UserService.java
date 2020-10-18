package com.wellsfargo.fsd.itsa.service;

import java.util.List;


import com.wellsfargo.fsd.itsa.entity.Users;
import com.wellsfargo.fsd.itsa.exception.ImsException;

public interface UserService {

	Users add(Users users) throws ImsException;

	Users save(Users users) throws ImsException;

	boolean deleteUser(int userId) throws ImsException;

	//Item getItemById(int icode) throws ImsException;

	List<Users> getAllUsers() throws ImsException;
}
