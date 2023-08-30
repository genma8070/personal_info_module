package com.example.personal_info_module.vo.request;

import java.time.LocalDate;

public class EmployeeInfoRequest {

	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
}
