package com.Banking.Service;

import com.Banking.Model.User;

public interface UserService {

	    User save(User user);
	    User findByUsername(String username);
	    User findById(Long id);
	    void deleteById(Long id);
	}



