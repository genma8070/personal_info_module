package com.example.personal_info_module.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_info_module.entity.EmployeeInfo;
import com.example.personal_info_module.repository.EmployeeInfoDao;
import com.example.personal_info_module.service.ifs.EmployeeInfoService;
import com.example.personal_info_module.vo.request.EmployeeInfoRequest;
import com.example.personal_info_module.vo.response.EmployeeInfoResponse;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Autowired
	private EmployeeInfoDao employeeInfoDao;
	
	@Override
	public EmployeeInfoResponse addInfo(EmployeeInfoRequest req) {
		Integer id = null;
		String officeMail = req.getOfficeMail();
		String otherMail = req.getOtherMail();
		String adress = req.getAddress();
		String bankName = req.getBankName();
		String headquarters = req.getHeadquarters();
		Boolean residentCardStatus = req.getResidentCardStatus();
		String postCode = req.getPostCode();
		String employmentInsuranceNumber = req.getEmploymentInsuranceNumber();
		String pensionNumber = req.getPensionNumber();
		String bankAccountNumber = req.getBankAccountNumber();
		String telephone = req.getTelephone();
		String cellphone = req.getCellphone();
		String passportNumber = req.getPassportNumber();
		String residentCardNumber = req.getResidentCardNumber();
		LocalDate passportLimitDate = req.getPassportLimitDate();
		LocalDate residentCardStartDate = req.getResidentCardStartDate();
		LocalDate residentCardEndDate = req.getResidentCardEndDate();
		
		if (officeMail.isEmpty() || adress.isEmpty() || bankName.isEmpty()
				 || headquarters.isEmpty() || residentCardStatus == null || postCode == null
				 || employmentInsuranceNumber == null || pensionNumber == null
				 || bankAccountNumber == null || telephone == null || cellphone == null
				 || passportNumber == null || residentCardNumber == null
				 || passportLimitDate == null || residentCardStartDate == null
				 || residentCardEndDate == null) {
			return new EmployeeInfoResponse("必填欄位不得有空");
		}
		
		
		EmployeeInfo info = new EmployeeInfo(id, passportNumber, passportLimitDate,
				residentCardNumber,	residentCardStartDate, residentCardEndDate, 
				residentCardStatus, telephone, cellphone, officeMail, otherMail,
				postCode, adress, employmentInsuranceNumber, pensionNumber,
				bankName, headquarters, bankAccountNumber);
		employeeInfoDao.save(info);
				
		return new EmployeeInfoResponse("新增成功");

	}

	@Override
	public EmployeeInfoResponse updateInfo(EmployeeInfoRequest req) {
		Integer id = req.getId();
		String officeMail = req.getOfficeMail();
		String otherMail = req.getOtherMail();
		String adress = req.getAddress();
		String bankName = req.getBankName();
		String headquarters = req.getHeadquarters();
		Boolean residentCardStatus = req.getResidentCardStatus();
		String postCode = req.getPostCode();
		String employmentInsuranceNumber = req.getEmploymentInsuranceNumber();
		String pensionNumber = req.getPensionNumber();
		String bankAccountNumber = req.getBankAccountNumber();
		String telephone = req.getTelephone();
		String cellphone = req.getCellphone();
		String passportNumber = req.getPassportNumber();
		String residentCardNumber = req.getResidentCardNumber();
		LocalDate passportLimitDate = req.getPassportLimitDate();
		LocalDate residentCardStartDate = req.getResidentCardStartDate();
		LocalDate residentCardEndDate = req.getResidentCardEndDate();
		
		if (officeMail.isEmpty() || adress.isEmpty() || bankName.isEmpty()
				 || headquarters.isEmpty() || residentCardStatus == null || postCode == null
				 || employmentInsuranceNumber == null || pensionNumber == null
				 || bankAccountNumber == null || telephone == null || cellphone == null
				 || passportNumber == null || residentCardNumber == null
				 || passportLimitDate == null || residentCardStartDate == null
				 || residentCardEndDate == null) {
			return new EmployeeInfoResponse("必填欄位不得有空");
		}
		
		EmployeeInfo info = new EmployeeInfo(id, passportNumber, passportLimitDate,
				residentCardNumber,	residentCardStartDate, residentCardEndDate, 
				residentCardStatus, telephone, cellphone, officeMail, otherMail,
				postCode, adress, employmentInsuranceNumber, pensionNumber,
				bankName, headquarters, bankAccountNumber);
		employeeInfoDao.save(info);
		
		return new EmployeeInfoResponse("更新成功");

	}
	

}
