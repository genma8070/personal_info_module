package com.example.personal_info_module.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

	public EmployeeInfoResponse findInfoF(Integer id) {

		List<Map<String, Object>> res = employeeInfoDao.findEReqById(id);
		EmployeeInfoRequest e = new EmployeeInfoRequest();
		for (Map<String, Object> map : res) {

			for (String item : map.keySet()) {
				switch (item) {
				case "id":
					e.setId((Integer) map.get(item));
					break;
				case "passport_number":
					if (map.get(item) == null) {
						e.setPassportNumber(null);
						break;
					}
					e.setPassportNumber((String) map.get(item));
					break;
				case "telephone":
					if (map.get(item) == null) {
						e.setTelephone(null);
						break;
					}
					e.setTelephone((String) map.get(item));
					break;
				case "cellphone":
					if (map.get(item) == null) {
						e.setCellphone(null);
						break;
					}
					e.setCellphone((String) map.get(item));
					break;
				case "resident_card_number":
					if (map.get(item) == null) {
						e.setResidentCardNumber(null);
						break;
					}
					e.setResidentCardNumber((String) map.get(item));
					break;
				case "post_code":
					if (map.get(item) == null) {
						e.setPostCode(null);
						break;
					}
					e.setPostCode((String) map.get(item));
					break;
				case "employment_insurance_number":
					if (map.get(item) == null) {
						e.setEmploymentInsuranceNumber(null);
						break;
					}
					e.setEmploymentInsuranceNumber((String) map.get(item));
					break;
				case "pension_number":
					if (map.get(item) == null) {
						e.setPensionNumber(null);
						break;
					}
					e.setPensionNumber((String) map.get(item));
					break;
				case "bank_account_number":
					if (map.get(item) == null) {
						e.setBankAccountNumber(null);
						break;
					}
					e.setBankAccountNumber((String) map.get(item));
					break;
				case "office_mail":
					if (map.get(item) == null) {
						e.setOfficeMail(null);
						break;
					}
					e.setOfficeMail((String) map.get(item));
					break;
				case "other_mail":
					if (map.get(item) == null) {
						e.setOtherMail(null);
						break;
					}
					e.setOtherMail((String) map.get(item));
					break;
				case "address":
					if (map.get(item) == null) {
						e.setAddress(null);
						break;
					}
					e.setAddress((String) map.get(item));
					break;
				case "bank_name":
					if (map.get(item) == null) {
						e.setBankName(null);
						break;
					}
					e.setBankName((String) map.get(item));
					break;
				case "headquarters":
					if (map.get(item) == null) {
						e.setHeadquarters(null);
						break;
					}
					e.setHeadquarters((String) map.get(item));
					break;
				case "passport_limit_date":
					if (map.get(item) == null) {
						e.setPassportLimitDate(null);
						break;
					}
					e.setPassportLimitDate(((Date) map.get(item)).toLocalDate());
					break;
				case "resident_card_start_date":
					if (map.get(item) == null) {
						e.setResidentCardStartDate(null);
						break;
					}
					e.setResidentCardStartDate(((Date) map.get(item)).toLocalDate());
					break;
				case "resident_card_end_date":
					if (map.get(item) == null) {
						e.setResidentCardEndDate(null);
						break;
					}
					e.setResidentCardEndDate(((Date) map.get(item)).toLocalDate());
					break;
				case "resident_card_status":
					if (map.get(item) != null) {
						Object value3 = map.get(item);
						int intValue3 = Integer.parseInt(value3.toString());
						if (intValue3 == 0) {
							e.setResidentCardStatus(false);
						} else {
							e.setResidentCardStatus(true);
						}
					} else {
						e.setResidentCardStatus(null);
					}

					break;
				}
			}
		}
		return new EmployeeInfoResponse(e);
	}

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

		EmployeeInfo info = new EmployeeInfo(id, passportNumber, passportLimitDate, residentCardNumber,
				residentCardStartDate, residentCardEndDate, residentCardStatus, telephone, cellphone, officeMail,
				otherMail, postCode, adress, employmentInsuranceNumber, pensionNumber, bankName, headquarters,
				bankAccountNumber);
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

		if (officeMail == null || adress == null || bankName == null || headquarters == null
				|| residentCardStatus == null || postCode == null || employmentInsuranceNumber == null
				|| pensionNumber == null || bankAccountNumber == null || telephone == null || cellphone == null
				|| passportNumber == null || residentCardNumber == null || passportLimitDate == null
				|| residentCardStartDate == null || residentCardEndDate == null) {
			return new EmployeeInfoResponse("必填欄位不得有空");
		}

		EmployeeInfo info = new EmployeeInfo(id, passportNumber, passportLimitDate, residentCardNumber,
				residentCardStartDate, residentCardEndDate, residentCardStatus, telephone, cellphone, officeMail,
				otherMail, postCode, adress, employmentInsuranceNumber, pensionNumber, bankName, headquarters,
				bankAccountNumber);
		employeeInfoDao.save(info);

		return new EmployeeInfoResponse("更新成功");

	}

}
