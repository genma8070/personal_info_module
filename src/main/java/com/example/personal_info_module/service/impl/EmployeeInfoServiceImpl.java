package com.example.personal_info_module.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.personal_info_module.contants.Pattern;
import com.example.personal_info_module.contants.RtnCode;
import com.example.personal_info_module.entity.EmployeeInfo;
import com.example.personal_info_module.repository.EmployeeInfoDao;
import com.example.personal_info_module.service.ifs.EmployeeInfoService;
import com.example.personal_info_module.vo.request.EmployeeInfoRequest;
import com.example.personal_info_module.vo.response.EmployeeInfoResponse;

@Service
@Transactional(rollbackFor = Exception.class)
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
		String address = req.getAddress();
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
				otherMail, postCode, address, employmentInsuranceNumber, pensionNumber, bankName, headquarters,
				bankAccountNumber);
		employeeInfoDao.save(info);

		return new EmployeeInfoResponse(RtnCode.ACCOUNT_CREATE_SUCCESSFUL.getMessage());

	}

	@Override
	public EmployeeInfoResponse updateInfo(EmployeeInfoRequest req) {
		Integer id = req.getId();
		String officeMail = req.getOfficeMail();
		String otherMail = req.getOtherMail();
		String address = req.getAddress();
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

		if (officeMail == null || address == null || bankName == null || headquarters == null
				|| residentCardStatus == null || postCode == null || employmentInsuranceNumber == null
				|| pensionNumber == null || bankAccountNumber == null || telephone == null || cellphone == null
				|| passportNumber == null || residentCardNumber == null || passportLimitDate == null
				|| residentCardStartDate == null || residentCardEndDate == null) {
			return new EmployeeInfoResponse(RtnCode.CANNOT_EMPTY.getType(), RtnCode.CANNOT_EMPTY.getMessage());
		}
		
//		if (otherMail.isEmpty() || officeMail.isEmpty() || address.isEmpty() || bankName.isEmpty() || headquarters.isEmpty()
//				|| residentCardStatus == null || postCode.isEmpty() || employmentInsuranceNumber.isEmpty()
//				|| pensionNumber.isEmpty() || bankAccountNumber.isEmpty() || telephone.isEmpty() || cellphone.isEmpty()
//				|| passportNumber.isEmpty() || residentCardNumber.isEmpty() || passportLimitDate == null
//				|| residentCardStartDate == null || residentCardEndDate == null) {
//			return new EmployeeInfoResponse(RtnCode.CANNOT_EMPTY.getMessage());
//		}
		
		if (!officeMail.matches(Pattern.MAIL.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.MAIL.getType(), Pattern.MAIL.getMessage());
		}
		if (!otherMail.matches(Pattern.MAIL.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.MAIL.getType(), Pattern.MAIL.getMessage());
		}
		if (!address.matches(Pattern.ADDRESS.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.ADDRESS.getType(), Pattern.ADDRESS.getMessage());
		}
		if (!bankAccountNumber.matches(Pattern.BANK_ACCOUNT_NUMBER.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.BANK_ACCOUNT_NUMBER.getType(), Pattern.BANK_ACCOUNT_NUMBER.getMessage());
		}
		if (!bankName.matches(Pattern.BANK_NAME.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.BANK_NAME.getType(), Pattern.BANK_NAME.getMessage());
		}
		if (!cellphone.matches(Pattern.CELLPHONE.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.CELLPHONE.getType(), Pattern.CELLPHONE.getMessage());
		}
		if (!telephone.matches(Pattern.TELEPHONE.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.TELEPHONE.getType(), Pattern.TELEPHONE.getMessage());
		}
		if (!residentCardNumber.matches(Pattern.RESIDENT_CARD_NUMBER.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.RESIDENT_CARD_NUMBER.getType(), Pattern.RESIDENT_CARD_NUMBER.getMessage());
		}
		if (!pensionNumber.matches(Pattern.PENSION_NUMBER.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.PENSION_NUMBER.getType(), Pattern.PENSION_NUMBER.getMessage());
		}
		if (!passportNumber.matches(Pattern.PASSPORT_NUMBER.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.PASSPORT_NUMBER.getType(), Pattern.PASSPORT_NUMBER.getMessage());
		}
		if (!headquarters.matches(Pattern.HEADQUARTERS.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.HEADQUARTERS.getType(), Pattern.HEADQUARTERS.getMessage());
		}
		if (!postCode.matches(Pattern.POST_CODE.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.POST_CODE.getType(), Pattern.POST_CODE.getMessage());
		}
		if (!employmentInsuranceNumber.matches(Pattern.EMPLOYMENT_INSURANCE_NUMBER.getPattern())) {
		    return new EmployeeInfoResponse(Pattern.EMPLOYMENT_INSURANCE_NUMBER.getType(), Pattern.EMPLOYMENT_INSURANCE_NUMBER.getMessage());
		}
		

		EmployeeInfo info = new EmployeeInfo(id, passportNumber, passportLimitDate, residentCardNumber,
				residentCardStartDate, residentCardEndDate, residentCardStatus, telephone, cellphone, officeMail,
				otherMail, postCode, address, employmentInsuranceNumber, pensionNumber, bankName, headquarters,
				bankAccountNumber);
		employeeInfoDao.save(info);

		return new EmployeeInfoResponse(RtnCode.ACCOUNT_EDIT_SUCCESSFUL.getType(), RtnCode.ACCOUNT_EDIT_SUCCESSFUL.getMessage());

	}

}
