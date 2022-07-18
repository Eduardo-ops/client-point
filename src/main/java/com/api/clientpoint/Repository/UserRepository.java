package com.api.clientpoint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.clientpoint.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
