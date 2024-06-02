package com.Banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Banking.Model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsername(String username);

}
