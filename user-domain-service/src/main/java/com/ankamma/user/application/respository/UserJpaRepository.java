package com.ankamma.user.application.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankamma.user.application.persistence.User;

public interface UserJpaRepository extends JpaRepository<User, Long> { 

}
