package com.thebeezgroup.autopint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thebeezgroup.autopint.model.UserModel;

@Repository
public interface TestRepository extends JpaRepository<UserModel, Integer>{	
}
