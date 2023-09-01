package com.example.personal_info_module.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_info")
public class EmployeeInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "passport_number")
	private String passportNumber;
	
	@Column(name = "passport_limit_date")
	private LocalDate passportLimitDate;
	
	@Column(name = "resident_card_number")
	private String residentCardNumber;
	
	@Column(name = "resident_card_start_date")
	private LocalDate residentCardStartDate;
	
	@Column(name = "resident_card_end_date")
	private LocalDate residentCardEndDate;
	
	@Column(name = "resident_card_status")
	private Boolean residentCardStatus;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "cellphone")
	private String cellphone;
	
	@Column(name = "office_mail")
	private String officeMail;
	
	@Column(name = "other_mail")
	private String otherMail;
	
	@Column(name = "post_code")
	private String postCode;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "employment_insurance_number")
	private String employmentInsuranceNumber;
	
	@Column(name = "pension_number")
	private String pensionNumber;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "headquarters")
	private String headquarters;
	
	@Column(name = "bank_account_number")
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

	public EmployeeInfo(Integer id, String passportNumber, LocalDate passportLimitDate, String residentCardNumber,
			LocalDate residentCardStartDate, LocalDate residentCardEndDate, Boolean residentCardStatus,
			String telephone, String cellphone, String officeMail, String otherMail, String postCode, String address,
			String employmentInsuranceNumber, String pensionNumber, String bankName, String headquarters,
			String bankAccountNumber) {
		super();
		this.id = id;
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

	public EmployeeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
