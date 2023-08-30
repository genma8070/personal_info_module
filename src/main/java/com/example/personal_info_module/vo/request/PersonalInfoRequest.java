package com.example.personal_info_module.vo.request;

import java.time.LocalDate;

public class PersonalInfoRequest {

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

	
}
