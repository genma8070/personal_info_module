package com.example.personal_info_module.vo.response;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FullInfoResponse {
	
	private FullInfoResponse res;
	
	private List<FullInfoResponse> list;

	private Integer id;

	private String myNumber;

	private String name;

	private String nameKatakana;

	private String nameRoma;

	private String region;

	private Boolean sex;

	private LocalDate birth;

	private String age;

	private LocalDate startDate;

	private LocalDate endDate;

	private Boolean available;

	private String passportNumber;

	private LocalDate passportLimitDate;

	private String residentCardNumber;

	private LocalDate residentCardStartDate;

	private LocalDate residentCardEndDate;

	private Boolean residentCardStatus;

	private String telephone;

	private String cellphone;

	private String officeMail;

	private String otherMail;

	private String postCode;

	private String address;

	private String employmentInsuranceNumber;

	private String pensionNumber;

	private String bankName;

	private String headquarters;

	private String bankAccountNumber;

	private String massage;

	public FullInfoResponse getRes() {
		return res;
	}

	public void setRes(FullInfoResponse res) {
		this.res = res;
	}

	public List<FullInfoResponse> getList() {
		return list;
	}

	public void setList(List<FullInfoResponse> list) {
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(String myNumber) {
		this.myNumber = myNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameKatakana() {
		return nameKatakana;
	}

	public void setNameKatakana(String nameKatakana) {
		this.nameKatakana = nameKatakana;
	}

	public String getNameRoma() {
		return nameRoma;
	}

	public void setNameRoma(String nameRoma) {
		this.nameRoma = nameRoma;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public LocalDate getPassportLimitDate() {
		return passportLimitDate;
	}

	public void setPassportLimitDate(LocalDate passportLimitDate) {
		this.passportLimitDate = passportLimitDate;
	}

	public String getResidentCardNumber() {
		return residentCardNumber;
	}

	public void setResidentCardNumber(String residentCardNumber) {
		this.residentCardNumber = residentCardNumber;
	}

	public LocalDate getResidentCardStartDate() {
		return residentCardStartDate;
	}

	public void setResidentCardStartDate(LocalDate residentCardStartDate) {
		this.residentCardStartDate = residentCardStartDate;
	}

	public LocalDate getResidentCardEndDate() {
		return residentCardEndDate;
	}

	public void setResidentCardEndDate(LocalDate residentCardEndDate) {
		this.residentCardEndDate = residentCardEndDate;
	}

	public Boolean getResidentCardStatus() {
		return residentCardStatus;
	}

	public void setResidentCardStatus(Boolean residentCardStatus) {
		this.residentCardStatus = residentCardStatus;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getOfficeMail() {
		return officeMail;
	}

	public void setOfficeMail(String officeMail) {
		this.officeMail = officeMail;
	}

	public String getOtherMail() {
		return otherMail;
	}

	public void setOtherMail(String otherMail) {
		this.otherMail = otherMail;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmploymentInsuranceNumber() {
		return employmentInsuranceNumber;
	}

	public void setEmploymentInsuranceNumber(String employmentInsuranceNumber) {
		this.employmentInsuranceNumber = employmentInsuranceNumber;
	}

	public String getPensionNumber() {
		return pensionNumber;
	}

	public void setPensionNumber(String pensionNumber) {
		this.pensionNumber = pensionNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public FullInfoResponse(FullInfoResponse res, List<FullInfoResponse> list, Integer id, String myNumber, String name,
			String nameKatakana, String nameRoma, String region, Boolean sex, LocalDate birth, String age,
			LocalDate startDate, LocalDate endDate, Boolean available, String passportNumber,
			LocalDate passportLimitDate, String residentCardNumber, LocalDate residentCardStartDate,
			LocalDate residentCardEndDate, Boolean residentCardStatus, String telephone, String cellphone,
			String officeMail, String otherMail, String postCode, String address, String employmentInsuranceNumber,
			String pensionNumber, String bankName, String headquarters, String bankAccountNumber, String massage) {
		super();
		this.res = res;
		this.list = list;
		this.id = id;
		this.myNumber = myNumber;
		this.name = name;
		this.nameKatakana = nameKatakana;
		this.nameRoma = nameRoma;
		this.region = region;
		this.sex = sex;
		this.birth = birth;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.available = available;
		this.passportNumber = passportNumber;
		this.passportLimitDate = passportLimitDate;
		this.residentCardNumber = residentCardNumber;
		this.residentCardStartDate = residentCardStartDate;
		this.residentCardEndDate = residentCardEndDate;
		this.residentCardStatus = residentCardStatus;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.officeMail = officeMail;
		this.otherMail = otherMail;
		this.postCode = postCode;
		this.address = address;
		this.employmentInsuranceNumber = employmentInsuranceNumber;
		this.pensionNumber = pensionNumber;
		this.bankName = bankName;
		this.headquarters = headquarters;
		this.bankAccountNumber = bankAccountNumber;
		this.massage = massage;
	}

	public FullInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullInfoResponse(Integer id, String myNumber, String name, String nameKatakana, String nameRoma,
			String region, Boolean sex, LocalDate birth, String age, LocalDate startDate, LocalDate endDate,
			Boolean available, String passportNumber, LocalDate passportLimitDate, String residentCardNumber,
			LocalDate residentCardStartDate, LocalDate residentCardEndDate, Boolean residentCardStatus,
			String telephone, String cellphone, String officeMail, String otherMail, String postCode, String address,
			String employmentInsuranceNumber, String pensionNumber, String bankName, String headquarters,
			String bankAccountNumber) {
		super();
		this.id = id;
		this.myNumber = myNumber;
		this.name = name;
		this.nameKatakana = nameKatakana;
		this.nameRoma = nameRoma;
		this.region = region;
		this.sex = sex;
		this.birth = birth;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.available = available;
		this.passportNumber = passportNumber;
		this.passportLimitDate = passportLimitDate;
		this.residentCardNumber = residentCardNumber;
		this.residentCardStartDate = residentCardStartDate;
		this.residentCardEndDate = residentCardEndDate;
		this.residentCardStatus = residentCardStatus;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.officeMail = officeMail;
		this.otherMail = otherMail;
		this.postCode = postCode;
		this.address = address;
		this.employmentInsuranceNumber = employmentInsuranceNumber;
		this.pensionNumber = pensionNumber;
		this.bankName = bankName;
		this.headquarters = headquarters;
		this.bankAccountNumber = bankAccountNumber;
	}

	public FullInfoResponse(List<FullInfoResponse> list) {
		super();
		this.list = list;
	}

	public FullInfoResponse(FullInfoResponse res) {
		super();
		this.res = res;
	}

	public FullInfoResponse(String massage) {
		super();
		this.massage = massage;
	}

}
