package com.test.inadvance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.inadvance.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
