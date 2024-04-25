package com.Dleawebsystem.pjmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dleawebsystem.pjmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
