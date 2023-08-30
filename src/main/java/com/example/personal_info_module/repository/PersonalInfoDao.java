package com.example.personal_info_module.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.personal_info_module.entity.PersonalInfo;

@Repository
public interface PersonalInfoDao extends JpaRepository<PersonalInfo, Integer>{
	
	@Query(value = "SELECT p.*, e.passport_number, e.passport_limit_date, e.resident_card_number, "
			+ "e.resident_card_start_date, e.resident_card_end_date, e.resident_card_status, "
			+ "e.telephone, e.cellphone, e.office_mail, e.other_mail, e.post_code, e.address, "
			+ "e.employment_insurance_number, e.pension_number, e.bank_name, e.headquarters, "
			+ "e.bank_account_number "
			+ "FROM personal_info "
			+ "LEFT JOIN employee_info e ON p.id = e.id "
			+ "WHERE (p.name LIKE %:inputName%) "
			+ "AND (p.name_katakana LIKE %:inputName%) "
			+ "AND (p.name_roma LIKE %:inputName%) "
			+ "AND (region LIKE %:inputRegion%) "
			+ "AND (sex = :inputSex OR :inputSex IS NUL) "
			+ "AND (available = :inputStatus OR :inputStatus IS NUL) "
			+ "ORDER BY 10 DESC ", nativeQuery = true)
	public List<Map<String, Object>> findNewsByTitleOrCategoryOrDatePagingF(@Param("inputName") String name,
			@Param("inputRegion") String region,@Param("inputSex") Boolean sex,@Param("inputStatus") Boolean status);

	@Query(value ="SELECT p.*, e.passport_number, e.passport_limit_date, e.resident_card_number, "
			+ "e.resident_card_start_date, e.resident_card_end_date, e.resident_card_status, "
			+ "e.telephone, e.cellphone, e.office_mail, e.other_mail, e.post_code, e.address, "
			+ "e.employment_insurance_number, e.pension_number, e.bank_name, e.headquarters, "
			+ "e.bank_account_number "
			+ "FROM personal_info p "
			+ "LEFT JOIN employee_info e ON p.id = e.id "
			+ "ORDER BY 1 ASC",nativeQuery =true)
	public List<Map<String, Object>> findAllInfo();
	
	
	@Query(value = "SELECT p.*, e.passport_number, e.passport_limit_date, e.resident_card_number, "
			+ "e.resident_card_start_date, e.resident_card_end_date, e.resident_card_status, "
			+ "e.telephone, e.cellphone, e.office_mail, e.other_mail, e.post_code, e.address, "
			+ "e.employment_insurance_number, e.pension_number, e.bank_name, e.headquarters, "
			+ "e.bank_account_number "
			+ "FROM personal_info p "
			+ "LEFT JOIN employee_info e ON p.id = e.id "
			+ "WHERE p.id = :inputId", nativeQuery = true)
	public List<Map<String, Object>> findInfoById(@Param("inputId") Integer id);
}
