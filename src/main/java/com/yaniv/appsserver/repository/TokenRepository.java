package com.yaniv.appsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaniv.appsserver.entity.Employee;
import com.yaniv.appsserver.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long>{

}