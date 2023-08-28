package com.example.personal_info_module.vo.response;

import java.util.List;

import com.example.personal_info_module.entity.MainCategory;

public class MainCategoryResponse {

	private Integer mainId;

	private String mainTitle;
	
	private String message;
	
	private List<MainCategory> list;
	private List<MainCategoryResponse> list2;
	

	public Integer getMainId() {
		return mainId;
	}

	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public MainCategoryResponse(Integer mainId, String mainTitle) {
		super();
		this.mainId = mainId;
		this.mainTitle = mainTitle;
	}

	public MainCategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<MainCategory> getList() {
		return list;
	}

	public void setList(List<MainCategory> list) {
		this.list = list;
	}

	public MainCategoryResponse(Integer mainId, String mainTitle, String message, List<MainCategory> list) {
		super();
		this.mainId = mainId;
		this.mainTitle = mainTitle;
		this.message = message;
		this.list = list;
	}



	public MainCategoryResponse(String message) {
		super();
		this.message = message;
	}

	public List<MainCategoryResponse> getList2() {
		return list2;
	}

	public void setList2(List<MainCategoryResponse> list2) {
		this.list2 = list2;
	}

	public MainCategoryResponse(List<MainCategoryResponse> list2) {
		super();
		this.list2 = list2;
	}

}
