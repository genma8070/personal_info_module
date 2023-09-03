package com.example.personal_info_module.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal_info")
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "my_number")
	private String myNumber;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "name_katakana")
	private String nameKatakana;
	
	@Column(name = "name_roma")
	private String nameRoma;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "sex")
	private Boolean sex;
	
	@Column(name = "birth")
	private LocalDate birth ;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "available")
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

	public PersonalInfo(Integer id, String myNumber, String name, String nameKatakana, String nameRoma, String region,
			Boolean sex, LocalDate birth, String age, LocalDate startDate, LocalDate endDate, Boolean available) {
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

	public PersonalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonalInfo(String myNumber, String name, String nameKatakana, String nameRoma, String region, Boolean sex,
			LocalDate birth, String age, LocalDate startDate, LocalDate endDate, Boolean available) {
		super();
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
	
}
