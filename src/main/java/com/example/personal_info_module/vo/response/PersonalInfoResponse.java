package com.example.personal_info_module.vo.response;

import java.time.LocalDate;

import com.example.personal_info_module.vo.request.PersonalInfoRequest;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PersonalInfoResponse {
	
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
	
	private PersonalInfoRequest reqP;
	
	private Boolean messageType;
	
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PersonalInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonalInfoResponse(Integer id, String myNumber, String name, String nameKatakana, String nameRoma,
			String region, Boolean sex, LocalDate birth, String age, LocalDate startDate, LocalDate endDate,
			Boolean available, String message) {
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
		this.message = message;
	}

	public PersonalInfoResponse(Integer id, String myNumber, String name, String nameKatakana, String nameRoma,
			String region, Boolean sex, LocalDate birth, String age, LocalDate startDate, LocalDate endDate,
			Boolean available) {
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
	}

	public PersonalInfoResponse(String message) {
		super();
		this.message = message;
	}

	public PersonalInfoRequest getReqP() {
		return reqP;
	}

	public void setReqP(PersonalInfoRequest reqP) {
		this.reqP = reqP;
	}

	public PersonalInfoResponse(PersonalInfoRequest reqP) {
		super();
		this.reqP = reqP;
	}

	public Boolean getMessageType() {
		return messageType;
	}

	public void setMessageType(Boolean messageType) {
		this.messageType = messageType;
	}

	public PersonalInfoResponse(Boolean messageType, String message) {
		super();
		this.messageType = messageType;
		this.message = message;
	}

	public PersonalInfoResponse(Integer id, String myNumber, String name, String nameKatakana, String nameRoma,
			String region, Boolean sex, LocalDate birth, String age, LocalDate startDate, LocalDate endDate,
			Boolean available, PersonalInfoRequest reqP, Boolean messageType, String message) {
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
		this.reqP = reqP;
		this.messageType = messageType;
		this.message = message;
	}

	
}
