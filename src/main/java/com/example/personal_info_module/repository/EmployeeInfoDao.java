package com.example.personal_info_module.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.personal_info_module.entity.EmployeeInfo;

@Repository
public interface EmployeeInfoDao extends JpaRepository<EmployeeInfo, Integer>{
	
	@Query(value ="select * from main_categorys",nativeQuery =true)
	public List<Map<String, Object>> findAllMain();

}
