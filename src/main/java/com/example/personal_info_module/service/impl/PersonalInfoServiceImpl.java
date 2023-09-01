package com.example.personal_info_module.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_info_module.entity.PersonalInfo;
import com.example.personal_info_module.repository.EmployeeInfoDao;
import com.example.personal_info_module.repository.PersonalInfoDao;
import com.example.personal_info_module.service.ifs.PersonalInfoService;
import com.example.personal_info_module.vo.request.PersonalInfoRequest;
import com.example.personal_info_module.vo.response.FullInfoResponse;
import com.example.personal_info_module.vo.response.PersonalInfoResponse;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

	@Autowired
	private PersonalInfoDao personalInfoDao;

	@Autowired
	private EmployeeInfoDao employeeInfoDao;
	
	@Override
	public PersonalInfoResponse findInfoP(Integer id) {
		List<Map<String, Object>> res = personalInfoDao.findPReqById(id);
		PersonalInfoRequest e = new PersonalInfoRequest();
		for (Map<String, Object> map : res) {

			for (String item : map.keySet()) {
				switch (item) {
				case "id":
					e.setId((Integer) map.get(item));
					break;
				case "my_number":
					if (map.get(item) == null) {
						e.setMyNumber(null);
						break;
					}
					e.setMyNumber((String) map.get(item));
					break;
				case "age":
					e.setAge((String) map.get(item));
					break;
				case "name":
					e.setName((String) map.get(item));
					break;
				case "name_katakana":
					e.setNameKatakana((String) map.get(item));
					break;
				case "name_roma":
					e.setNameRoma((String) map.get(item));
					break;
				case "region":
					e.setRegion((String) map.get(item));
					break;			
				case "birth":
					e.setBirth(((Date) map.get(item)).toLocalDate());
					break;
				case "start_date":
					e.setStartDate(((Date) map.get(item)).toLocalDate());
					break;
				case "end_date":
					if (map.get(item) == null) {
						e.setEndDate(null);
						break;
					}
					e.setEndDate(((Date) map.get(item)).toLocalDate());
					break;
				
				case "sex":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setSex(false);
					} else {
						e.setSex(true);
					}
					break;
				case "available":
					Object value2 = map.get(item);
					int intValue2 = Integer.parseInt(value2.toString());
					if (intValue2 == 0) {
						e.setAvailable(false);
					} else {
						e.setAvailable(true);
					}
					break;
				}
			}
		}
		return new PersonalInfoResponse(e);
	}

	@Override
	public PersonalInfoResponse addInfo(PersonalInfoRequest req) {
		Integer id = null;
		String name = req.getName();
		String nameKatakana = req.getNameKatakana();
		String nameRoma = req.getNameRoma();
		String region = req.getRegion();
		Boolean sex = req.getSex();
		Boolean available = false;
		String myNumber = req.getMyNumber();
		String age = req.getAge();
		LocalDate brith = req.getBirth();
		LocalDate startDate = req.getStartDate();
		LocalDate endDate = null;

		if (name.isEmpty() || nameKatakana.isEmpty() || nameRoma.isEmpty() || region.isEmpty() || age.isEmpty()
				|| brith == null || startDate == null) {
			return new PersonalInfoResponse("必填欄位不得有空");
		}

		if (sex == null) {
			return new PersonalInfoResponse("請選擇性別");
		}

		available = (!myNumber.isEmpty());

		PersonalInfo info = new PersonalInfo(id, myNumber, name, nameKatakana, nameRoma, region, sex, brith, age,
				startDate, endDate, available);
		personalInfoDao.save(info);

		return new PersonalInfoResponse("新增成功");

	}

	@Override
	public PersonalInfoResponse updateInfo(PersonalInfoRequest req) {
		Integer id = req.getId();
		String name = req.getName();
		String nameKatakana = req.getNameKatakana();
		String nameRoma = req.getNameRoma();
		String region = req.getRegion();
		Boolean sex = req.getSex();
		Boolean available;
		String myNumber = req.getMyNumber();
		String age = req.getAge();
		LocalDate brith = req.getBirth();
		LocalDate startDate = req.getStartDate();
		LocalDate endDate = req.getEndDate();

		if (name.isEmpty() || nameKatakana.isEmpty() || nameRoma.isEmpty() || region.isEmpty() || age.isEmpty()
				|| brith == null || startDate == null) {
			return new PersonalInfoResponse("必填欄位不得有空");
		}

		if (sex == null) {
			return new PersonalInfoResponse("請選擇性別");
		}
		
		if (endDate == null) {
			endDate = null;
		}
		
		available = (myNumber != null && endDate == null);
		

		PersonalInfo info = new PersonalInfo(id, myNumber, name, nameKatakana, nameRoma, region, sex, brith, age,
				startDate, endDate, available);
		personalInfoDao.save(info);

		return new PersonalInfoResponse("更新成功");

	}

	@Override
	public PersonalInfoResponse deleteInfo(PersonalInfoRequest req) {
		List<Map<String, Object>> res = personalInfoDao.findInfoById(req.getId());
		PersonalInfo e = new PersonalInfo();
		for (Map<String, Object> map : res) {

			for (String item : map.keySet()) {
				switch (item) {
				case "id":
					e.setId((Integer) map.get(item));
					break;
				case "my_number":
					if (map.get(item) == null) {
						e.setMyNumber(null);
						break;
					}
					e.setMyNumber((String) map.get(item));
					break;
				case "age":
					e.setAge((String) map.get(item));
					break;

				case "name":
					e.setName((String) map.get(item));
					break;
				case "name_katakana":
					e.setNameKatakana((String) map.get(item));
					break;
				case "name_roma":
					e.setNameRoma((String) map.get(item));
					break;

				case "region":
					e.setRegion((String) map.get(item));
					break;

				case "birth":
					e.setBirth(((Date) map.get(item)).toLocalDate());
					break;
				case "start_date":
					e.setStartDate(((Date) map.get(item)).toLocalDate());
					break;
				case "end_date":
					if (map.get(item) == null) {
						e.setEndDate(null);
						break;
					}
					e.setEndDate(((Date) map.get(item)).toLocalDate());
					break;

				case "sex":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setSex(false);
					} else {
						e.setSex(true);
					}
					break;
				case "available":

					e.setAvailable(false);

					break;

				}
			}
		}
		personalInfoDao.save(e);

		return new PersonalInfoResponse("刪除成功");

	}

	@Override
	public FullInfoResponse getAllInfo() {
		List<FullInfoResponse> eList = new ArrayList<FullInfoResponse>();

		List<Map<String, Object>> res = personalInfoDao.findAllInfo();

		for (Map<String, Object> map : res) {
			FullInfoResponse e = new FullInfoResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "id":
					e.setId((Integer) map.get(item));
					break;
				case "my_number":
					if (map.get(item) == null) {
						e.setMyNumber(null);
						break;
					}
					e.setMyNumber((String) map.get(item));
					break;
				case "age":
					e.setAge((String) map.get(item));
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
				case "name":
					e.setName((String) map.get(item));
					break;
				case "name_katakana":
					e.setNameKatakana((String) map.get(item));
					break;
				case "name_roma":
					e.setNameRoma((String) map.get(item));
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
				case "region":
					e.setRegion((String) map.get(item));
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
				case "birth":
					e.setBirth(((Date) map.get(item)).toLocalDate());
					break;
				case "start_date":
					e.setStartDate(((Date) map.get(item)).toLocalDate());
					break;
				case "end_date":
					if (map.get(item) == null) {
						e.setEndDate(null);
						break;
					}
					e.setEndDate(((Date) map.get(item)).toLocalDate());
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
				case "sex":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setSex(false);
					} else {
						e.setSex(true);
					}
					break;
				case "available":
					Object value2 = map.get(item);
					int intValue2 = Integer.parseInt(value2.toString());
					if (intValue2 == 0) {
						e.setAvailable(false);
					} else {
						e.setAvailable(true);
					}
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

			eList.add(e);
		}
		if (eList.size() == 0) {
			return new FullInfoResponse("查無資料");
		}
		return new FullInfoResponse(eList);
	}

	@Override
	public FullInfoResponse getNewstInfo() {

		List<Map<String, Object>> res = personalInfoDao.findNewstInfo();
		FullInfoResponse e = new FullInfoResponse();
		for (Map<String, Object> map : res) {

			for (String item : map.keySet()) {
				switch (item) {
				case "id":
					e.setId((Integer) map.get(item));
					break;
				case "my_number":
					if (map.get(item) == null) {
						e.setMyNumber(null);
						break;
					}
					e.setMyNumber((String) map.get(item));
					break;
				case "age":
					e.setAge((String) map.get(item));
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
				case "name":
					e.setName((String) map.get(item));
					break;
				case "name_katakana":
					e.setNameKatakana((String) map.get(item));
					break;
				case "name_roma":
					e.setNameRoma((String) map.get(item));
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
				case "region":
					e.setRegion((String) map.get(item));
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
				case "birth":
					e.setBirth(((Date) map.get(item)).toLocalDate());
					break;
				case "start_date":
					e.setStartDate(((Date) map.get(item)).toLocalDate());
					break;
				case "end_date":
					if (map.get(item) == null) {
						e.setEndDate(null);
						break;
					}
					e.setEndDate(((Date) map.get(item)).toLocalDate());
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
				case "sex":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setSex(false);
					} else {
						e.setSex(true);
					}
					break;
				case "available":
					Object value2 = map.get(item);
					int intValue2 = Integer.parseInt(value2.toString());
					if (intValue2 == 0) {
						e.setAvailable(false);
					} else {
						e.setAvailable(true);
					}
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

		return new FullInfoResponse(e);
	}

	@Override
	public FullInfoResponse findInfoById(Integer id) {

		List<Map<String, Object>> res = personalInfoDao.findInfoById(id);
		FullInfoResponse e = new FullInfoResponse();
		for (Map<String, Object> map : res) {

			for (String item : map.keySet()) {
				switch (item) {
				case "id":
					e.setId((Integer) map.get(item));
					break;
				case "my_number":
					if (map.get(item) == null) {
						e.setMyNumber(null);
						break;
					}
					e.setMyNumber((String) map.get(item));
					break;
				case "age":
					e.setAge((String) map.get(item));
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
				case "name":
					e.setName((String) map.get(item));
					break;
				case "name_katakana":
					e.setNameKatakana((String) map.get(item));
					break;
				case "name_roma":
					e.setNameRoma((String) map.get(item));
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
				case "region":
					e.setRegion((String) map.get(item));
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
				case "birth":
					e.setBirth(((Date) map.get(item)).toLocalDate());
					break;
				case "start_date":
					e.setStartDate(((Date) map.get(item)).toLocalDate());
					break;
				case "end_date":
					if (map.get(item) == null) {
						e.setEndDate(null);
						break;
					}
					e.setEndDate(((Date) map.get(item)).toLocalDate());
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
				case "sex":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setSex(false);
					} else {
						e.setSex(true);
					}
					break;
				case "available":
					Object value2 = map.get(item);
					int intValue2 = Integer.parseInt(value2.toString());
					if (intValue2 == 0) {
						e.setAvailable(false);
					} else {
						e.setAvailable(true);
					}
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
		return e;
	}

	public FullInfoResponse search(PersonalInfoRequest req) {
		String name = req.getName();
		Boolean sex = req.getSex();
		Boolean availalbe = req.getAvailable();
		String region = req.getRegion();
		List<FullInfoResponse> eList = new ArrayList<FullInfoResponse>();

		List<Map<String, Object>> res = personalInfoDao.findInfoByNameAndRegionAndSexAndAvailable(name, region, sex,
				availalbe);

		for (Map<String, Object> map : res) {
			FullInfoResponse e = new FullInfoResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "id":
					e.setId((Integer) map.get(item));
					break;
				case "my_number":
					if (map.get(item) == null) {
						e.setMyNumber(null);
						break;
					}
					e.setMyNumber((String) map.get(item));
					break;
				case "age":
					e.setAge((String) map.get(item));
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
				case "name":
					e.setName((String) map.get(item));
					break;
				case "name_katakana":
					e.setNameKatakana((String) map.get(item));
					break;
				case "name_roma":
					e.setNameRoma((String) map.get(item));
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
				case "region":
					e.setRegion((String) map.get(item));
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
				case "birth":
					e.setBirth(((Date) map.get(item)).toLocalDate());
					break;
				case "start_date":
					e.setStartDate(((Date) map.get(item)).toLocalDate());
					break;
				case "end_date":
					if (map.get(item) == null) {
						e.setEndDate(null);
						break;
					}
					e.setEndDate(((Date) map.get(item)).toLocalDate());
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
				case "sex":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setSex(false);
					} else {
						e.setSex(true);
					}
					break;
				case "available":
					Object value2 = map.get(item);
					int intValue2 = Integer.parseInt(value2.toString());
					if (intValue2 == 0) {
						e.setAvailable(false);
					} else {
						e.setAvailable(true);
					}
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

			eList.add(e);
		}

		if (eList.size() == 0) {
			return new FullInfoResponse("查無資料");
		}
		return new FullInfoResponse(eList);
	}

}
