package com.ibm.java.crud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.java.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{


}
