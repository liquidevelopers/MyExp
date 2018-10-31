package com.yaniv.appsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaniv.appsserver.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}