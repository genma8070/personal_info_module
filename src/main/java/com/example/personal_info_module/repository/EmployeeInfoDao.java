package com.example.personal_info_module.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.personal_info_module.entity.EmployeeInfo;

@Repository
public interface EmployeeInfoDao extends JpaRepository<EmployeeInfo, Integer>{
	
	@Query(value = "SELECT * FROM employee_info p WHERE p.id = :inputId", nativeQuery = true)
	public List<Map<String, Object>> findEReqById(@Param("inputId") Integer id);
}
